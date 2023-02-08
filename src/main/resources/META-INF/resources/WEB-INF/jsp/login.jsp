<html>
	<head>
		<title> Login Page</title>
	</head>
	<body>
		Welcome to the login page
		
		<pre>${errorMessage}</pre>
		<!-- we use post method in order not to expose this information  -->
		<form method="post">
		  Name: <input type="text" name="name">
		  Password: <input type="password" name="password">
		  <input type="submit">
		</form>	
	</body>
</html>