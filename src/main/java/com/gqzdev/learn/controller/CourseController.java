package com.gqzdev.learn.controller;

import java.util.List;

import com.gqzdev.learn.model.Course;
import com.gqzdev.learn.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.gqzdev.learn.service.CollegeService;

/**
 * 
 * @ClassName:
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ganquanzhong
 * @date 2019年2月23日 下午11:01:23
 */
@Controller
public class CourseController {
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private CollegeService collegeService;
	
	@RequestMapping("/createCourse")
	public ModelAndView createCourse() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("colleges", collegeService.searchCollege());
		mav.setViewName("createCourse");
		return mav;
	}
	
	@RequestMapping("/saveCourse")
	public ModelAndView saveCourse(Course course) {
		courseService.saveCourse(course);
		return new ModelAndView("redirect:/searchCourse.html");
	}
	
	@RequestMapping("/searchCourse")
	public ModelAndView searchCourse() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("courses", courseService.searchCourse());
		mav.setViewName("searchCourse");
		return mav;
	}
	
	@RequestMapping("/deleteCourse/{id}")
	public ModelAndView deleteCourse(@PathVariable("id") Integer id) {
		courseService.deleteCourse(id);
		return new ModelAndView("redirect:/searchCourse.html");
	}
	
	@RequestMapping("/updateCourse/{id}")
	public ModelAndView updateCourse(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("colleges", collegeService.searchCollege());
		mav.addObject("course", courseService.getCourseById(id));
		mav.setViewName("updateCourse");
		return mav;
	}
	
	@RequestMapping("/editCourse/{id}")
	public ModelAndView editCourse(@PathVariable("id") Integer id, Course course) {
		course.setId(id);
		courseService.updateCourse(course);
		return new ModelAndView("redirect:/searchCourse.html");
	}
	
	@RequestMapping("/searchCourseInfo")
	public ModelAndView searchCourseInfo() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("courses", courseService.searchCourse());
		mav.setViewName("searchCourseInfo");
		return mav;
	}
	
	
	@RequestMapping("/courseListByPage")
	@ResponseBody()
	public PageInfo<Course> courseListByPage(int page, int pageSize) {
		return courseService.searchCourseByPage(page,pageSize);
	}
	
	@RequestMapping("/getCourseList")
	@ResponseBody()
	public List<Course> getCourseList() {
		return courseService.getCourseList();
	}
}
