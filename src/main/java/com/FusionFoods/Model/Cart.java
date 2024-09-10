package com.FusionFoods.Model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    
    private Map<Integer, CartItems> items;
    private Integer restaurantId; 

    public Cart() {
        this.items = new HashMap<>();
        this.restaurantId = null; 
    }
    public String addItem(CartItems item) {
        int itemId = item.getItemId();
        int newRestaurantId = item.getRestaurantId();
        
        if (restaurantId == null) {
            
            restaurantId = newRestaurantId;
        } else if (!restaurantId.equals(newRestaurantId)) {
      
            return "You can order items only from single restaurant at a time.";
        }

        if (items.containsKey(itemId)) {
            CartItems existingItem = items.get(itemId);
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
        } else {
            items.put(itemId, item);
        }
        
        return null; 
    }

    public void updateItem(int itemId, int quantity) {
        if (items.containsKey(itemId)) {
            CartItems item = items.get(itemId);
            if (quantity <= 0) {
                items.remove(itemId);
            } else {
                item.setQuantity(quantity);
                item.setSubTotal(quantity * item.getPrice());
            }
        }
    }
    public void removeItem(int itemId) {
        items.remove(itemId);
    }

    public Map<Integer, CartItems> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
        restaurantId = null;
    }
}
