package com.FusionFoods.Servlets;

import java.io.IOException;
import java.util.List;

import com.FusionFoods.DAO.OrderHistoryDAO;
import com.FusionFoods.DaoImpl.OrderHistoryDaoImpl;
import com.FusionFoods.Model.OrderHistory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/orderhistory")
public class OrderHistoryServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int userId=Integer.parseInt(req.getParameter("userid"));
		
		OrderHistoryDAO ohd=new OrderHistoryDaoImpl();
		List<OrderHistory> orderHistory=ohd.getOrderHistoryUser(userId);
		HttpSession session=req.getSession();
		session.setAttribute("orderHistory", orderHistory);
		resp.sendRedirect("OrderHistory.jsp");
	}
	
}
