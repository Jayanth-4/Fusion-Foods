package com.FusionFoods.DAO;

import java.util.ArrayList;

import com.FusionFoods.Model.Restaurant;

public interface RestaurantDAO {
	
	int addRestaurant(Restaurant r);
	ArrayList<Restaurant> getAllRestaurant();
	Restaurant getRestaurant(int resturantId);
	int  updateResturant(Restaurant r);
	int deleteRestaurant(int resturantId);

}
