<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<td><c:out value="${customerVO.name}" /></td>
				<td><c:out value="${customerVO.email}" /></td>
				<td><c:out value="${customerVO.age}" /></td>
				<td><c:out value="${customerVO.gender}" /></td>
				<td><c:out value="${customerVO.birthDay}" /></td>
			</tr>
		</c:forEach>
	</c:if>

</table>