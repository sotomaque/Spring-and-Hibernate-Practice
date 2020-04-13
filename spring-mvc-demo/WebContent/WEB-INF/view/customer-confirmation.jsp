<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Customer Successfully Registered</title>
	</head>
	<body>
		
		The customer has been confirmed: ${customer.firstName} ${customer.lastName} ${customer.postalCode}
		<br><br>
		Free Passes: ${customer.freePasses}
		<br><br>
		Course Code: ${customer.courseCode}
	</body>
</html>