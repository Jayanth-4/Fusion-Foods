<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fusion-Foods</title>
<link rel="stylesheet" href="WSS.css">
<script src="Response.js"></script>
</head>
<body class="signup-page">
	
	<div class="signup-box">
	
		<div class="signup">
		
			<h1>Sign Up</h1>
			<form action="signup" method="post" class="signup-form" onclick=" return validation()">
					
				<span id="nm"></span>
				<div class="signup-info">
					<label for="username">Name :-</label><input type="text" name="username" placeholder=" User Name" id="name" required>
				</div>
				
				<span id="em"></span>
				<div class="signup-info">
					<label for="email">Email Id :-</label><input type="email" name="email" placeholder=" FusionFoods@gmail.com" id="email">
				</div>
				
				<span id="pnm"></span>
				<div class="signup-info">
					<label for="phonenumber">Phone Number :-</label><input type="tel" name="phonenumber" placeholder=" 999-8877-666" id="phonenumber">
				</div>
				
				<span id="pm"></span>
				<div class="signup-info">
					<label for="password">Password :-</label><input type="password" name="password" placeholder=" Enter Your Pssword" id="password">
				</div>
				
				<span id="cpm"></span>
				<div class="signup-info">
					<label for="confirmpassword">Confirm Password :-</label><input type="text" name="confirmpassword" placeholder=" Password Should Match" id="confirmpassword">
				</div>
				
				<span id="am"></span>
				<div class="signup-info">
					<label for="address">Address :-</label><input type="text" name="address" placeholder=" Enter Your City" id="address">
				</div>
				
				<button class="btn">Sign Up</button><br>
			</form>
			<a  href="Signin.jsp">Sign-In Here >></a>
			<%
				String error=(String)request.getAttribute("errorMessage");
				if(error!=null){
					out.println("<p style='color:red;font-size: 1rem;margin-top:0.5em;text-align:center;'>"+ error +"</p>");
				}
			
			%>
		</div>
		
	</div>

</body>
</html>