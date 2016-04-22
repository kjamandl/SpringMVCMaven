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
<title>All Customers</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
</head>
<body>
		<table border=1 align="center">
			<tr>
				<td>Name</td>
				<td>Email</td>
				<td>Age</td>
				<td>Gender</td>
				<td>Birthday</td>
			</tr>
			
			<c:if test="${not empty customersList}">
				<c:forEach items="${customersList}" var="customerVO">
					<tr>
						<td><c:out value="${customerVO.name}" /> </td>
						<td><c:out value="${customerVO.email}" /> </td>
						<td><c:out value="${customerVO.age}" /> </td>
						<td><c:out value="${customerVO.gender}" /> </td>
						<td><c:out value="${customerVO.birthDay}" /> </td>
					</tr>	
				</c:forEach>
			</c:if>
			
		</table>
</body>
</html>