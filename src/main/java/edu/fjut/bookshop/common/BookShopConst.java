package edu.fjut.bookshop.common;

import java.math.BigDecimal;

/**
 * Created by qyw on 2017/6/21.
 */
public class BookShopConst {

    public static final String CURRENT_USER="currentUser";

    public static final String CURRENT_ORDER="currentOrder";

    public static final String CURRENT_ADMIN="currentAdmin";

    public static final Double finePercent=new Double("0.05");

    public static final int navigatePages=5;

    public static final int DEFAULT_ID_LENGTH=11;

    public static final int DEFAULT_BOOKISBN_LENGTH=13;


    public interface UserConst{

        BigDecimal INIT_BALANCE=new BigDecimal("0");//初始化余额

    }

    //用户状态
    public interface UserStatus{
        String NORMAL="N";//普通用户
        String VIP="Y";//会员
    }

    //订单状态
    public interface OrderStatus{
        String NOTPAY="0";//未支付
        String PAYED="1";//已支付，未发货
        String PASS="2";//已取消
        String SENDED="3";//已发货
        String GETED="3";//已收货
    }

}
