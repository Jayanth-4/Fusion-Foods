package com.FusionFoods.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FusionFoods.DAO.OrderDAO;
import com.FusionFoods.DbUtils.DbUtils;
import com.FusionFoods.Model.Order;

public class OrderDaoImpl implements OrderDAO {

	private Connection con;
	private PreparedStatement pstmt;
	private Statement stmt;
	private ResultSet res;
	private Order order;
	
	ArrayList<Order> orderList=new ArrayList<Order>();
	private static final String ADD_ORDER="INSERT INTO `order_details`(`restaurantId`,`userId`,`totalAmount`,`status`,`paymentMode`) values(?,?,?,?,?)";
	private static final String GET_All_ORDER="SELECT * FROM `order_details`";
	private static final String GET_ORDER="SELECT * FROM `order_details` WHERE `orderId`=?";
	public OrderDaoImpl() {
		con=DbUtils.myConnect();
	}
	
	
	@Override
	public int addOrder(Order order) {
	    int orderId = 0;
	    try {
	        
	        pstmt = con.prepareStatement(ADD_ORDER, Statement.RETURN_GENERATED_KEYS);
	        pstmt.setInt(1, order.getResturantId());
	        pstmt.setInt(2, order.getUserId());
	        pstmt.setFloat(3, order.getTotalAmount());
	        pstmt.setString(4, order.getStatus());
	        pstmt.setString(5, order.getPaymentMode());
	        pstmt.executeUpdate();

	        // Get the generated orderId
	        ResultSet generatedKeys = pstmt.getGeneratedKeys();
	        if (generatedKeys.next()) {
	            orderId = generatedKeys.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return orderId;
	}

	@Override
	public ArrayList<Order> getAllOrder() {
		
		try {
			
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_All_ORDER);
			orderList=extractOrdersFromResultSet(res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return orderList;
	}

	@Override
	public Order getOrder(int orderId) {
		
		try {
			
			pstmt=con.prepareStatement(GET_ORDER);
			pstmt.setInt(1, orderId);
			res=pstmt.executeQuery();
			orderList=extractOrdersFromResultSet(res);
			order=orderList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return order;
	}
	
	private ArrayList<Order> extractOrdersFromResultSet(ResultSet res){
		try {
			
			while(res.next()) {
				orderList.add(new Order(
						res.getInt("restaurantId"),
						res.getInt("userId"),
						res.getInt("totalAmount"),
						res.getString("status"),
						res.getString("paymentMode")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return orderList;	
	}


	
	
	
	

}
