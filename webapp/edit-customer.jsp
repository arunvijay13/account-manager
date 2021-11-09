<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD CUSTOMER</title>
<link rel="stylesheet" href="css/add.css"/>
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<h3>Account Manager</h3>
		</div>
	</div>
	<div class="form-container">
		<form action="CustomerServletController" method="post">
			<input type="hidden" name="COMMAND" value="UPDATE"  />
			<input type="hidden" name="id" value="${LOAD_CUSTOMER.id}"  />
			<label>FirstName</label>
			<input type="text" value="${LOAD_CUSTOMER.firstName}" name="firstName" /> <br><br>
			<label>LastName</label>
			<input type="text" value="${LOAD_CUSTOMER.lastName}" name="lastName" /> <br><br>
			<label>Email</label>
			<input class="email" type="text" value="${LOAD_CUSTOMER.email}" name="email" /> <br><br>
			<label>Amount</label>
			<input class="amount" type="text" value="${LOAD_CUSTOMER.amount}" name="amount" /> <br><br>
			<input class="add" type="submit" value="UPDATE" />
		</form>
	</div>
	<div class="back-to-home">
		<a href="CustomerServletController">Back to Home</a>
	</div>
</body>
</html>