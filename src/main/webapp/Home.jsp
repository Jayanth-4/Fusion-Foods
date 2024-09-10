<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.FusionFoods.Model.Restaurant,com.FusionFoods.Model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fusion-Foods</title>
    <link rel="stylesheet" href="HRMCPO.css">
    <script src="Action.js"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Silkscreen:wght@400;700&display=swap" rel="stylesheet">
</head>

<body class="home-page">
	<%User user=(User)session.getAttribute("user"); %>
    <header class="navbar">
        <nav class="nav-content">
            <img alt="Logo" src="images/ff-logo.png">
            <span>     
                <a href="orderhistory?userid=<%= user.getUserId()%>"><svg xmlns="http://www.w3.org/2000/svg" class="icons" viewBox="0 -960 960 960" ><path d="M480-120q-75 0-140.5-28.5t-114-77q-48.5-48.5-77-114T120-480q0-75 28.5-140.5t77-114q48.5-48.5 114-77T480-840q82 0 155.5 35T760-706v-94h80v240H600v-80h110q-41-56-101-88t-129-32q-117 0-198.5 81.5T200-480q0 117 81.5 198.5T480-200q105 0 183.5-68T756-440h82q-15 137-117.5 228.5T480-120Zm112-192L440-464v-216h80v184l128 128-56 56Z"/></svg> Order History</a>
                <a href="Cart.jsp"><svg xmlns="http://www.w3.org/2000/svg" class="icons" viewBox="0 -960 960 960"><path d="M240-80q-33 0-56.5-23.5T160-160v-480q0-33 23.5-56.5T240-720h80q0-66 47-113t113-47q66 0 113 47t47 113h80q33 0 56.5 23.5T800-640v480q0 33-23.5 56.5T720-80H240Zm0-80h480v-480h-80v80q0 17-11.5 28.5T600-520q-17 0-28.5-11.5T560-560v-80H400v80q0 17-11.5 28.5T360-520q-17 0-28.5-11.5T320-560v-80h-80v480Zm160-560h160q0-33-23.5-56.5T480-800q-33 0-56.5 23.5T400-720ZM240-160v-480 480Z"/></svg> Cart</a>
				<a href="#" onclick="showSidebar()"><svg xmlns="http://www.w3.org/2000/svg" class="icons" viewBox="0 -960 960 960"  ><path d="M480-480q-66 0-113-47t-47-113q0-66 47-113t113-47q66 0 113 47t47 113q0 66-47 113t-113 47ZM160-160v-112q0-34 17.5-62.5T224-378q62-31 126-46.5T480-440q66 0 130 15.5T736-378q29 15 46.5 43.5T800-272v112H160Zm80-80h480v-32q0-11-5.5-20T700-306q-54-27-109-40.5T480-360q-56 0-111 13.5T260-306q-9 5-14.5 14t-5.5 20v32Zm240-320q33 0 56.5-23.5T560-640q0-33-23.5-56.5T480-720q-33 0-56.5 23.5T400-640q0 33 23.5 56.5T480-560Zm0-80Zm0 400Z"/></svg> Profile</a>
            </span> 
        </nav>
    </header>

    <div class="home">
        

        <div class="restaurant-list">
	        <div class="greet" >
				<div class="greet-welcome">
				<%
					if(user!=null){
						%><h2>Welcome!, <%=user.getUsername() %>...!!! <h2><%
					}
				%>
				</div>
	
			</div>
            <%
                List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurantList");
                if (restaurantList != null) {
                    for (Restaurant res : restaurantList) {
            			%><div class="restaurant">
                				<a class="menulink" href="menulist?restaurantId=<%= res.getResturantId() %>">
                    				<nav class="restaurant-info">
                        				<img alt="Restaurant Image" src="images/<%= res.getImagePath() %>">
                        				<h3><%=res.getResturantName() %></h3>
                        				<h5><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 -960 960 960" class="rating"><path d="m320-240 160-122 160 122-60-198 160-114H544l-64-208-64 208H220l160 114-60 198ZM480-80q-83 0-156-31.5T197-197q-54-54-85.5-127T80-480q0-83 31.5-156T197-763q54-54 127-85.5T480-880q83 0 156 31.5T763-763q54 54 85.5 127T880-480q0 83-31.5 156T763-197q-54 54-127 85.5T480-80Zm0-80q134 0 227-93t93-227q0-134-93-227t-227-93q-134 0-227 93t-93 227q0 134 93 227t227 93Zm0-320Z"/></svg> <%=res.getRating()%> • <%=res.getDeliverTime() %> min</h5>
                        				<p><%=res.getCuisineType() %></p>
                    				</nav>
                				</a>
            				</div>
            		<%} 
                 }
                 else { %>
            		<h1>No Restaurants Found</h1><%	
                 } %>
        	</div>
    </div>
    
    <div class="sidebar profilebar" >
		<div class="hidebutton" onclick=hideSidebar()>
			<a><svg xmlns="http://www.w3.org/2000/svg" class="close-cart" viewBox="0 -960 960 960" ><path d="M200-120q-33 0-56.5-23.5T120-200v-160h80v160h560v-560H200v160h-80v-160q0-33 23.5-56.5T200-840h560q33 0 56.5 23.5T840-760v560q0 33-23.5 56.5T760-120H200Zm220-160-56-58 102-102H120v-80h346L364-622l56-58 200 200-200 200Z"/></svg></a>
		</div>
		
		<div class="profile">
			
			<div><h5>Your Details</h5></div>
			<div><img alt="" src="images/profile-image.png"></div>
			<div class="profile-details">
				<p>FF-ID : <%=user.getUserId() %></p>		
				<p>Name : <%=user.getUsername() %></p>		
				<p>Email : <%=user.getEmail() %></p>		
				<p>Mobile.No : <%=user.getPhonenumber() %></p>		
				<p>Address : <%=user.getAddress() %></p>
				<p>Registered on : <%=user.getRegisteredDate() %></p>		
			</div>
		
		</div>
		
	</div>
	
    
</body>
</html>
