<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>The Form</title>

<style type="text/css">
.error {
	color: red
}
</style>

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/myStyle.css">

</head>

<body>

	<div class="form-style-1">
		<form:form action="processForm" modelAttribute="customer">

			<form:label path="name"> Customer Name:<span
					class="required">*</span>
			</form:label>
			<form:input path="name" />
			<form:errors path="name" cssClass="error"></form:errors>

			<br>

			<form:label path="age"> Age:
			</form:label>
			<form:input path="age" />
			<form:errors path="age" cssClass="error"></form:errors>

			<br>

			<form:label path="zipcode"> Zip Code:
			</form:label>
			<form:input path="zipcode" />
			<form:errors path="zipcode" cssClass="error"></form:errors>

			<br>

			<input type="submit" value="Submit" />
		</form:form>
	</div>

</body>

</html>