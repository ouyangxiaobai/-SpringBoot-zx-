package com.gqzdev.learn.dao;

import com.gqzdev.learn.model.StudentTask;
import com.gqzdev.learn.model.StudentTaskExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface StudentTaskMapper {
    int countByExample(StudentTaskExample example);

    int deleteByExample(StudentTaskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StudentTask record);

    int insertSelective(StudentTask record);

    List<StudentTask> selectByExample(StudentTaskExample example);

    StudentTask selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StudentTask record, @Param("example") StudentTaskExample example);

    int updateByExample(@Param("record") StudentTask record, @Param("example") StudentTaskExample example);

    int updateByPrimaryKeySelective(StudentTask record);

    int updateByPrimaryKey(StudentTask record);
    
    //////////自定义接口
    void saveEntity(StudentTask studentTask);
	
	List<StudentTask> searchEntity();
	
	List<StudentTask> searchEntityByStuId(Integer stuId);
}