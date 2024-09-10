package com.FusionFoods.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FusionFoods.DAO.MenuDAO;
import com.FusionFoods.DbUtils.DbUtils;
import com.FusionFoods.Model.Menu;



public class MenuDaoImpl implements MenuDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	private Menu menu;
	ArrayList<Menu> menuList=new ArrayList<Menu>();
	private static final String ADD_MENU="INSERT INTO `menu_details'(`restaurantId`,`menuItemName`,`rating`,`MenuItemPrice`,`menuItemDescription`,``isAvailable`,`imagePath`) values(?,?,?,?,?,?,?)";
	private static final String GET_All_MENU="SELECT * FROM `menu_details`";
	private static final String GET_MENU="SELECT * FROM `menu_details` WHERE `menuItemId`=?";
	private static final String GET_MENU_BY_RESTAURANT="SELECT * FROM `menu_details` WHERE `restaurantId`=?";
	private static final String UPDATE_MENU_BASED_ON_MENUID="UPDATE `menu_details` set `restaurantId`=?,'menuItemName`=?,`rating`=?,'menuItemPrice`=?,`menuItemDescription`=?,`isAvailable`=?,`imagePath`=? WHERE `menuItemId`=?";
	private static final String DELETE_MENU_BASED_ON_MENUID="DELETE FROM `menu_details` WHERE `menuItemId`=?";
	
	public MenuDaoImpl() {
		con=DbUtils.myConnect();
	}
	

	@Override
	public int addMenu(Menu m) {
		
		try {
			
			pstmt=con.prepareStatement(ADD_MENU);
			pstmt.setInt(1, m.getResturantId());
			pstmt.setString(2, m.getMenuItemName());
			pstmt.setFloat(3, m.getRating());
			pstmt.setInt(4, m.getMenuItemPrice());
			pstmt.setString(5, m.getMenuItemDescription());
			pstmt.setString(6, m.getIsAvailable());
			pstmt.setString(7, m.getImagePath());
			status=pstmt.executeUpdate();		
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}

	@Override
	public ArrayList<Menu> getAllMenu() {
		
		try {
			
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_All_MENU);
			menuList=extractMenuFromResultSet(res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return menuList;	
	}

	@Override
	public Menu getMenu(int menuItemID) {
		
		try {
			pstmt=con.prepareStatement(GET_MENU);
			pstmt.setInt(1, menuItemID);
			res=pstmt.executeQuery();
			menuList=extractMenuFromResultSet(res);
			menu=menuList.get(0);
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return menu;	
	}
	@Override
	public ArrayList<Menu> getMenuByRestaurant(int restaurantID) {
		
		try {
			pstmt=con.prepareStatement(GET_MENU_BY_RESTAURANT);
			pstmt.setInt(1, restaurantID);
			res=pstmt.executeQuery();
			menuList=extractMenuFromResultSet(res);		
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return menuList;	
	}

	@Override
	public int updateMenu(Menu m) {
		
		try {
			
			pstmt=con.prepareStatement(UPDATE_MENU_BASED_ON_MENUID);
			pstmt.setInt(1, m.getResturantId());
			pstmt.setString(2, m.getMenuItemName());
			pstmt.setFloat(3, m.getRating());
			pstmt.setInt(4, m.getMenuItemPrice());
			pstmt.setString(5, m.getMenuItemDescription());
			pstmt.setString(6, m.getIsAvailable());
			pstmt.setString(7, m.getImagePath());
			pstmt.setInt(8, m.getMenuItemId());
			status=pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}

	@Override
	public int deleteMenu(int menuItemId) {
		
		try {
			
			pstmt=con.prepareStatement(DELETE_MENU_BASED_ON_MENUID);
			pstmt.setInt(1, menuItemId);
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}
	
	
	private ArrayList<Menu> extractMenuFromResultSet(ResultSet res) {
		
		try {
			
			while(res.next()) {
				menuList.add(new Menu(res.getInt("menuItemId"),
						res.getInt("restaurantId"),
						res.getString("menuItemName"),
						res.getFloat("rating"),
						res.getInt("menuItemPrice"),
						res.getString("menuItemDescription"),
						res.getString("isAvailable"),
						res.getString("imagePath")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return menuList;	
	}

}
