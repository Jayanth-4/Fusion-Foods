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
import jakarta.servlet.http.HttpSession;


@WebServlet("/signin")
public class SignInServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String enteredEmail =req.getParameter("email");
		String enteredPassword =req.getParameter("password");
		User u=new User();
		u.setEmail(enteredEmail);
		u.setPassword(enteredPassword);
		UserDAO ud=new UserDaoImpl();
		User user=ud.getUser(enteredEmail);
		
		if(user!=null) {
			String email=user.getEmail();
			String password=user.getPassword();
			if(email!=null) {
				if(password.equals(enteredPassword)) {
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
					resp.sendRedirect("Home");
				}
				else {
					req.setAttribute("errorMessage2", "* Wrong Password. Please try again.");
					req.getRequestDispatcher("Signin.jsp").forward(req, resp);
				}
			}
		}
		else {
			req.setAttribute("errorMessage1", "* User Not Found. Plz Register");
			req.getRequestDispatcher("Signin.jsp").forward(req, resp);
		}
	}
	
   

}
