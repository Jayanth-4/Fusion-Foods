package com.FusionFoods.Servlets;

import java.io.IOException;

import com.FusionFoods.DAO.UserDAO;
import com.FusionFoods.DaoImpl.UserDaoImpl;
import com.FusionFoods.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		long phonenumber=Long.parseLong(req.getParameter("phonenumber"));
		String password=req.getParameter("password");
		String address=req.getParameter("address");
		User user=new User(username,email,phonenumber,password,address);
		UserDAO ud=new UserDaoImpl();
		int status=ud.addUser(user);
		if(status==0) {
			
			req.setAttribute("errorMessage", "Email Existed..Piz try to Login");
			req.getRequestDispatcher("Signup.jsp").forward(req, resp);
			
		}
		else {
			req.setAttribute("successMessage", "Successfully Registered");
			req.getRequestDispatcher("Signin.jsp").forward(req, resp);
			
		}	
		
	}
	
   

}
