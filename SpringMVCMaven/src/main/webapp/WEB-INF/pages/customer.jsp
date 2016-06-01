<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<springform:form method="POST" commandName="customer"
		action="customerSave.htm">
		<springform:errors />
		<table>
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

