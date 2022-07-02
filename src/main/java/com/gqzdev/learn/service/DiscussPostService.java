package com.gqzdev.learn.service;

import java.util.List;

import javax.annotation.Resource;

import com.gqzdev.learn.model.DiscussPost;
import org.springframework.stereotype.Service;

import com.gqzdev.learn.dao.DiscussPostMapper;

@Service
public class DiscussPostService {
	@Resource
	private DiscussPostMapper discussPostMapper;
	
	public void saveDiscussPost(DiscussPost discussPost) {
		discussPostMapper.saveEntity(discussPost);
	}
	
	public List<DiscussPost> searchDiscussPost(Integer id) {
		return discussPostMapper.searchEntity(id);
	}
}
