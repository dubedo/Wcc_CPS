<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">

<title>Current Customers</title>

</head>

<body>


	<table>

		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>

		</tr>

		<c:forEach var="customer" items="${customers}">

			<tr>
				<td>${customer.id}</td>
				<td>${customer.fname}</td>
				<td>${customer.lname}</td>

				<td>
					<form:form action="updateCustomer" method="post">
						<input type="hidden" name="customerId" value="${customer.id}" />
						<input type="submit" value="Update Customer" />
					</form:form>
				</td>
				
				<td>
					<form:form action="pizzaOrder" method="post">
						<input type="hidden" name="customerId" value="${customer.id}" />
						<input type="submit" value="Pizza Orders" />
					</form:form>
				</td>
				
				<td>
					<form:form action="orderPizza" modelAttribute = "newPizza" method="post">
						<input type="hidden" name="customerId" value="${customer.id}" />
						<input type="submit" value="Order New Pizza" />
					</form:form>
				</td>

			</tr>

		</c:forEach>

	</table>

	<form action="addCustomer" method="post">

		<input type="submit" value="Add New Customer" />

	</form>



</body>

</html>