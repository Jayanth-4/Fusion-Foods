package com.FusionFoods.Model;

public class CartItems {
	
	private String imgPath;
	private int itemId;
	private int restaurantId;
	private String itemName;
	private int quantity;
	private int price;
	private int subTotal;
	
	public CartItems() {
		super();
	}

	public CartItems(String imgPath,int itemId, int restaurantId, String itemName, int quantity, int price, int subTotal) {
		super();
		this.imgPath=imgPath;
		this.itemId = itemId;
		this.restaurantId = restaurantId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.subTotal = subTotal;
	}
	
	

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

	@Override
	public String toString() {
		return "CartItems [imgPath=" + imgPath + ", itemId=" + itemId + ", restaurantId=" + restaurantId + ", itemName="
				+ itemName + ", quantity=" + quantity + ", price=" + price + ", subTotal=" + subTotal + "]";
	}

	

}
