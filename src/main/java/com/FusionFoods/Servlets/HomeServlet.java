package com.FusionFoods.Servlets;

import java.io.IOException;
import java.util.List;

import com.FusionFoods.DAO.RestaurantDAO;
import com.FusionFoods.DaoImpl.RestaurantDaoImpl;
import com.FusionFoods.Model.Restaurant;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/Home")
public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RestaurantDAO rd=new RestaurantDaoImpl();
		List<Restaurant> restaurantList = rd.getAllRestaurant();
		HttpSession session=req.getSession();
		session.setAttribute("restaurantList", restaurantList);
		resp.sendRedirect("Home.jsp");
	}
	

}
