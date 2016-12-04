<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>VIBES Marketplace</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" 
		crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div class="page-header">
	  <h1>Shopping Cart <small>CS3220</small></h1>
	</div>
	
	
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>Quantity</th><th>Name</th><th>Details</th><th>Price</th><th>Action</th>
		</tr>	
		<c:forEach items="${cart}" var="item">
			<tr>
		    		 <td>${item.quantity}</td>
		    		 <td>${item.name}</td>
		    		 <td>${item.details}</td>
		    		 <td>${item.price}</td>
		    		 <td><a href = "remove?id=${item.id}">Remove</a>
  			</tr>
		</c:forEach>
			<tr>
				<td colspan='2'></td>
				<td>Total:</td>
				<td>${totalPrice}</td>
			</tr>
	</table>
	<a class='btn' href="Checkout">Checkout</a>
</div>
</body>
</html>
