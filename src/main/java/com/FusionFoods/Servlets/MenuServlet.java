package com.FusionFoods.Servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.FusionFoods.DAO.MenuDAO;
import com.FusionFoods.DAO.RestaurantDAO;
import com.FusionFoods.DaoImpl.MenuDaoImpl;
import com.FusionFoods.DaoImpl.RestaurantDaoImpl;
import com.FusionFoods.Model.Menu;
import com.FusionFoods.Model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/menu")
public class MenuServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
		MenuDAO m=new MenuDaoImpl();
		ArrayList<Menu> menuList = m.getMenuByRestaurant(restaurantId);
		RestaurantDAO rd=new RestaurantDaoImpl();
		Restaurant restaurant = rd.getRestaurant(restaurantId);
		
		if(menuList!=null) {
			
			session.setAttribute("restaurant", restaurant);
			session.setAttribute("menuList", menuList);
			resp.sendRedirect("Menu.jsp");
			
		}
		
	}
	

}
