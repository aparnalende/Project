package com.demo.aparna.project.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.aparna.project.model.User;
@Component
public interface UserService {
	public User createUser(User user);
	public User getUser(String userName);
	public List<User> getAllUser();
	public User updateUser(User user);
	public void deleteUser(long id);
}
