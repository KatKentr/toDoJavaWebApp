<%@ include file="common/header.jspf" %>

	
	<!-- navigation bar -->
	<%@ include file="common/navigation.jspf" %>
		
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
	
	<%@ include file="common/footer.jspf" %>	
		
      <script type="text/javascript">
	     $('#targetDate').datepicker({
	       format: 'yyyy-mm-dd'
	    });
      </script>
