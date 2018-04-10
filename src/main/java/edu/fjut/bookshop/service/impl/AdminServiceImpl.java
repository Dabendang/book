package edu.fjut.bookshop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.BookShopConst;
import edu.fjut.bookshop.common.ServerCode;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.dao.AdminMapper;
import edu.fjut.bookshop.dao.OrderMapper;
import edu.fjut.bookshop.dao.UserMapper;
import edu.fjut.bookshop.domain.*;
import edu.fjut.bookshop.service.AdminService;
import edu.fjut.bookshop.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by dabendan on 2018/3/24.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ServerResponse<Admin> login(String username, String password) {

        if(username==null || password==null){
            return ServerResponse.createByErrorCodeMsg(ServerCode.ILLEGAL_ARGUMENTS.getCode(),"用 户 名 和 密 码 不 能 为 空!");
        }

       Integer resultCount=adminMapper.checkUsername(username);
        if(resultCount<=0){
            return ServerResponse.createByErrorMsg("用 户 名 不 存 在!");
        }
        String dbPassword=adminMapper.selectPasswordByUsername(username);
        String md5Password = MD5Util.MD5EncodeUtf8(password);
        if(!dbPassword.equals(md5Password)) {
            return ServerResponse.createByErrorMsg("密 码 不 正 确");
        }

        Admin admin = adminMapper.selectByPrimaryKey(username);

        return ServerResponse.createBySuccessMsgData("登 入 成 功!",admin);
    }

    @Override
    public PageInfo getAllUser(Integer pageNum, Integer pageSize, String username, String status) {

        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(username)) {
            username = new StringBuilder("%").append(username).append("%").toString();
        }
        List<User> userList=userMapper.selectLikeUserNameAndStatus(username,status);

        //封装了详细的分页信息,
        PageInfo pageInfo = new PageInfo(userList, BookShopConst.navigatePages);
        return pageInfo;
    }

    @Override
    public PageInfo getAllOrder(Integer pageNum, Integer pageSize, String orderid, String status) {

        PageHelper.startPage(pageNum,pageSize);
        if(StringUtils.isNotBlank(orderid)) {
            orderid = new StringBuilder("%").append(orderid).append("%").toString();
        }
        List<Order> orderList=orderMapper.selectLikeOrderidAndStatus(orderid,status);

        //封装了详细的分页信息,
        PageInfo pageInfo = new PageInfo(orderList, BookShopConst.navigatePages);
        return pageInfo;
    }

    @Override
    public ServerResponse deleteUser(String userid) {
        if(userid==null){
            return ServerResponse.createByErrorMsg("参 数 错 误");
        }

        userMapper.deleteByPrimaryKey(userid);
        return ServerResponse.createBySuccessMsg("删 除 成 功!");

    }

    @Override
    public ServerResponse normalUser(String userid) {

        if(userid==null){
            return ServerResponse.createByErrorMsg("参 数 错 误");
        }
        userMapper.updateStatusByUserId(userid,"N");
        return ServerResponse.createBySuccessMsg("改 变 成 功!");
    }

    @Override
    public ServerResponse vipUser(String userid) {

        if(userid==null){
            return ServerResponse.createByErrorMsg("参 数 错 误");
        }
        userMapper.updateStatusByUserId(userid,"Y");
        return ServerResponse.createBySuccessMsg("改 变 成 功!");
    }

    @Override
    public ServerResponse doRecharge(String username, String payPassword, BigDecimal money) {
        Integer resultCount=userMapper.checkUsername(username);
        if(resultCount<=0){
            return ServerResponse.createByErrorMsg("用 户 不 存 在!");
        }

        String dbPayPassword=userMapper.selectPayPasswordByUserName(username);
        String Md5payPassword=MD5Util.MD5EncodeUtf8(payPassword);

        if(!dbPayPassword.equals(Md5payPassword)){
            return ServerResponse.createByErrorMsg("用 户 支 付 密 码 错 误!");
        }

        if(money==null){
            return ServerResponse.createByErrorMsg("请 输 入 要 充 值 的 金 额 ");
        }

        String userid=userMapper.selectUserIdByUserName(username);
        Integer result=userMapper.updateBalanceByUseridADD(userid,money);

        if(result!=null && result>0){
            return ServerResponse.createBySuccessMsg("充 值 成 功");
        }
        return ServerResponse.createByErrorMsg("服 务 器 忙,请 稍 后 再 试!");

    }

    @Override
    public UsersInfo getUsersInfo() {

        Integer normal=0;
        Integer vip=0;
        Integer man=0;
        Integer woman=0;
        Integer total=0;
        UserExample userExample = new UserExample();
        List<User> userlist = userMapper.selectByExample(userExample);

        for(User user: userlist) {
            if(user.getStatus().equals("Y"))
                vip=vip+1;
            else
                normal=normal+1;
            if(user.getSex().equals("男"))
                man++;
            else
                woman++;

            total++;
        }

        UsersInfo usersInfo = new UsersInfo(normal,vip,man,woman,total);

        return usersInfo;
    }

}
