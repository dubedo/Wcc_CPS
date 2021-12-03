<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>${customerName}
		<br> Please Customize Your Pizza
	</h2>

	<form:form action="addPizza" modelAttribute="newPizza">

		<table>
			<tr>
				<td>Pick the Size:</td>
				<td><form:radiobuttons path="size" items="${sizeList}" /> <br>
				</td>
			</tr>

			<tr>
				<td>Pick the Toppings:</td>
				<td><form:checkboxes path="topping" items="${toppingList}" />
					<br></td>
			</tr>

			<tr>
				<td><input type="submit" value="Add Pizza to Order" /></td>
			</tr>
		</table>


	</form:form>




</body>
</html>