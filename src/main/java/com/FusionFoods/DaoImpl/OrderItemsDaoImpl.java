package com.FusionFoods.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.FusionFoods.DAO.OrderItemsDAO;
import com.FusionFoods.DbUtils.DbUtils;
import com.FusionFoods.Model.OrderItems;

public class OrderItemsDaoImpl implements OrderItemsDAO{
	
	private Connection con;
	private PreparedStatement pstmt;
	private int status;
	private Statement stmt;
	private ResultSet res;
	private OrderItems orderItems;
	
	ArrayList<OrderItems> orderItemsList=new ArrayList<OrderItems>();

	private static final String ADD_ORDERITEMS="INSERT INTO `order_items`(`orderId`,`menuItemId`,`quantity`,`subTotal`) values(?,?,?,?)";
	private static final String GET_All_ORDERITEMS="SELECT * FROM `order_items`";
	private static final String GET_ORDERITEM="SELECT * FROM `order_items` WHERE `orderItemId`=?";

	public OrderItemsDaoImpl() {
		con=DbUtils.myConnect();
	}

	@Override
	public int addOrderItems(OrderItems oi) {
		
		try {
			
			pstmt=con.prepareStatement(ADD_ORDERITEMS);
			pstmt.setInt(1, oi.getOrderId() );
			pstmt.setInt(2, oi.getMenuItemId() );
			pstmt.setInt(3, oi.getQuantity() );
			pstmt.setFloat(4, oi.getSubTotal());
			status=pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return status;
	}

	@Override
	public ArrayList<OrderItems> getAllOrderItems() {
		
		try {
			
			stmt=con.createStatement();
			res=stmt.executeQuery(GET_All_ORDERITEMS);
			orderItemsList=extractOrderItemsFromResultSet(res);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return orderItemsList;
	}

	@Override
	public OrderItems getOrderItem(int orderItemId) {
		
		try {
			
			pstmt=con.prepareStatement(GET_ORDERITEM);
			pstmt.setInt(1, orderItemId);
			res=pstmt.executeQuery();
			orderItemsList=extractOrderItemsFromResultSet(res);
			orderItems=orderItemsList.get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return orderItems;
	}
	
	private ArrayList<OrderItems> extractOrderItemsFromResultSet(ResultSet res){
		try {
			
			while(res.next()) {
				orderItemsList.add(new OrderItems(
						res.getInt("orderItemId"),
						res.getInt("orderId"),
						res.getInt("menuItemId"),
						res.getInt("quantity"),
						res.getFloat("subTotal")));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	return orderItemsList;	
	}
	

}
