<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<title> List Todos Page</title>
	</head>
	
	<body>
	<!-- navigation bar -->
	<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
	<a class="navbar-brand m-1" href="/list-todos">Todo web app</a>
	<div class="collapse navbar-collapse">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="/">Home</a></li>
			<li class="nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
		</ul>
	</div>
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
	</ul>	
</nav>
	
	
	<!-- make use of bootstrap -->
	<div class="container">
	<div>
		<h1>Your Todos </h1>
		<table class="table">
		  <thead>
		     <tr>
		       <th>Description</th>
		       <th>Target Date</th>
		       <th>Is Done?</th>
		       <th></th>
		       <th></th>		 
		     </tr>
		  </thead>
		  <tbody>
		  <!-- for each item in the todos list -->
		    <c:forEach items="${todos}" var="todo">
		    <tr>
		       <td>${todo.description}</td>
		       <td>${todo.targetDate}</td>
		       <td>${todo.done}</td>
		       <!-- we pass the id of todo to be deleted as query parameter to the controller -->
		       <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a>   </td>
		       <td> <a href="update-todo?id=${todo.id}" class="btn btn-success">UPDATE</a>   </td>
		    </tr>		
		    </c:forEach>
		 </tbody>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
		<script>src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"</script>
		<script>src="webjars/jquery/3.6.0/jquery.min.js"</script>
	</body>
</html>
