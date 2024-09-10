package com.FusionFoods.Model;

public class Restaurant {
	
	private int resturantId;
	private String resturantName;
	private String deliverTime;
	private String cuisineType;
	private float rating;
	private String address;
	private String isActive;
	private String imagePath;
	public Restaurant() {
		super();
	}
	public Restaurant(int resturantId, String resturantName, String deliverTime, String cuisineType, float rating,
			String address,String isActive, String imagePath) {
		super();
		this.resturantId = resturantId;
		this.resturantName = resturantName;
		this.deliverTime = deliverTime;
		this.cuisineType = cuisineType;
		this.rating = rating;
		this.address = address;
		this.isActive=isActive;
		this.imagePath =imagePath;
	}
	
	public Restaurant(String resturantName, String deliverTime, String cuisineType, float rating, String address,String isActive,
			String imagePath) {
		super();
		this.resturantName = resturantName;
		this.deliverTime = deliverTime;
		this.cuisineType = cuisineType;
		this.rating = rating;
		this.address = address;
		this.isActive=isActive;
	
		this.imagePath = imagePath;
	}
	public int getResturantId() {
		return resturantId;
	}
	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	public String getDeliverTime() {
		return deliverTime;
	}
	public void setDeliverTime(String deliverTime) {
		this.deliverTime = deliverTime;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	@Override
	public String toString() {
		return "Restaurant [resturantId=" + resturantId + ", resturantName=" + resturantName + ", deliverTime="
				+ deliverTime + ", cuisineType=" + cuisineType + ", rating=" + rating + ", address=" + address
				+ ", isActive=" + isActive + ", adminUserId=" + ", imagePath=" + imagePath + "]";
	}

}
