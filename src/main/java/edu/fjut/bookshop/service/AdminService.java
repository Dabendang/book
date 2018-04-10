package edu.fjut.bookshop.service;

import com.github.pagehelper.PageInfo;
import edu.fjut.bookshop.common.ServerResponse;
import edu.fjut.bookshop.domain.Admin;
import edu.fjut.bookshop.domain.UsersInfo;

import java.math.BigDecimal;

/**
 * Created by dabendan on 2018/3/24.
 */
public interface AdminService {
    ServerResponse<Admin> login(String username, String password);

    PageInfo getAllUser(Integer pageNum, Integer pageSize, String username, String status);

    PageInfo getAllOrder(Integer pageNum, Integer pageSize, String orderid, String status);

    ServerResponse deleteUser(String userid);

    ServerResponse normalUser(String userid);

    ServerResponse vipUser(String userid);

    ServerResponse doRecharge(String username, String password, BigDecimal money);

    UsersInfo getUsersInfo();
}
