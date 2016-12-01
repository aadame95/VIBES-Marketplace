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
				VIBES Marketplace <small>CS3220</small>
			</h1>
		</div>

		<form class="form-inline" action="inventory" method="post">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="name"
					name="name">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="details"
					name="details">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="quantity"
					name="quantity">
			</div>
			<div class="form-group">
				<input type="text" class="form-control" placeholder="price"
					name="price">
			</div>

			<button type="submit" class="btn btn-default">Add</button>
		</form>

		<table class="table table-bordered table-striped table-hover">
			<tr>
				<th>Name</th>
				<th>Details</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${Item}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.details}</td>
					<td>${item.quantity}</td>
					<td>${item.price}</td>
					<c:url value="Details" var="detailUrl">
						<c:param name="id" value="${item.id}" />
					</c:url>
					<td><a class="btn btn-default btn-xs" href="${detailUrl}"> Detail</a>
				</tr>
			</c:forEach>
		</table>


	</div>
</body>
</html>