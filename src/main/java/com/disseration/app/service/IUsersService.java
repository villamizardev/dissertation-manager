package com.disseration.app.service;

import java.util.List;

import com.disseration.app.model.User;

public interface IUsersService {
	public List<User> findAllUsers();
	public User findUserByID(Integer id);
	public void save(User user);
	public void deleteByUserID(Integer userID);
	public User findUserByUsername(String username);
	public List<User> findAllTeachers();
}
