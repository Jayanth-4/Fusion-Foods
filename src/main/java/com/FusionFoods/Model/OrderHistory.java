package com.FusionFoods.Model;

import java.util.Date;

public class OrderHistory {
	
	private int orderHistoryId;
	private int orderId;
	private int userId;
	private float totalAmount;
	private String OrderStatus;
	private Date orderedDate;
	
	public OrderHistory() {
		super();
	}
	public OrderHistory(int orderHistoryId, int orderId, int userId, float totalAmount, String OrderStatus,Date orderedDate) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.OrderStatus = OrderStatus;
		this.orderedDate=orderedDate;
	}
	public OrderHistory(int orderId, int userId, float totalAmount, String OrderStatus) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.OrderStatus = OrderStatus;
	}
	public int getOrderHistoryId() {
		return orderHistoryId;
	}
	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String OrderStatus) {
		this.OrderStatus = OrderStatus;
	}
	
	public Date getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}
	@Override
	public String toString() {
		return "OrderHistory [orderHistoryId=" + orderHistoryId + ", orderId=" + orderId + ", userId=" + userId
				+ ", totalAmount=" + totalAmount + ", OrderStatus=" + OrderStatus + ", orderedDate=" + orderedDate
				+ "]";
	}
	
	

}
