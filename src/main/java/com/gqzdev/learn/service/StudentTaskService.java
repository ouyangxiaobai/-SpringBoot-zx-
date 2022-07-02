package com.gqzdev.learn.service;

import java.util.List;

import javax.annotation.Resource;

import com.gqzdev.learn.model.StudentTask;
import com.gqzdev.learn.model.StudentTaskExample;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqzdev.learn.dao.StudentTaskMapper;

@Service
public class StudentTaskService {
	@Resource
	private StudentTaskMapper studentTaskMapper;

	public void saveStudentTask(StudentTask studentTask) {
		studentTaskMapper.saveEntity(studentTask);
	}

	public List<StudentTask> searchStudentTask() {
		return studentTaskMapper.searchEntity();
	}

	public List<StudentTask> searchStudentTaskByStuId(Integer stuId) {
		return studentTaskMapper.searchEntityByStuId(stuId);
	}

	public PageInfo<StudentTask> searchStudentTaskByPage(int stuId,int page, int pageSize) {
		// 获取第1页，10条内容，默认查询总数count 物理分页
		PageHelper.startPage(page, pageSize);
		List<StudentTask> list = studentTaskMapper.searchEntityByStuId(stuId);
		// 分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		PageInfo<StudentTask> pageInfo = new PageInfo<StudentTask>(list);
		return pageInfo;
	}

	public List<StudentTask> getTaskFinnishedList(int stuId) {
		// TODO Auto-generated method stub
		return studentTaskMapper.searchEntityByStuId(stuId);
	}
	
	/**
	 * 
	* @Title: IsExistScore
	* @Description: 判断 stuId taskId是否存在
	* @author ganquanzhong
	* @date  2019年3月11日 上午12:55:10
	* @param stuId
	* @param taskId
	* @return
	 */
	public boolean IsExistScore(int stuId,int taskId) {
		StudentTaskExample studentTaskExample = new StudentTaskExample();
		StudentTaskExample.Criteria criteria = studentTaskExample.createCriteria();
		criteria.andStudentIdEqualTo(stuId);
		criteria.andTaskIdEqualTo(taskId);
		List<StudentTask> studentTasks = studentTaskMapper.selectByExample(studentTaskExample);
		if (studentTasks.size() == 0) {
			return false;
		}else {
			return true;
		}
		
	}
}
