package com.FusionFoods.Model;

public class Menu {
	
	private int menuItemId;
	private int resturantId;
	private String menuItemName;
	private float rating;
	private int menuItemPrice;
	private String menuItemDescription;
	private String isAvailable;
	private String imagePath;
	
	public Menu() {
		super();
	}

	public Menu(int menuItemId, int resturantId, String menuItemName, float rating, int menuItemPrice, String menuItemDescription,
			String isAvailable, String imagePath) {
		super();
		this.menuItemId = menuItemId;
		this.resturantId = resturantId;
		this.menuItemName = menuItemName;
		this.rating=rating;	
		this.menuItemPrice = menuItemPrice;
		this.menuItemDescription = menuItemDescription;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public Menu(int resturantId, String menuItemName, float rating, int menuItemPrice, String menuItemDescription,
			String isAvailable, String imagePath) {
		super();
		this.resturantId = resturantId;
		this.menuItemName = menuItemName;
		this.rating=rating;
		this.menuItemPrice = menuItemPrice;
		this.menuItemDescription = menuItemDescription;
		this.isAvailable = isAvailable;
		this.imagePath = imagePath;
	}

	public int getMenuItemId() {
		return menuItemId;
	}

	public void setMenuItemId(int menuItemId) {
		this.menuItemId = menuItemId;
	}

	public int getResturantId() {
		return resturantId;
	}

	public void setResturantId(int resturantId) {
		this.resturantId = resturantId;
	}

	public String getMenuItemName() {
		return menuItemName;
	}

	public void setMenuItemName(String menuItemName) {
		this.menuItemName = menuItemName;
	}

	public int getMenuItemPrice() {
		return menuItemPrice;
	}

	public void setMenuItemPrice(int menuItemPrice) {
		this.menuItemPrice = menuItemPrice;
	}

	public String getMenuItemDescription() {
		return menuItemDescription;
	}

	public void setMenuItemDescription(String menuItemDescription) {
		this.menuItemDescription = menuItemDescription;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Menu [menuItemId=" + menuItemId + ", resturantId=" + resturantId + ", menuItemName=" + menuItemName
				+ ", rating=" + rating + ", menuItemPrice=" + menuItemPrice + ", menuItemDescription="
				+ menuItemDescription + ", isAvailable=" + isAvailable + ", imagePath=" + imagePath + "]";
	}
	
	

	

	
	
	
	

}
