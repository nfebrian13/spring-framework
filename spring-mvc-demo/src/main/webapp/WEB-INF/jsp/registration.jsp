<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>

<style type="text/css">
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	padding: 8px;
	margin: 16px;
}
</style>

</head>
<body>
	<h1>Registration</h1>

	<form:form modelAttribute="registration">
		<form:errors path="*" cssClass="errorblock" element="div" />
		<table>
			<tr>
				<td><spring:message code="name" /></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Regitstration">
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>