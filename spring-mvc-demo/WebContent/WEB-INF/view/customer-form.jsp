<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Customer Registration Form</title>
		<style>
			.error {color:red}
		</style>
	</head>
	<body>
		Fill out the form. Asterisk (*) means required. 
		
		<form:form action="processForm" modelAttribute="customer">
			<br><br>
			First Name: <form:input path="firstName" />
			
			<br><br>
			
			Last Name (*): <form:input path="lastName" />
			<form:errors path="lastName" cssClass="error" />
			
			<br><br>
			
			Free Passes: <form:input path="freePasses" />
			<form:errors path="freePasses" cssClass="error" />
			
			<br><br>
			
			ZipCode: <form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="error" />
			
			<br><br>
			
			Course Code: <form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="error" />
			
			<br><br>
			<input type="submit" value="submit" />
			
		</form:form>
	</body>
</html>