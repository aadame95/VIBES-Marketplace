<<<<<<< HEAD
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
	  <h1>Checkout <small>CS3220</small></h1>
	</div>
	
		<form action="Checkout" method="post">
			<table>
				<tr>
					<td><input type='text' name='FirstName' placeholder='First Name'></td>
					<td><input type='text' name='LastName' placeholder='Last Name'></td>
					<td><input type='text' name='Email' placeholder='Email'></td>
					<td><input type='submit'></td>
				</tr>
			</table>
		</form>	
		<p>${errorMsg}</p>
	
	
	
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>Quantity</th><th>Name</th><th>Details</th><th>Price</th>
		</tr>	
		<c:forEach items="${cart}" var="item">
			<tr>
		    		 <td>${item.quantity}</td>
		    		 <td>${item.name}</td>
		    		 <td>${item.details}</td>
		    		 <td>${item.price}</td>
		    		 
  			</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>VIBES Marketplace</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				Checkout <small>CS3220</small>
			</h1>
		</div>

		<form action="Checkout" method="post">
			<table>
				<tr>
					<td><input type='text' name='FirstName'
						placeholder='First Name'></td>
					<td><input type='text' name='LastName' placeholder='Last Name'></td>
					<td><input type='text' name='Email' placeholder='Email'></td>
					<td><input type='submit'></td>
				</tr>
			</table>
		</form>
		<p>${errorMsg}</p>



		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Quantity</th>
				<th>Name</th>
				<th>Details</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${cart}" var="item">
				<tr>
					<td>${item.quantity}</td>
					<td>${item.name}</td>
					<td>${item.details}</td>
					<td>${item.price}</td>

				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
>>>>>>> 0d63d0287c08398a6faa3970d9a09c6d2bf73f92
