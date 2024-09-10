package com.FusionFoods.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FusionFoods.DAO.OrderHistoryDAO;
import com.FusionFoods.DbUtils.DbUtils;
import com.FusionFoods.Model.OrderHistory;

public class OrderHistoryDaoImpl implements OrderHistoryDAO {
    
    private Connection con;
    private PreparedStatement pstmt;
    private int status;
    private Statement stmt;
    private ResultSet res;
    private OrderHistory orderHistory;
    
    ArrayList<OrderHistory> orderHistoryList = new ArrayList<OrderHistory>();

    private static final String ADD_ORDER_HISTORY = "INSERT INTO order_history (orderId, userId, totalAmount, orderStatus) VALUES (?, ?, ?, ?)";
    private static final String GET_ALL_ORDER_HISTORY = "SELECT * FROM order_history";
    private static final String GET_ORDER_HISTORY = "SELECT * FROM order_history WHERE orderHistoryId = ?";
    private static final String GET_ORDER_HISTORY_BY_USERID = "SELECT * FROM order_history WHERE userId = ?";
    
    public OrderHistoryDaoImpl() {
        con = DbUtils.myConnect();  // Ensure the connection is initialized
    }

    @Override
    public int addOrderHistory(OrderHistory oh) {
        try {
            pstmt = con.prepareStatement(ADD_ORDER_HISTORY);
            pstmt.setInt(1, oh.getOrderId());
            pstmt.setInt(2, oh.getUserId());
            pstmt.setFloat(3, oh.getTotalAmount());
            pstmt.setString(4, oh.getOrderStatus());
            status = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public ArrayList<OrderHistory> getAllOrderHistory() {
        try {
            stmt = con.createStatement();
            res = stmt.executeQuery(GET_ALL_ORDER_HISTORY);
            orderHistoryList = extractOrderHistoryFromResultSet(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }

    @Override
    public OrderHistory getOrderHistory(int orderHistoryId) {
        try {
            pstmt = con.prepareStatement(GET_ORDER_HISTORY);
            pstmt.setInt(1, orderHistoryId);
            res = pstmt.executeQuery();
            orderHistoryList = extractOrderHistoryFromResultSet(res);
            orderHistory = orderHistoryList.get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistory;
    }
    @Override
    public ArrayList<OrderHistory> getOrderHistoryUser(int userId) {
    	try {
    		pstmt = con.prepareStatement(GET_ORDER_HISTORY_BY_USERID);
    		pstmt.setInt(1, userId);
    		res = pstmt.executeQuery();
    		orderHistoryList = extractOrderHistoryFromResultSet(res);
 
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return orderHistoryList;
    }
    
    private ArrayList<OrderHistory> extractOrderHistoryFromResultSet(ResultSet res) {
        try {
            while (res.next()) {
                orderHistoryList.add(new OrderHistory(
                    res.getInt("orderHistoryId"),
                    res.getInt("orderId"),
                    res.getInt("userId"),
                    res.getFloat("totalAmount"),
                    res.getString("orderStatus"),
                    res.getDate("orderDate")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }
}
