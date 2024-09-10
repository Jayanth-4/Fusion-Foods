package com.FusionFoods.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FusionFoods.DAO.UserDAO;
import com.FusionFoods.DbUtils.DbUtils;
import com.FusionFoods.Model.User;

public class UserDaoImpl implements UserDAO{
	
	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private int status;
	private User user;
	
	ArrayList<User> userList=new ArrayList<User>();
	
	private static final String ADD_USER="INSERT INTO `user_details`(`userName`,`email`,`phonenumber`,`password`,`address`) values(?,?,?,?,?)";
	private static final String GET_ALL_USER="SELECT * FROM `user_details`";
	private static final String GET_USER="SELECT * FROM `user_details` WHERE `email`=?";
	private static final String UPDATE_USER_BASED_ON_EMAIL="UPDATE `user_details` set `userName`=?,`phonenumber`=?,`password`=?,`address`=? WHERE `emai`=?";
	private static final String DELETE_USER_BASED_ON_EMAIL="DELETE FROM `user_details`  WHERE `emai`=?";
	
	public UserDaoImpl() {
		con=DbUtils.myConnect();
		
	}


	@Override
	public int addUser(User u) {
		try {
			
			pstmt=con.prepareStatement(ADD_USER);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getEmail());
			pstmt.setLong(3, u.getPhonenumber());
			pstmt.setString(4, u.getPassword());
			pstmt.setString(5, u.getAddress());
			
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	
	@Override
	public ArrayList<User> getAllUser() {
		
		try {
			
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALL_USER);
			userList=extractUserFromResultSet(res);
		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return userList;	
	}
	
	
	@Override
	public User getUser(String email) {

		try {
			pstmt=con.prepareStatement(GET_USER);
			pstmt.setString(1, email);
			res=pstmt.executeQuery();
			userList=extractUserFromResultSet(res);
			user=userList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	return user;
	}
	
	
	@Override
	public int updateUser(User u) {

		try {
			
			pstmt=con.prepareStatement(UPDATE_USER_BASED_ON_EMAIL);
			pstmt.setString(1,u.getUsername());
			pstmt.setLong(2,u.getPhonenumber());
			pstmt.setString(3,u.getPassword());
			pstmt.setString(4,u.getAddress());
			pstmt.setString(5,u.getEmail());
			
			status=pstmt.executeUpdate();	

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}	
	
	
	@Override
	public int deleteUser(String email) {

		try {
			pstmt=con.prepareStatement(DELETE_USER_BASED_ON_EMAIL);
			pstmt.setString(1, email);
			status=pstmt.executeUpdate();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;	
	}
	

	private  ArrayList<User> extractUserFromResultSet(ResultSet res) {
			
			try {
				
				while(res.next()) {

					userList.add(new User(res.getInt("userId"),
							res.getString("userName"),
							res.getString("email"),
							res.getLong("phonenumber"),
							res.getString("password"),
							res.getString("address"),
							res.getDate("registeredDate")));
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return 	userList;
		}





	
	
	
	

}
