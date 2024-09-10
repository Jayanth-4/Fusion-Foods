package com.FusionFoods.Model;

public class Order {
	
	private int orderId;
	private int resturantId;
	private int userId;
	private int totalAmount;
	private String status;
	private String paymentMode;
	
	public Order() {
		super();
	}
	public Order(int orderId, int resturantId, int userId, int totalAmount, String status, String paymentMode) {
		super();
		this.orderId = orderId;
		this.resturantId = resturantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	
	public Order(int resturantId, int userId, int totalAmount, String status, String paymentMode) {
		super();
		this.resturantId = resturantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.status = status;
		this.paymentMode = paymentMode;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", resturantId=" + resturantId + ", userId=" + userId + ", totalAmount="
				+ totalAmount + ", status=" + status + ", paymentMode=" + paymentMode + "]";
	}
	
	

}
