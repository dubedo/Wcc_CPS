<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Pizza Form</title>
</head>
<body>

	<form:form action="processTheForm" modelAttribute="theirOrder">

		<form:label path="theCustomer.name">Customer Name: <span
				class="required"></span>
		</form:label>
		<form:input path="theCustomer.name" />
		<form:errors path="theCustomer.name"></form:errors>

		<br>

		<form:label path="theCustomer.theirAddress.street">Street:</form:label>
		<form:input path="theCustomer.theirAddress.street" />
		<form:errors path="theCustomer.theirAddress.street"></form:errors>

		<br>

		<form:label path="theCustomer.theirAddress.city">City Name:</form:label>
		<form:input path="theCustomer.theirAddress.city" />
		<form:errors path="theCustomer.theirAddress.city"></form:errors>

		<br>

		<form:label path="theCustomer.theirAddress.state">State Name:</form:label>
		<form:select path="theCustomer.theirAddress.state">
			<form:options items="${stateOptions}" />
		</form:select>

		<br>

		<form:label path="theCustomer.theirAddress.zipCode">Zip Code:</form:label>
		<form:input path="theCustomer.theirAddress.zipCode" />
		<form:errors path="theCustomer.theirAddress.zipCode"></form:errors>

		<br>

		<table>

			<tr>
				<td>Size:</td>
				<td><form:radiobuttons path="thePizza.size"
						items="${sizeOptions}" />
			</tr>

			<tr>
				<td>Toppings:</td>
				<td><form:checkboxes path="thePizza.toppings"
						items="${toppingOptions}" />
			</tr>

		</table>

		<input type="submit" value="Place Order" />

	</form:form>



</body>
</html>