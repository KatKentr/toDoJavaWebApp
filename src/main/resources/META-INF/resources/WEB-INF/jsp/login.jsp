<html>
	<head>
		<title> Login Page</title>
	</head>
	<body>
	<div class="container">
        <h1>Login</h1>		
		<pre>${errorMessage}</pre>
		<!-- we use post method in order not to expose this information  -->
		<form method="post">
		  Name: <input type="text" name="name">
		  Password: <input type="password" name="password">
		  <input type="submit">
		</form>	
    </div>
	</body>
</html>