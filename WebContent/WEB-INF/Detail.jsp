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
				<th>Quantity in Store</th>
				<th>Price</th>
			</tr>
			<tr>
				<td>${detail.name}</td>
				<td>${detail.details}</td>
				<td>${detail.quantity}</td>
				<td>${detail.price}</td>
			</tr>
		</table>
		<form action="CartController" method="get">
			<div class="row">
				<div class="col-xs-9 col-sm-10">
					<div class="form-group">
						<label class="sr-only" for="cartQuantity">Quantity to Add
							in Cart</label> <input type="text" class="form-control" id="cartQuantity"
							name="cartQuantity" placeholder="Enter Number to Add in Cart">
						<input type="hidden" class="form-control" id="id"
							name="id" value ="${detail.id}">
					</div>
					<c:if test="${not empty error}">
						<p class="well-sm bg-danger">${error}</p>
					</c:if>
				</div>
				<div class="col-xs-3 col-sm-2">
					<button type="submit" class="btn btn-success btn-block">Add to Cart</button>
				</div>
			</div>
		</form>
	</div>
	Return to Store Page Button/Link - TDA
</body>
</html>