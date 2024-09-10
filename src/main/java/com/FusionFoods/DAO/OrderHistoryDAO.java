package com.FusionFoods.DAO;

import java.util.ArrayList;

import com.FusionFoods.Model.OrderHistory;

public interface OrderHistoryDAO {
	
	int addOrderHistory(OrderHistory oh);
	ArrayList<OrderHistory> getAllOrderHistory();
	OrderHistory getOrderHistory(int orderHistoryId);
	ArrayList<OrderHistory>  getOrderHistoryUser(int userId);

}
