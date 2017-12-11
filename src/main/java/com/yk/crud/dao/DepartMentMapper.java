package com.yk.crud.dao;

import com.yk.crud.bean.DepartMent;
import com.yk.crud.bean.DepartMentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartMentMapper {
    long countByExample(DepartMentExample example);

    int deleteByExample(DepartMentExample example);

    int deleteByPrimaryKey(Integer deptId);

    int insert(DepartMent record);

    int insertSelective(DepartMent record);

    List<DepartMent> selectByExample(DepartMentExample example);

    DepartMent selectByPrimaryKey(Integer deptId);

    int updateByExampleSelective(@Param("record") DepartMent record, @Param("example") DepartMentExample example);

    int updateByExample(@Param("record") DepartMent record, @Param("example") DepartMentExample example);

    int updateByPrimaryKeySelective(DepartMent record);

    int updateByPrimaryKey(DepartMent record);
}