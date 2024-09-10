<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.FusionFoods.Model.CartItems,com.FusionFoods.Model.OrderHistory,java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fusion-Foods</title>
 <link rel="stylesheet" href="HRMCPO.css">
</head>
<body class="orderhistory">

	<div class="history">
		
		
		<% 
		List<OrderHistory> orderHistory=(List<OrderHistory>)session.getAttribute("orderHistory");
	
		if(orderHistory!=null){
			%><h3>Your Order History</h3>
			<table>
			<tr><td>Order-Id</td><td>Total Amount</td><td>Ordered-Date</td></tr>
			<% 
			for(OrderHistory res: orderHistory){
			%>
			
			<tr>			
				<td><%= res.getOrderId()%></td>
				<td><%= res.getTotalAmount()%></td>
				<td><%= res.getOrderedDate()%></td>
			</tr>
			
			
			
			
			
			<%
			}
			%></table><%
		}
		else{
			
			%><h2>Your OrderHistory is Empty</h2>
			  <p>Start Ordering Your Favourite Food</p>
			<%
		}
	
	%>
	
	
	
	</div>

</body>
</html>