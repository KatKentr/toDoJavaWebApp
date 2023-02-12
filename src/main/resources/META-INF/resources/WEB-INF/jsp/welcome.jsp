<%@ include file="common/header.jspf" %>
	<!-- include navigation bar -->
	<%@ include file="common/navigation.jspf" %>
	
	<div class="container">
	<h1> Welcome ${name} </h1>
	    <!-- we give the url that the user will be redirected to when they press the link. This url should be mapped to a mathod in the Controller class. This method would probably return a new jsp page -->
		<a href="list-todos">Manage</a> your todos
	</div>	
<%@ include file="common/footer.jspf" %>	