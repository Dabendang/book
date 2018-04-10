package edu.fjut.bookshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerCode;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.dao.*;
import edu.fjut.bookshop.domain.Order;
import edu.fjut.bookshop.domain.OrderExample;
import edu.fjut.bookshop.domain.Shopcart;
import edu.fjut.bookshop.domain.User;
import edu.fjut.bookshop.service.UserService;
import edu.fjut.bookshop.utils.IDUtil;
import edu.fjut.bookshop.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by dabendan on 2018/3/24.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private ShopcartMapper shopcartMapper;

    @Override
    public ServerResponse<Map> register(User user) {

         if(!this.checkUsername(user.getUsername())){
             return ServerResponse.createByErrorMsgData("用 户 名 已 存 在!",null);
         };

        user.setLogpassword(MD5Util.MD5EncodeUtf8(user.getLogpassword()));//初始化登陆密码
        user.setPaypassword(MD5Util.MD5EncodeUtf8(user.getPaypassword()));//初始化支付密码
        user.setBalance(new BigDecimal("0"));//初始化余额
        user.setStatus("N");        ;//初始化会员状态
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        //生成随机11位数主键
        user.setUserid(IDUtil.getFixLenthString(BookShopConst.DEFAULT_ID_LENGTH));
        int resultCount = userMapper.insert(user);
        if(resultCount>0){
            return ServerResponse.createBySuccessMsgData("注 册 成 功!",null);
        }
        return ServerResponse.createByErrorMsgData("注 册 失 败",null);
    }

    @Override
    public Boolean checkUsername(String username) {
        if(StringUtils.isBlank(username)){
            return false;
        }
        System.out.println(username);
        return userMapper.checkUsername(username)<=0;
    }

    @Override
    public ServerResponse<User> login(String username, String logPassword) {

        if(username==null || logPassword==null){
            return ServerResponse.createByErrorCodeMsg(ServerCode.ILLEGAL_ARGUMENTS.getCode(),"用 户 名 和 密 码 不 能 为 空!");
        }

        Integer resultCount=userMapper.checkUsername(username);
        if(resultCount<=0){
            return ServerResponse.createByErrorMsg("用 户 不 存 在!");
        }
        String dbLogPassword=userMapper.selectLogPasswordByUserName(username);
        String md5Password = MD5Util.MD5EncodeUtf8(logPassword);
        if(!dbLogPassword.equals(md5Password)) {
            return ServerResponse.createByErrorMsg("密 码 不 正 确");
        }


        String userId=userMapper.selectUserIdByUserName(username);

        User user=userMapper.selectByUserNameAndLOGPwd(username,md5Password);

        user.setLogpassword(null);
        user.setPaypassword(null);

        return ServerResponse.createBySuccessMsgData("登 入 成 功!",user);
    }


    @Override
    public User getUserInfo(String userid) {

        User user = userMapper.selectByPrimaryKey(userid);

        return user;
    }


    @Override
    public void update(User user) {

        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public ServerResponse<Map> updatePass(User user) {

        userMapper.updateByPrimaryKeySelective(user);

        return ServerResponse.createBySuccessMsgData("修 改 成 功",null);

    }

    @Override
    public PageInfo getUserOrder(Integer pageNum, Integer pageSize, String userid) {

        PageHelper.startPage(pageNum,pageSize);
        User user = userMapper.selectByPrimaryKey(userid);

        List<Order> orderList=orderMapper.selectEqualsToUsername(user.getUsername());

        //封装了详细的分页信息,
        PageInfo pageInfo = new PageInfo(orderList, BookShopConst.navigatePages);
        return pageInfo;
    }

    @Override
    public PageInfo getUserShopcart(Integer pageNum, Integer pageSize, String userid) {

        PageHelper.startPage(pageNum,pageSize);
        User user = userMapper.selectByPrimaryKey(userid);

        List<Shopcart> shopcartList=shopcartMapper.selectEqualsToUsername(user.getUsername());

        //封装了详细的分页信息,
        PageInfo pageInfo = new PageInfo(shopcartList, BookShopConst.navigatePages);
        return pageInfo;
    }

    @Override
    public ServerResponse updateBalanceADD(String userid, BigDecimal money) {

        Integer result=userMapper.updateBalanceByUseridADD(userid,money);

        if(result!=null && result>0){
            return ServerResponse.createBySuccessMsg("退 款 成 功");
        }
        return ServerResponse.createByErrorMsg("服 务 器 忙,请 稍 后 再 试!");
    }


    public String checkStatus(String username, String password){
        return userMapper.selectStatusByUserNameAndLOGPwd(username,password);
    }


}
