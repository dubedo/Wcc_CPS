<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Confirmed Order</title>
</head>
<body>

	Order Confirmation For --- ${theirOrder.theCustomer.name}
	<br>
	<br> Address
	<br>
	<br> ${theirOrder.theCustomer.theirAddress.street},
	${theirOrder.theCustomer.theirAddress.city}
	<br> ${theirOrder.theCustomer.theirAddress.state},
	${theirOrder.theCustomer.theirAddress.zipCode}
	<br>
	<br> Pizza
	<br>
	<br>${theirOrder.thePizza.size}
	<br>
	<c:forEach var="eachTopping" items="${theirOrder.thePizza.toppings}">
	${eachTopping}
	</c:forEach>


</body>
</html>