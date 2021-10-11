<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Breakdown</title>
</head>
<body>
	Monthly Payment: ${theirInfo.monthlyPayment}
	<br>


	<table>

		<tr>
			<td>Month</td>
			<td>Principal Payment</td>
			<td>Interest Paid</td>
			<td>New Loan Balance</td>
		</tr>

		<c:forEach var="eachPayment" items="${theirInfo.theBreakdown}">

			<tr>

				<td>${eachPayment.monthNumber}</td>
				<td>${eachPayment.principalPaid}</td>
				<td>${eachPayment.interestPaid}</td>
				<td>${eachPayment.newLoanBalance}</td>

			</tr>

		</c:forEach>

	</table>

</body>
</html>