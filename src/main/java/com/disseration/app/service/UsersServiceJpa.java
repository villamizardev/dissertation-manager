package com.disseration.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disseration.app.model.User;
import com.disseration.app.repository.UsersRepository;

@Service
public class UsersServiceJpa implements IUsersService {

	@Autowired
	private UsersRepository userRepository;

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByID(Integer id) {
		Optional<User> optional = userRepository.findById(id);
		return optional.get();
	}

	@Override
	public void deleteByUserID(Integer userID) {
		userRepository.deleteById(userID);
	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAllTeachers() {
		return userRepository.findAllTeachers();
	}
}
