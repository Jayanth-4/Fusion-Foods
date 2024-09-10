package com.FusionFoods.Servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import com.FusionFoods.DAO.OrderDAO;
import com.FusionFoods.DAO.OrderItemsDAO;
import com.FusionFoods.DAO.OrderHistoryDAO;
import com.FusionFoods.DaoImpl.OrderDaoImpl;
import com.FusionFoods.DaoImpl.OrderItemsDaoImpl;
import com.FusionFoods.DaoImpl.OrderHistoryDaoImpl;
import com.FusionFoods.Model.Cart;
import com.FusionFoods.Model.CartItems;
import com.FusionFoods.Model.Order;
import com.FusionFoods.Model.OrderItems;
import com.FusionFoods.Model.OrderHistory;
import com.FusionFoods.Model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/paymentservlet")
public class PaymentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private int restaurantId;
    private String status = "pending";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paymentMode = req.getParameter("pay-mode");
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        int userId = user.getUserId();
        int itemsTotal = Integer.parseInt(req.getParameter("totalamount"));

        if (cart != null && !cart.getItems().isEmpty()) {
            Map<Integer, CartItems> items = cart.getItems();
            for (Entry<Integer, CartItems> entry : items.entrySet()) {
                CartItems item = entry.getValue();
                restaurantId = item.getRestaurantId(); 
            }
        }

       
        Order order = new Order(restaurantId, userId, itemsTotal, status, paymentMode);
        OrderDAO orderDAO = new OrderDaoImpl();
        int latestOrderId = orderDAO.addOrder(order); 

      
        if (cart != null && !cart.getItems().isEmpty()) {
            OrderItemsDAO orderItemsDAO = new OrderItemsDaoImpl();
            for (Entry<Integer, CartItems> entry : cart.getItems().entrySet()) {
                CartItems cartItem = entry.getValue();
                OrderItems orderItem = new OrderItems(latestOrderId, cartItem.getItemId(), cartItem.getQuantity(), cartItem.getSubTotal());
                orderItemsDAO.addOrderItems(orderItem);
            }
        }
 
        OrderHistory orderHistory = new OrderHistory(latestOrderId, userId, itemsTotal, status);
        OrderHistoryDAO orderHistoryDAO = new OrderHistoryDaoImpl();
        orderHistoryDAO.addOrderHistory(orderHistory);     
        session.removeAttribute("cart");
        resp.sendRedirect("Confirmation.jsp");
    }
}
