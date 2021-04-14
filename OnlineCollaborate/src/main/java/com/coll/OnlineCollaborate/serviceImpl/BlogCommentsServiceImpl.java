package com.coll.OnlineCollaborate.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaborate.dao.IUserDao;
import com.coll.OnlineCollaborate.model.*;
import com.coll.OnlineCollaborate.service.IBlogService;

@Service  
@Transactional  
public class BlogCommentsServiceImpl implements IBlogService{

	@Autowired
	IUserDao userDao;
	
	public List<User> userListbyStatus(String status) {
		return userDao.userListbyStatus(status);
	}

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	public User getUserById(int userId) {
		return userDao.getUserById(userId);
	}

	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	public User validateUser(User user) {
		return userDao.validateUser(user);
	}

	public boolean addUser(User user) {
		return userDao.addUser(user);
	}

	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

	public boolean deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

	public boolean deactiveUser(int userId) {
		return userDao.deactiveUser(userId);
	}

	public boolean updateUserProfile(String file, Integer userId) {
		return userDao.updateUserProfile(file, userId);
	}

	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> getBlogsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> getUsersBlogs(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Blog> mainList() {
		// TODO Auto-generated method stub
		return null;
	}

	public Blog getBlogById(int blogId) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteBlog(Blog blog) {
		// TODO Auto-generated method stub
		return false;
	}

}