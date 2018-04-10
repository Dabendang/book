package edu.fjut.bookshop.dao;

import edu.fjut.bookshop.domain.CateGory;
import edu.fjut.bookshop.domain.CateGoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CateGoryMapper {
    int deleteByPrimaryKey(Integer categoryid);

    int insert(CateGory record);

    int insertSelective(CateGory record);

    List<CateGory> selectByExample(CateGoryExample example);

    CateGory selectByPrimaryKey(Integer categoryid);

    int updateByExampleSelective(@Param("record") CateGory record, @Param("example") CateGoryExample example);

    int updateByExample(@Param("record") CateGory record, @Param("example") CateGoryExample example);

    int updateByPrimaryKeySelective(CateGory record);

    int updateByPrimaryKey(CateGory record);
}