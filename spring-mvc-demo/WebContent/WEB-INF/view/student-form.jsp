<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>student-form page</title>
	</head>
	<body>
		<form:form modelAttribute="student" action="processForm" method="GET">
		
			First Name: <form:input path="firstName" />
			<br><br>
			
			Last Name: <form:input path="lastName" />
			<br><br>
			
			Country: 
				<form:select path="country">
					<form:options items="${student.countryOptions}" />
				</form:select>
			<br><br>
				
			Favorite Language:
				<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
			<br><br>
			
			Which OS do you have experience with?
				Linux<form:checkbox path="operatingSystems" value="Linux" />
				Mac OS<form:checkbox path="operatingSystems" value="Mac OS" />
				Windows<form:checkbox path="operatingSystems" value="Windows" />
			<br><br>
			
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>