<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Confirmation Page</title>
	</head>
	<body>
		The student is confirmed: ${student.firstName} ${student.lastName}
		
		<br><br>
		
		Country: ${student.country}
		<br><br>
		
		Favorite Language: ${student.favoriteLanguage}
		<br><br>
		
		Experienced with: 
		<ul>
			<c:forEach var="os" items="${student.operatingSystems}">
				<li>${os}</li>
			</c:forEach>
		</ul>
	</body>
</html>