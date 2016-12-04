<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Item Detail</title>
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
				VIBES Marketplace <small>CS3220</small>
			</h1>
		</div>
		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Details</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<tr>
				<td>${detail.name}</td>
				<td>${detail.details}</td>
				<td>${detail.quantity}</td>
				<td>${detail.price}</td>
				<td><c:url value="CartController" var="cartURL">
					<c:param name="id" value="${detail.id}" />
				</c:url>
				<a class="btn btn-primary btn-xs" href="${cartURL}">Add to Cart</a></td>
			</tr>
		</table>
	</div>
	Return to Store Page Button/Link - TDA
</body>
</html>