package com.coll.OnlineCollaborate.daoImpl;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.OnlineCollaborate.dao.*;
import com.coll.OnlineCollaborate.model.Blog;
import com.coll.OnlineCollaborate.model.User;

@Repository("BlogDao")
@Transactional
public class BlogDaoImpl implements IBlogDao{

	@Autowired
	SessionFactory sessionFactory;
	public List<User> userListbyStatus(String status) {
		String q="from User where status='"+status+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(q);
		return query.getResultList();
	}

	public List<User> getAllUsers() {
		
		return  sessionFactory.getCurrentSession().createQuery("from User",User.class).getResultList();
	}

	public User getUserById(int userId) {
		return sessionFactory.getCurrentSession().get(User.class, Integer.valueOf(userId));
	}

	public User getUserByUsername(String username) {
		String query="from User where username=:username";
		return sessionFactory.getCurrentSession().createQuery(query,User.class).setParameter("username", username).getSingleResult();
	}

	public User validateUser(User user) {
		String username=user.getUsername();
		String password=user.getPassword();
		String q="from User where username='"+username+"' and password='"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(q);
		try {
			user=(User)query.getSingleResult();
			return user;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}

	public boolean updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(int userId) {
		try {
			sessionFactory.getCurrentSession().delete(getUserById(userId));
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean deactiveUser(int userId) {
		try {
			User user=getUserById(userId);
			user.setEnabled(false);
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean updateUserProfile(String file, Integer userId) {
		String q="update User set profile=:fileName where userId=:id";
		Query query=sessionFactory.getCurrentSession().createQuery(q);
		query.setParameter("id", (Integer)userId);
		query.setParameter("fileName", file);
		try {
			query.executeUpdate();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
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