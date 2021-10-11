<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Mortgage Form</title>
</head>
<body>

	<form:form action="crunchingNumbers" modelAttribute="theirInfo">

			Principal Loan:<form:input path="principalLoan" />
		<br>

			Down Payment:<form:input path="downPayment" />
		<br>

			Interest:<form:input path="interestRate" />
		<br>

			Loan Term:<form:input path="loanTerm" />
		<br>



		<input type="submit" value="Submit" />

	</form:form>

</body>
</html>