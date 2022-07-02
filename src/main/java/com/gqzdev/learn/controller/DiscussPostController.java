package com.gqzdev.learn.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import com.gqzdev.learn.model.DiscussPost;
import com.gqzdev.learn.model.Student;
import com.gqzdev.learn.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName:
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ganquanzhong
 * @date 2019年2月23日 下午11:01:23
 */
@Controller
public class DiscussPostController {

	@Autowired
	private DiscussPostService discussPostService;

	@RequestMapping("/createReply/{id}")
	public ModelAndView createReply(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("createReply");
		return mav;
	}

	//添加回复
	@RequestMapping("/saveDiscussReply/{id}")
	public ModelAndView saveDiscussReply(@PathVariable("id") Integer id, DiscussPost post, HttpSession session) {
		Student student = (Student) session.getAttribute("user");
		post.setDiscussId(id);
		post.setRecordTime(new Date());
		post.setStudentId(student.getId());

		discussPostService.saveDiscussPost(post);
		return new ModelAndView("redirect:/searchDiscussReply/" + id + ".html");
	}

	//查询回复
	@RequestMapping("/searchDiscussReply/{id}")
	public ModelAndView searchDiscussReply(@PathVariable("id") Integer id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("posts", discussPostService.searchDiscussPost(id));
		mav.setViewName("searchDiscussReply");
		return mav;
	}
}
