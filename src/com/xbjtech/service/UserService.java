package com.xbjtech.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xbjtech.model.User;

@Service
public class UserService {
	
	public static List<User> list = null;
	static {
		if (list == null) {
			list = new LinkedList<>();
			list.add(new User(1L, "LiLei", "123456", 18));
			list.add(new User(2L, "Lily", "123123", 19));
			list.add(new User(3L, "Lucy", "111111", 18));
			list.add(new User(4L, "Han Meimei", "222222", 20));
			list.add(new User(5L, "John", "333333", 23));
		}
	}
	
	/**
	 * 列表页面
	 * @return
	 */
	public List<User> list() {
		return list;
	}
	
	/**
	 * 新增
	 * @param user
	 */
	public void insertUser(User user) {
		list.add(user);
	}
	
	/**
	 * 
	 * @param user
	 */
	public void updateUser(User user) {
		for (int i = 0; i < list.size(); i++) {
			User u = list.get(i);
			if (user.getId().compareTo(u.getId()) == 0) {
				u.setUsername(user.getUsername());
				u.setPassword(user.getPassword());
				u.setAge(user.getAge());
			}
		}
	}
	
	/**
	 * 删除
	 * @param id
	 */
	public void deleteUser(Long id) {
		for (int i = 0; i < list.size(); i++) {
			User u = list.get(i);
			if (id.compareTo(u.getId()) == 0) {
				list.remove(u);
			}
		}
	}
	
	/**
	 * 查看
	 * @param id
	 * @return
	 */
	public User selectById(Long id) {
		for (User u : list) {
			if (id.compareTo(u.getId()) == 0) {
				return u;
			}
		}
		return null;
	}
	
}
