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

	<h2>Orders for ${customerName}</h2>

	<table>

		<tr>
			<th>Order Id</th>
		</tr>

		<c:forEach var="order" items="${pizzaOrders}">

			<tr>

				<td>${order.id}</td>

				<td>

					<table>

						<tr>
							<th>Size</th>
							<th>Toppings</th>
						</tr>

						<c:forEach var="eachPizza" items="${order.pizzas}">
							<tr>
								<td>${eachPizza.size}</td>
								<td>${eachPizza.topping}</td>
							</tr>
						</c:forEach>


					</table>
				</td>
				<td>
					<form action="deleteOrder" method="post">

						<input type="hidden" name="orderId" value="${order.id}" /> <input
							type="submit" value="Delete Order" />
					</form>
				</td>
			</tr>


		</c:forEach>


	</table>

	<div>
		<form action="customerList" method="get">

			<input type="submit" value="Customer List">

		</form>
	</div>

	<form action="orderPizza" method="post">

		<input type="hidden" name="customerId" value="${customerId}" /> <input
			type="submit" value="Place another Order" />


	</form>


</body>
</html>