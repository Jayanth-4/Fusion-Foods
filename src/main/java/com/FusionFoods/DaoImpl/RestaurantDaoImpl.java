package com.FusionFoods.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FusionFoods.DAO.RestaurantDAO;
import com.FusionFoods.DbUtils.DbUtils;
import com.FusionFoods.Model.Restaurant;

public class RestaurantDaoImpl implements RestaurantDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private int status;
	private Restaurant restaurant;
	
	ArrayList<Restaurant> restaurantList=new ArrayList<Restaurant>();
	
	private static final String ADD_RESTAURANT="INSERT INTO `restaurant_details'(`restaurantName`,'deliveryTime`,'cuisineType`,`rating`,`address`,`isActive`,`imagePath`) values(?,?,?,?,?,?,,?)";
	private static final String GET_ALL_RESTAURANT="SELECT * FROM `restaurant_details`";
	private static final String GET_RESTAURANT="SELECT * FROM `restaurant_details` WHERE `restaurantId`=?";
	private static final String UPDATE_RESTAURANT_BASED_ON_RESTAURANTID="UPDATE `restaurant_details` set `restaurantName`=?,'deliveryTime`=?,'cuisineType`=?,`rating`=?,`address`=?,`isActive`=?,`imagePath`=?  WHERE `restaurantId`=?";
	private static final String DELETE_RESTAURANT_BASED_ON_RESTAURANTID="DELETE FROM `restaurant_details` WHERE `restaurantId`=?";
	public RestaurantDaoImpl() {
		con=DbUtils.myConnect();
	}

	@Override
	public int addRestaurant(Restaurant r) {
		
		try {
			
			pstmt=con.prepareStatement(ADD_RESTAURANT);
			pstmt.setString(1, r.getResturantName());
			pstmt.setString(2, r.getDeliverTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setFloat(4, r.getRating());
			pstmt.setString(5, r.getAddress());
			pstmt.setString(6, r.getIsActive());
			pstmt.setString(7, r.getImagePath());
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}

	@Override
	public ArrayList<Restaurant> getAllRestaurant() {
		
		try {
			
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_ALL_RESTAURANT);
			restaurantList=extractRestaurantFromResultSet(res);
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return restaurantList;	
	}

	@Override
	public Restaurant getRestaurant(int resturantId) {
		
		try {
			
			pstmt=con.prepareStatement(GET_RESTAURANT);
			pstmt.setInt(1, resturantId);
			res=pstmt.executeQuery();
			restaurantList=extractRestaurantFromResultSet(res);
			restaurant=restaurantList.get(0);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return restaurant;	
	}

	@Override
	public int updateResturant(Restaurant r) {
		
		try {
			
			pstmt=con.prepareStatement(UPDATE_RESTAURANT_BASED_ON_RESTAURANTID);
			pstmt.setString(1, r.getResturantName());
			pstmt.setString(2, r.getDeliverTime());
			pstmt.setString(3, r.getCuisineType());
			pstmt.setFloat(4, r.getRating());
			pstmt.setString(5, r.getAddress());
			pstmt.setString(6, r.getIsActive());
			pstmt.setString(7, r.getImagePath());
			pstmt.setInt(8, r.getResturantId());
			status=pstmt.executeUpdate();
			
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;	
	}

	@Override
	public int deleteRestaurant(int resturantId) {
		
		try {
			
			pstmt=con.prepareStatement(DELETE_RESTAURANT_BASED_ON_RESTAURANTID);
			pstmt.setInt(1, resturantId);
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;	
	}

	private ArrayList<Restaurant> extractRestaurantFromResultSet(ResultSet res) {
		
		try {
			while(res.next()) {
				
				restaurantList.add(new Restaurant(res.getInt("restaurantId"),		
				res.getString("restaurantName"),
				res.getString("deliveryTime"),
				res.getString("cuisineType"),
				res.getFloat("rating"),
				res.getString("address"),
				res.getString("isActive"),
				res.getString("imagePath")));
				
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return restaurantList;
	}
	
	

}
