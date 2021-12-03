<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>${order.customer.fname}'s Cart:</h2>

	<table>

		<c:forEach var="eachPizza" items="${order.pizzas}"
			varStatus="theCount">

			<tr>
				<td>Pizza ${theCount.count}</td>
				<td>Size:</td>
				<td>${eachPizza.size}</td>
				<td>Toppings</td>
				<td><c:forEach var="eachTopping" items="${eachPizza.topping}">${eachTopping}</c:forEach></td>
				<td><form action="deletePizza" method="post">
						<input type="hidden" name="pizzaId" value="${theCount.count}" />
						<input type="submit" value="Delete Pizza">

					</form></td>
			</tr>
		</c:forEach>

	</table>

	<div>
		<form action="orderPizza" method="post">

			<input type="hidden" name="customerId" value="${order.customer.id}" />
			<input type="submit" value="Add Another Pizza">

		</form>

	</div>

	<form action="placeOrder" method="post">
		<input type="hidden" name="customerId" value="${order.customer.id}" />
		<input type="submit" value="Place Order">
	</form>

</body>
</html>