package com.demo.aparna.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.aparna.project.model.User;
import com.demo.aparna.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User createUser(User user) {
		User save = userRepository.save(user);
		return save;
	}

	@Override
	public User getUser(String username) {
		User user = userRepository.findByUsername(username);
		return user;
	}

	@Override
	public List<User> getAllUser() {
		List<User> userlist = userRepository.findAll();
		return userlist;
	}

	@Override
	public User updateUser(User user) {
		User save=userRepository.save(user);
		return save;
	}

	@Override
	public void deleteUser(long id) {
		userRepository.deleteById(id);

	}

}
