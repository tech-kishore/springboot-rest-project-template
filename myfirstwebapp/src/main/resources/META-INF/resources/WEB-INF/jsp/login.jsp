<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Login Page</title>
</head>
<body>
	<div class="container">
		<h1>Welcome to Login page!</h1>
		<pre>${errorMessage}</pre>
		<form method="post">
			name: <input type="text" name="name"> password: <input
				type="password" name="password"> <input type="Submit"
				value="Submit">
		</form>
	</div>
	<script type="text/javascript"
		src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>