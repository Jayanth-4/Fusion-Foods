package com.FusionFoods.Servlets;

import java.io.IOException;

import com.FusionFoods.DAO.MenuDAO;
import com.FusionFoods.DaoImpl.MenuDaoImpl;
import com.FusionFoods.Model.Cart;
import com.FusionFoods.Model.CartItems;
import com.FusionFoods.Model.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        String action = req.getParameter("action");
        if ("add".equals(action)) {
            String errorMessage = addItemToCart(req, cart);
            if (errorMessage != null) {
                session.setAttribute("errorMessage", errorMessage);
                resp.sendRedirect("MenuList.jsp");
            } else {
                session.setAttribute("cart", cart);
                resp.sendRedirect("Cart.jsp");
            }
        } else if ("update".equals(action)) {
            updateCartItem(req, cart);
            session.setAttribute("cart", cart);
            resp.sendRedirect("Cart.jsp");
        } else if ("remove".equals(action)) {
            removeCartItem(req, cart);
            session.setAttribute("cart", cart);
            resp.sendRedirect("Cart.jsp");
        }
    }

    private String addItemToCart(HttpServletRequest req, Cart cart) {
        int itemId = Integer.parseInt(req.getParameter("MenuitemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        MenuDAO md = new MenuDaoImpl();
        Menu menuItem = md.getMenu(itemId);

        if (menuItem != null) {
            CartItems item = new CartItems(
                    menuItem.getImagePath(),
                    menuItem.getMenuItemId(),
                    menuItem.getResturantId(),
                    menuItem.getMenuItemName(),
                    quantity,
                    menuItem.getMenuItemPrice(),
                    quantity * menuItem.getMenuItemPrice());
            return cart.addItem(item);
        }
        return "Menu item not found.";
    }

    private void removeCartItem(HttpServletRequest req, Cart cart) {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        cart.removeItem(itemId);
    }

    private void updateCartItem(HttpServletRequest req, Cart cart) {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        cart.updateItem(itemId, quantity);
    }
}
