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
			<input type="hidden" name="COMMAND" value="ADD"  />
			<label>FirstName</label>
			<input type="text" value="" name="firstName" /> <br/> <br/>
			<label>LastName</label>
			<input type="text" value="" name="lastName" /> <br/> <br/>
			<label>Email</label>
			<input class="email" type="text" value="" name="email" /> <br/> <br/>
			<label>Amount</label>
			<input class="amount" type="text" value="" name="amount" /> <br/> <br/>
			<input class="add" type="submit" value="ADD" />
		</form>
	</div>
	<div class="back-to-home">
		<a href="CustomerServletController">Back to Home</a>
	</div>
</body>
</html>