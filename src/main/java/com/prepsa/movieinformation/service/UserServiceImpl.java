package com.prepsa.movieinformation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prepsa.movieinformation.model.User;
import com.prepsa.movieinformation.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUserInfo(User user) {
		userRepository.saveUserInfo(user);
	}

	@Override
	public void updateUserInfo(User user) {
userRepository.updateUserInfo(user);
	}

	@Override
	public void deleteUserInfo(int id) {
userRepository.deleteUserInfo(id);
	}

	@Override
	public User getUserInfoById(int id) {
		return userRepository.getUserInfoById(id);
	}

	@Override
	public List<User> getAllUsersInfo() {
		return userRepository.getAllUsersInfo();
	}

	@Override
	public int login(String userName, String password) {
		return userRepository.login(userName, password);
	}


}
