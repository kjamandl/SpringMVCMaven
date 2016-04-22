<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
	<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Home</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
	Customer Home

	<springform:form method="POST" commandName="customer"
		action="customerSave">
		<springform:errors />
		<table border=1 align="center">
			<tr>
				<td>Name</td>
				<td><springform:input path="name" /></td>
				<td><springform:errors path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><springform:input path="email" /></td>
				<td><springform:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><springform:input path="age" /></td>
				<td><springform:errors path="age" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><springform:input path="gender" /></td>
				<td><springform:errors path="gender" cssClass="error" /></td>
			</tr>
			
			<tr>
				<td>Birthday</td>
				<td><springform:input path="birthDay" /></td>
				<td><springform:errors path="birthDay" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="4"><input type="Submit" name="Submit" /></td>
			</tr> 
		</table>
	</springform:form>

<jsp:include page="allCustomers.jsp" />
</body>
</html>