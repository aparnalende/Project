package com.demo.aparna.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.aparna.project.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = ?1")
	public User findByUsername(String username);
	
//	public User findByEmailAndPassword(String email, String password);
}
