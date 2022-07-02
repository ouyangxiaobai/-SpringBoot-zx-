package com.gqzdev.learn.service;

import java.util.List;

import javax.annotation.Resource;

import com.gqzdev.learn.model.Course;
import com.gqzdev.learn.model.CourseExample;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqzdev.learn.dao.CourseMapper;

@Service
public class CourseService {
	@Resource
	private CourseMapper courseMapper;

	// 添加课程
	public void saveCourse(Course course) {
		courseMapper.saveEntity(course);
	}

	// 查询所有课程
	public List<Course> searchCourse() {
		return courseMapper.searchEntity();
	}
	
	//JSON
	public List<Course> getCourseList() {
		CourseExample courseExample=new CourseExample();
		return courseMapper.selectByExample(courseExample);
	}

	// 删除为id的课程
	public void deleteCourse(Integer id) {
		courseMapper.deleteEntity(id);
	}

	// 更新课程
	public void updateCourse(Course course) {
		courseMapper.updateEntity(course);
	}

	// 查询为id的课程信息
	public Course getCourseById(Integer id) {
		return courseMapper.getEntityById(id);
	}

	public PageInfo<Course> searchCourseByPage(int page, int pageSize) {
		// 获取第1页，10条内容，默认查询总数count 物理分页
		PageHelper.startPage(page, pageSize);
		List<Course> list = courseMapper.searchEntity();
		// 分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		PageInfo<Course> pageInfo = new PageInfo<Course>(list);
		return pageInfo;
	}
}
