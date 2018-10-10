package com.prepsa.movieinformation.repository;

import java.util.List;

import com.prepsa.movieinformation.model.User;

public interface UserRepository {

	public void saveUserInfo(User user);
	public void updateUserInfo(User user);
	public void deleteUserInfo(int id);
	public User getUserInfoById(int id);
	public List<User> getAllUsersInfo();
	public int login(String userName, String password);
}
