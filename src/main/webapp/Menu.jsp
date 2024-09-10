<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.List, com.FusionFoods.Model.Menu , com.FusionFoods.Model.Restaurant" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fusion-Foods</title>
<link rel="stylesheet" href="HRMCPO.css">
<script src="Action.js"></script>
</head>
<body class="menulist-page">

	<header class="navbar">
        <nav class="nav-content">
            <img alt="Logo" src="images/ff-logo.png">
            <span>     
                <a href="Signin.jsp"><svg xmlns="http://www.w3.org/2000/svg" class="icons" viewBox="0 -960 960 960"><path d="M480-480q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 66-47 113t-113 47ZM160-160v-112q0-34 17.5-62.5T224-378q62-31 126-46.5T480-440q66 0 130 15.5T736-378q29 15 46.5 43.5T800-272v112H160Zm80-80h480v-32q0-11-5.5-20T700-306q-54-27-109-40.5T480-360q-56 0-111 13.5T260-306q-9 5-14.5 14t-5.5 20v32Zm240-320q33 0 56.5-23.5T560-640q0-33-23.5-56.5T480-720q-33 0-56.5 23.5T400-640q0 33 23.5 56.5T480-560Zm0-80Zm0 400Z"/></svg> Sign In</a> 
                <a href="#" onclick="showSidebar()"><svg xmlns="http://www.w3.org/2000/svg" class="icons" viewBox="0 -960 960 960"><path d="M240-80q-33 0-56.5-23.5T160-160v-480q0-33 23.5-56.5T240-720h80q0-66 47-113t113-47q66 0 113 47t47 113h80q33 0 56.5 23.5T800-640v480q0 33-23.5 56.5T720-80H240Zm0-80h480v-480h-80v80q0 17-11.5 28.5T600-520q-17 0-28.5-11.5T560-560v-80H400v80q0 17-11.5 28.5T360-520q-17 0-28.5-11.5T320-560v-80h-80v480Zm160-560h160q0-33-23.5-56.5T480-800q-33 0-56.5 23.5T400-720ZM240-160v-480 480Z"/></svg> Cart</a>
            </span> 
        </nav>
    </header>
	
	<div class="menu">
		
			<div class="restaurant-details">
		<a href="DemoHome.jsp"><svg xmlns="http://www.w3.org/2000/svg" class="soft-icons" viewBox="0 -960 960 960"><path d="M280-320 120-480l160-160 56 56-63 64h247v80H273l63 64-56 56Zm400 120h80v-560h-80v560Zm-80 80v-720h240v720H600ZM440-760v-80h80v80h-80Zm0 640v-80h80v80h-80ZM280-760v-80h80v80h-80Zm0 640v-80h80v80h-80ZM120-760v-80h80v80h-80Zm0 640v-80h80v80h-80Zm560-80h80-80Z"/></svg></a>
		<%
			Restaurant  restaurant =(Restaurant)session.getAttribute("restaurant");
		
			if(restaurant !=null){
				
				%>
				
				<h1><%= restaurant.getResturantName() %></h1>
				<h4><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960" class="menu-rating"><path d="m320-240 160-122 160 122-60-198 160-114H544l-64-208-64 208H220l160 114-60 198ZM480-80q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"/></svg><%= restaurant.getRating() %></h4>
				<h5><%= restaurant.getCuisineType() %></h5>
				<P><svg xmlns="http://www.w3.org/2000/svg" class="soft-icons" viewBox="0 -960 960 960" ><path d="M200-80q-83 0-141.5-58.5T0-280q0-83 58.5-141.5T200-480q83 0 141.5 58.5T400-280q0 83-58.5 141.5T200-80Zm0-80q50 0 85-35t35-85q0-50-35-85t-85-35q-50 0-85 35t-35 85q0 50 35 85t85 35Zm240-40v-200L312-512q-12-11-18-25.5t-6-30.5q0-16 6.5-30.5T312-624l112-112q12-12 27.5-18t32.5-6q17 0 32.5 6t27.5 18l76 76q28 28 64 44t76 16v80q-57 0-108.5-22T560-604l-32-32-96 96 88 92v248h-80Zm180-540q-33 0-56.5-23.5T540-820q0-33 23.5-56.5T620-900q33 0 56.5 23.5T700-820q0 33-23.5 56.5T620-740ZM760-80q-83 0-141.5-58.5T560-280q0-83 58.5-141.5T760-480q83 0 141.5 58.5T960-280q0 83-58.5 141.5T760-80Zm0-80q50 0 85-35t35-85q0-50-35-85t-85-35q-50 0-85 35t-35 85q0 50 35 85t85 35Z"/></svg> Order above 449 for free delivery </P>
				
				
				<% 
				
			}
		
		%>
	
		
	
	</div>
	

	<div class="restaurant-menu">

		<%
		List<Menu>  menuList =(List<Menu>)session.getAttribute("menuList");

		if (menuList != null) {
			
			for (Menu res : menuList) {
		%>
			<div class="menu-items">
				
				<div class="item-discription">
					<h3><%=res.getMenuItemName()%></h3>
					<h4> ₹ <%=res.getMenuItemPrice()%></h4>
					<h5><svg xmlns="http://www.w3.org/2000/svg" class="menu-rating" viewBox="0 -960 960 960"  ><path d="m606-286-33-144 111-96-146-13-58-136v312l126 77ZM233-120l65-281L80-590l288-25 112-265 112 265 288 25-218 189 65 281-247-149-247 149Z"/></svg> <%= res.getRating() %></h5>
					<p><%=res.getMenuItemDescription()%></p>
					
				</div>
				
				
				<div class="item-view">
					
						<img alt="Img not found" src="images/<%=res.getImagePath()%>"><br>
						<div class="quantity-add">
												
							<input type="hidden" name="MenuitemId" value="<%=res.getMenuItemId()%>">
							<span class="quantity">
								<button type="button" class="quantity-button" data-item-id="<%= res.getMenuItemId() %>" onclick="changeQuantity(this, -1)">&minus;</button>
	                    		<input type="number" id="quantity_<%=res.getMenuItemId() %>" class="qnty" name="quantity" value="1" min="1"/>
	                    		<button type="button" class="quantity-button" data-item-id="<%= res.getMenuItemId() %>" onclick="changeQuantity(this, 1)">&plus;</button>
							</span> 
							<input type="submit" value=" Add " class="add" onclick=showSidebar()>
							<input type="hidden" name="action" value="add">
						
						</div>				
				</div>
			</div>
			
		<%
			}
		}
		%>
	</div>
	
	
	
	
	</div>
	
	
	<div class="sidebar" >
		<div class="hidebutton" onclick=hideSidebar()>
			<a><svg xmlns="http://www.w3.org/2000/svg" class="close-cart" viewBox="0 -960 960 960" ><path d="M200-120q-33 0-56.5-23.5T120-200v-160h80v160h560v-560H200v160h-80v-160q0-33 23.5-56.5T200-840h560q33 0 56.5 23.5T840-760v560q0 33-23.5 56.5T760-120H200Zm220-160-56-58 102-102H120v-80h346L364-622l56-58 200 200-200 200Z"/></svg></a>
		</div>
		
		<div class="cart-signin">
			<p>Your Cart Is Empty</p>
			<h4>Please SignIn for Ordering</h4>
			<a href="Signin.jsp" class="btn">Sign-In</a>
			<a href="Signup.jsp" class="btn">Sign-Up</a>
		
		
		</div>
		
	</div>

</body>
</html>