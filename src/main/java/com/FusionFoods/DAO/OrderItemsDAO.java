package com.FusionFoods.DAO;

import java.util.ArrayList;

import com.FusionFoods.Model.OrderItems;

public interface OrderItemsDAO {
	
	int addOrderItems(OrderItems oi);
	ArrayList<OrderItems> getAllOrderItems();
	OrderItems getOrderItem(int orderItemId);

}
