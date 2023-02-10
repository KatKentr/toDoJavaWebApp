<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
	<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
	<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >	
		<title> Add Todo Page</title>
	</head>
	<body>
	<!-- make use of bootstrap -->
	<div class="container">
	<div>
		<h1>Enter Todo Details </h1>
		<!-- we bind it to the todo attribute of the method addNewTodo() in the TodoController-->
		<form:form method="post" modelAttribute="todo">
		<!-- Using the todo Bean, we want to map the form element text to the member variable description-->
		     <fieldset class="mb-3">
		        <form:label type="text" path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/>
			</fieldset>
			
			<fieldset class="mb-3">
		        <form:label type="text" path="targetDate">Target date</form:label>
                <form:input type="text" path="targetDate" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>
				
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" path="done"/>
				<input type="submit" class="btn btn-success" />
			</form:form>

		</div>
		<script>src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"</script>
		<script>src="webjars/jquery/3.6.0/jquery.min.js"</script>
		<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
	     $('#targetDate').datepicker({
	       format: 'yyyy-mm-dd'
	    });
      </script>
	
	</body>
</html>
