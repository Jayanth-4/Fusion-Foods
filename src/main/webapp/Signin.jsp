<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fusion-Foods</title>
<link rel="stylesheet" href="WSS.css">
</head>
<body class="signin-page">

	<div class="signin-box">
		
		<div class="signin">
			<%
				String success=(String)request.getAttribute("successMessage");
				if(success!=null){
					out.println("<p style='color:green;font-size: 1rem;padding-bottom:0.8em;'>"+ success +"</p>");
				}					
			%>
			<h1>Sign In</h1>
			<form action="signin" method="post" class="signin-form">
				<label for="email">User Email</label>
				<input type="email" name="email" placeholder=" FusionFoods@gmail.com" required id="email">
				<%
					String error1=(String)request.getAttribute("errorMessage1");
					if(error1!=null)
					{
						out.println("<p style='color:red;font-size: 0.8rem;'>"+ error1 +"</p>");
					}	
				%>
				<label for="password">Password</label>
				<input type="password" name="password"  placeholder=" Enter Your Password" required id="password"><br>
				<%
					String error2=(String)request.getAttribute("errorMessage2");
					if(error2!=null)
					{
						out.println("<p style='color:red;font-size: 0.8rem;'>"+ error2 +"</p>");
					}	
				%>
				<button>Log In</button>	
			</form>		
			<a href="Signup.jsp">Register Here >></a>
		</div>	
	</div>

</body>
</html>
