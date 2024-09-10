package com.FusionFoods.DAO;

import java.util.ArrayList;

import com.FusionFoods.Model.User;

public interface UserDAO {
	
	public int addUser(User u);
	public ArrayList<User> getAllUser();
	public User getUser(String email);
	public int updateUser(User u);
	public int deleteUser(String email);

}
