package com.gqzdev.learn.service;

import java.util.List;

import javax.annotation.Resource;

import com.gqzdev.learn.model.CourseVideo;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gqzdev.learn.dao.CourseVideoMapper;

@Service
public class CourseVideoService {
	@Resource
	private CourseVideoMapper courseVideoMapper;
	
	public void saveCourseVideo(CourseVideo collegeVideo) {
		courseVideoMapper.saveEntity(collegeVideo);
	}
	
	public List<CourseVideo> searchCourseVideo(int id) {
		return courseVideoMapper.searchEntityByTeacherId(id);
	}
	
	public List<CourseVideo> searchAllCourseVideo() {
		return courseVideoMapper.searchAllEntity();
	}
	
	
	public CourseVideo getCourseVideoById(Integer id) {
		return courseVideoMapper.getEntityById(id);
	}
	
	public void deleteCourseVideo(Integer id) {
		courseVideoMapper.deleteEntity(id);
	}

	public PageInfo<CourseVideo> searchCourseVideoByPage(int page, int pageSize) {
		// 获取第1页，10条内容，默认查询总数count 物理分页
		PageHelper.startPage(page, pageSize);
		List<CourseVideo> list = courseVideoMapper.searchAllEntity();
		// 分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		PageInfo<CourseVideo> pageInfo = new PageInfo<CourseVideo>(list);
		return pageInfo;
	}

	/**
	 * 
	* @Title: searchCourseVideobyTeacherIdByPage
	* @Description: 教师查询自己上传的视频资料
	* @author ganquanzhong
	* @date  2019年3月10日 下午9:58:12
	* @param id
	* @param page
	* @param pageSize
	* @return
	 */
	public PageInfo<CourseVideo> searchCourseVideobyTeacherIdByPage(Integer id,	int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		List<CourseVideo> list = courseVideoMapper.searchEntityByTeacherId(id);
		// 分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		PageInfo<CourseVideo> pageInfo = new PageInfo<CourseVideo>(list);
		return pageInfo;
	}
}
