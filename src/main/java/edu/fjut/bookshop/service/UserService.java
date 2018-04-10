package edu.fjut.bookshop.service;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.User;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/21.
 */
public interface UserService {

    ServerResponse<Map> register(User user);

    Boolean checkUsername(String username);

    ServerResponse<User> login(String username, String logPassword);

    User getUserInfo(String userid);

    void update(User user);

    ServerResponse<Map> updatePass(User user);

    PageInfo getUserOrder(Integer pageNum, Integer pageSize, String userid);

    PageInfo getUserShopcart(Integer pageNum, Integer pageSize, String userid);

    ServerResponse updateBalanceADD(String userid, BigDecimal money);

}
