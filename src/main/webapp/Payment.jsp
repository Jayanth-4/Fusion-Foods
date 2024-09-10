<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.FusionFoods.Model.CartItems, com.FusionFoods.Model.Cart, java.util.Map.Entry, java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Fusion-Foods</title>
    <link rel="stylesheet" href="HRMCPO.css">
</head>
<body class="payment-page">

    <div class="payment-cover">
    
	    	<div class="payment-box">
		        <div class="payment-head">
		            <img alt="Fusion Foods Logo" src="images/ff-logo.png">
		        </div>
		
		        <% 
		            Cart cart = (Cart) session.getAttribute("cart");
		            int itemsTotal = 0;                    
		            if (cart != null && !cart.getItems().isEmpty()) {
		                Map<Integer, CartItems> items = cart.getItems();
		                
		                for (Entry<Integer, CartItems> entry : items.entrySet()) {
		                    CartItems item = entry.getValue();
		                    itemsTotal += item.getSubTotal();
		                }
		            }
			          
		            int gst = (int) Math.round(itemsTotal * 0.18);  		       
		            int deliveryFee = (itemsTotal > 449) ? 0 : 97;  
		            int totalAmount = itemsTotal + gst + deliveryFee;
		        %>
		
		        <div class="payment-total">
		            <h5 class="bill">Bill details : </h5>
		
		            <div>
		                <p>Items Total</p>
		                <p>₹ <%= itemsTotal %></p>
		            </div>
		
		            <div>
		                <p>Delivery Fee</p>
		                <p>₹ <%= deliveryFee %></p>
		            </div>
		
		            <div>
		                <p>GST and Restaurant Charges (18%)</p>
		                <p>₹ <%= gst %></p>
		            </div>
		
		            <div class="to-pay">
		                <p>To Pay</p>
		                <h5>₹ <%= totalAmount %></h5>
		            </div>
		        </div>
		    </div>
		
		    <div class="payment-mode">
		        <h5 >Select Your Payment Mode</h5>
		        <form action="paymentservlet?totalamount=<%= totalAmount %>" method="post" class="mode">
		            <div>
		                <p> <svg xmlns="http://www.w3.org/2000/svg" class="soft-icons" viewBox="0 -960 960 960" width="24px" ><path d="M200-200v-560 560Zm0 80q-33 0-56.5-23.5T120-200v-560q0-33 23.5-56.5T200-840h560q33 0 56.5 23.5T840-760v100h-80v-100H200v560h560v-100h80v100q0 33-23.5 56.5T760-120H200Zm320-160q-33 0-56.5-23.5T440-360v-240q0-33 23.5-56.5T520-680h280q33 0 56.5 23.5T880-600v240q0 33-23.5 56.5T800-280H520Zm280-80v-240H520v240h280Zm-160-60q25 0 42.5-17.5T700-480q0-25-17.5-42.5T640-540q-25 0-42.5 17.5T580-480q0 25 17.5 42.5T640-420Z"/></svg> Wallet</p>
		                <input type="radio" name="pay-mode" value="Wallet" required>
		            </div>
		            <div>
		                <p> <svg xmlns="http://www.w3.org/2000/svg" class="soft-icons"  viewBox="0 -960 960 960" width="24px" ><path d="M200-280v-280h80v280h-80Zm240 0v-280h80v280h-80ZM80-640v-80l400-200 400 200v80H80Zm179-80h442L480-830 259-720ZM80-120v-80h482q2 21 5 40.5t9 39.5H80Zm600-310v-130h80v90l-80 40ZM800 0q-69-17-114.5-79.5T640-218v-102l160-80 160 80v102q0 76-45.5 138.5T800 0Zm-29-120 139-138-42-42-97 95-39-39-42 43 81 81ZM259-720h442-442Z"/></svg> Net Banking</p>
		                <input type="radio" name="pay-mode" value="Net Banking" required>
		            </div>
		            <div>
		                <p> <svg xmlns="http://www.w3.org/2000/svg"  class="soft-icons" viewBox="0 -960 960 960" ><path d="M560-440q-50 0-85-35t-35-85q0-50 35-85t85-35q50 0 85 35t35 85q0 50-35 85t-85 35ZM280-320q-33 0-56.5-23.5T200-400v-320q0-33 23.5-56.5T280-800h560q33 0 56.5 23.5T920-720v320q0 33-23.5 56.5T840-320H280Zm80-80h400q0-33 23.5-56.5T840-480v-160q-33 0-56.5-23.5T760-720H360q0 33-23.5 56.5T280-640v160q33 0 56.5 23.5T360-400Zm440 240H120q-33 0-56.5-23.5T40-240v-440h80v440h680v80ZM280-400v-320 320Z"/></svg> Cash On Delivery</p>
		                <input type="radio" name="pay-mode" value="cash on delivery" required>
		            </div>
		            <input type="submit" value="P A Y" class="pay">
		        </form>
	    	</div>
    
    
    </div>

</body>
</html>
