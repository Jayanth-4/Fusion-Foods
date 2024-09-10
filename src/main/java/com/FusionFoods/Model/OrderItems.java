package com.FusionFoods.Model;

public class OrderItems {
	
	int orderItemId;
	int orderId;
	int menuItemId;
	int quantity;
	float subTotal;
	
	public OrderItems() {
		super();
	}
	public OrderItems(int orderItemId, int orderId, int menuItemId, int quantity, float subTotal) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.menuItemId = menuItemId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	
	public OrderItems(int orderId, int menuItemId, int quantity, float subTotal) {
		super();
		this.orderId = orderId;
		this.menuItemId = menuItemId;
		this.quantity = quantity;
		this.subTotal = subTotal;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getMenuItemId() {
		return menuItemId;
	}
	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	@Override
	public String toString() {
		return "OrderItems [orderItemId=" + orderItemId + ", orderId=" + orderId + ", menuItemId=" + menuItemId + ", quantity="
				+ quantity + ", subTotal=" + subTotal + "]";
	}

}
