package com.FusionFoods.DAO;

import java.util.ArrayList;

import com.FusionFoods.Model.Order;

public interface OrderDAO {
	
	int addOrder(Order o);
	ArrayList<Order> getAllOrder();
	Order getOrder(int orderId);

}
