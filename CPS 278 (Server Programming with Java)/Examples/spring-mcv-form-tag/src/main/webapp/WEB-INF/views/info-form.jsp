<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form:form action="processForm" modelAttribute="pet">

		<table>

			<tr>
				<td>Name:</td>
				<td><form:input path="name" /></td>

			</tr>

			<!-- <tr>
				<td>Species HardCode:</td>

				<td><form:select path="species">
						<form:option value="Dog">Dog</form:option>
						<form:option value="Cat">Cat</form:option>
						<form:option value="Bird">Bird</form:option>
						<form:option value="Rabbit">Rabbit</form:option>
					</form:select></td>

			</tr> -->

			<tr>
				<td>Species J/P:</td>
				<td><form:select path="species">

						<form:options items="${speciesList}" />

					</form:select></td>

			</tr>

			<tr>
				<td>Gender:</td>
				<td><form:radiobuttons path="gender" items="${genderList}" /></td>

			</tr>

			<tr>
				<td>How'd You Hear About Us?</td>
				<td><form:checkboxes path="sources" items="${sourceList}" /></td>

			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>

			</tr>

		</table>

	</form:form>



</body>
</html>