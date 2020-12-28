package com.disseration.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.disseration.app.model.User;

public interface UsersRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String username);
	
	@Query(value = "SELECT * FROM users u WHERE u.setProfile = 2", nativeQuery = true)
    public List<User> findAllTeachers();
}
