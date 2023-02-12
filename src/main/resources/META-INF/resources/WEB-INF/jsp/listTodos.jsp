<%@ include file="common/header.jspf" %>
	<!-- include navigation bar -->
	<%@ include file="common/navigation.jspf" %>
		
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
<%@ include file="common/footer.jspf" %>	
