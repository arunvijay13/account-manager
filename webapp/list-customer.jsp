<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ACCOUNT MANAGER</title>
<link rel="stylesheet" href="css/demo.css"/>
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<h3>Account Manager</h3>
		</div>
	</div>
	<div class="btn">
		<a href="add-customer.jsp">ADD CUSTOMER</a>
	</div>
	<div class="container">
		<table>
			<thead>
				<th>FirstName</th>
				<th>LastName</th>
				<th>Email</th>
				<th>Amount</th>
				<th>Action</th>
			</thead>
			<tbody>
				<c:forEach var="tempList" items="${CUSTOMER_LIST}">
					<tr>
						<td>${tempList.firstName}</td>
						<td>${tempList.lastName}</td>
						<td>${tempList.email}</td>
						<td>${tempList.amount}</td>
						<td><a class="update" href="CustomerServletController?id=${tempList.id}&COMMAND=LOAD">UPDATE</a> |
							<a class="delete" href="CustomerServletController?id=${tempList.id}&COMMAND=DELETE">DELETE</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>