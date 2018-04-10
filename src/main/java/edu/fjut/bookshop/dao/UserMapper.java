package edu.fjut.bookshop.dao;

import edu.fjut.bookshop.domain.User;
import edu.fjut.bookshop.domain.UserExample;

import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String userid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer checkUsername(String username);

    String selectLogPasswordByUserName(String username);

    String selectPayPasswordByUserName(String username);

    String selectLogPasswordByUserId(String userid);

    String selectPayPasswordByUserId(String userid);

    String selectUserIdByUserName(String username);

    String selectStatusByUserNameAndLOGPwd(@Param("username") String username,@Param(value = "logPassword") String password);

    User selectByUserNameAndLOGPwd(@Param("username") String username, @Param(value = "logPassword")String logPassword);

    List<User> selectLikeUserNameAndStatus(@Param("username")String username,@Param(value = "status") String status);

    String checkStatusByUserId(String userid);

    Integer updateBalanceByUseridADD(@Param("userid")String userid,@Param("money") BigDecimal money);

    Integer updateBalanceByUseridDEL(@Param("userid")String userid,@Param("money") BigDecimal money);

    String selectUserNameByUserId(String userid);

    BigDecimal selectBalanceByUserId(String userid);

    Integer updateBalanceByuserIdAndNewBalance(@Param("userId") String userId, @Param("newBalance") BigDecimal newBalance);

    Integer updateStatusByUserId(@Param("userid") String userid , @Param("status") String status);
}