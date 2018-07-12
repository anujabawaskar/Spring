<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer registration</title>

	<style>
		.error {color: red}
	</style>
</head>
<body>
	<form:form action="processForm" modelAttribute="customer">
	
		First name : <form:input path="firstName"/>
		<br><br>
		
		Last name(*) : <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"></form:errors>
		
		<br><br>
		
		Free passes : <form:input path="passes"/>
		<form:errors path="passes" cssClass="error"></form:errors>
		
		<br><br>
		
		Postal code : <form:input path="postalcode"/>
		<form:errors path="postalcode" cssClass="error"></form:errors>
		
		<br><br>
		
		Course code : <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"></form:errors>
		
		<br><br>
		
		
		<input type="submit" value="Submit it">
	
	
	</form:form>



</body>
</html>