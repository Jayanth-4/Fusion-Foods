<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.FusionFoods.Model.CartItems,com.FusionFoods.Model.Cart,java.util.Map.Entry,java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fusion-Foods</title>
<link rel="stylesheet" href="HRMCPO.css">
<script src="Action.js"></script>
</head>
<body class="add-to-cart">

	<div class="cart-cover">
		    <div class="cart-add">
			    <div class="secure-checkout">
			        <p>SECURE - CHECKOUT</p>
			    </div>
			    
				    <div class="cart-items-container">
				        <% 
				        Cart cart = (Cart) session.getAttribute("cart"); 
				        if (cart != null && !cart.getItems().isEmpty()) {
				            Map<Integer, CartItems> items = cart.getItems();
				            for (Entry<Integer, CartItems> entry : items.entrySet()) {
				                CartItems item = entry.getValue();
				                String itemName = item.getItemName();
				                int quantity = item.getQuantity();
				                int price = item.getPrice();
				                int subTotal = item.getSubTotal();
						        %>
							       <div class="cart-delete">
			                            <a href="cart?itemId=<%=item.getItemId()%>&action=remove"><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960"><path d="m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z" /></svg></a>
			                        </div>
							        <div class="cart-add-item">
								            <div class="cart-desc">
									                <div class="desc">
									                    <p><%=itemName%></p>
									                    <h5>₹ <%=price%></h5>
									                </div>
									                <div class="cart-quantity">
									                    <form action="cart" method="post">
									                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
									                        <span class="quantityy ">
									                            <button type="button" data-item-id="<%= item.getItemId() %>" onclick="changeQuantity(this, -1)">&minus;</button>
									                            <input type="number" id="quantity_<%=item.getItemId() %>" class="qntyy" name="quantity" value="<%=quantity%>">
									                            <button type="button" data-item-id="<%= item.getItemId() %>" onclick="changeQuantity(this, 1)">&plus;</button>
									                        </span>
									                        <input type="hidden" name="action" value="update">
									                        <input type="submit" value="Update" class="update">
									                    </form>
									                </div>
								             </div>
								            <div class="sub-total">
								                <p>sub-total : ₹ <%=subTotal %></p>
								            </div>
							  		</div><% 
							  	}
				           }
				        
					        else { %>
				        		<div class="empty-cart">				        		
				        			<p>Your cart is empty</p>
				        			<h5>Choose Your Restaurant <a href="Home.jsp">HERE</a></h5>				        		
				        		</div>
				        	<% } %>
			    </div>
			
			    <div class="proceed">
                <% if (cart != null && !cart.getItems().isEmpty()) { %>
                <h5><a href="MenuList.jsp">Add More Items >></a></h5>
                <a href="Payment.jsp" class="pay-btn">Proceed to Pay</a>
                <% } %>
            </div>
		</div>

	</div>


</body>
</html>

