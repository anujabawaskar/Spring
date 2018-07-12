<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration form</title>
</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First name : <form:input path="firstName"/>
	<br><br>
	
	Last name : <form:input path="lastName"/>
	
	<br><br>
	<form:select path="country">
		<form:options items="${student.countryOptions }" />
	
	</form:select>
	
	<br><br>
	Java<form:radiobutton path="favouriteLanguage" value="Java"/>
	C<form:radiobutton path="favouriteLanguage" value="C"/>
	python<form:radiobutton path="favouriteLanguage" value="Python"/>
	C#<form:radiobutton path="favouriteLanguage" value="C#"/>
	
	<br><br>
	Linux<form:checkbox path="operatingSystem" value="Linux"/>
	Mac<form:checkbox path="operatingSystem" value="Mac"/>
	Windows<form:checkbox path="operatingSystem" value="Windows"/>	
	
	<br><br>
	<input type="submit" value="submit"/>
	
	</form:form>

</body>
</html>