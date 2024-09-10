package com.FusionFoods.DAO;

import java.util.ArrayList;

import com.FusionFoods.Model.Menu;



public interface MenuDAO {
	
	int addMenu(Menu m);
	ArrayList<Menu> getAllMenu();
	Menu getMenu(int menuID);
	ArrayList<Menu> getMenuByRestaurant(int restaurantID);
	int updateMenu(Menu m);
	int deleteMenu(int menuItemId);

}
