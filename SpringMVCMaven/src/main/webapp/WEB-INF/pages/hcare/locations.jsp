<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springform"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<springform:form method="POST" commandName="locationsForm"
	action="locationSave.htm">
	<springform:errors />
	<table border=1 id="locationsTable">
		<caption>
			<B>Add Locations</B>
		</caption>
		<thead>
			<tr>
				<th></th>
				<th>Area</th>
				<th>Pincode</th>
				<th>City</th>
				<th>State</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
		<c:choose>
			<c:when test="${not empty locationsVO.locations}">
				<c:forEach items="${locationsVO.locations}" var="locations"
					varStatus="status">
					<tr>
						<td><springform:checkbox
								path="locations[${status.index}].locationId"
								value="${locations.locationId}" /></td>
						<td><springform:input path="locations[${status.index}].area"
								value="${locations.area}" /></td>
						<td><springform:input
								path="locations[${status.index}].pincode"
								value="${locations.pincode}" /></td>
						<td><springform:input path="locations[${status.index}].city"
								value="${locations.city}" /></td>
						<td><springform:input path="locations[${status.index}].state"
								value="${locations.state}" /></td>
						<td><input type="button" name="DeleteRow" value="Delete Row"
							id="locations[${status.index}].deleteRow" disabled="disabled"
							onclick="deleteRow(this);" /></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
				<td><input type="checkbox" name="locations[0].locationId" id="locations[0].locationId"
								value="" /></td>
				<td><input type="text" name="locations[0].area" id="locations[0].area"
								value="" /></td>
				<td><input type="text" name="locations[0].pincode" id="locations[0].pincode"
								value="" /></td>
				<td><input type="text" name="locations[0].city" id="locations[0].city"
								value="" /></td>
				<td><input type="text" name="locations[0].state" id="locations[0].state"
								value="" /></td>
				</tr>
			</c:otherwise>
		</c:choose>

	</table>
	<table align="center">
		<tr>
			<td colspan="6" align="center"><input type="button"
				name="AddRow" value="Add Row" onclick="addRow('locationsTable')" /></td>
		</tr>
		<tr>
			<td colspan="6"><input type="Submit" name="Save" /></td>
		</tr>
	</table>


	<table border=1 id="locationsStaticTable" style="width: 800px">
		<caption>
			<B>Existing Locations</B>
		</caption>
		<thead>
			<tr>
				<th>Location ID</th>
				<th>Area</th>
				<th>Pincode</th>
				<th>City</th>
				<th>State</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
		<c:forEach items="${existingLocations.locations}" var="exLocations"
			varStatus="status">
			<tr>
				<td><c:out value="${exLocations.locationId}"></c:out> </td>
				<td><c:out value="${exLocations.area}"></c:out> </td>
				<td><c:out value="${exLocations.pincode}"></c:out> </td>
				<td><c:out value="${exLocations.city}"></c:out> </td>
				<td><c:out value="${exLocations.state}"></c:out> </td>
				<td><input type="button" name="${exLocations.locationId}" id="${exLocations.locationId}" value="Delete Location"/> </td>
			</tr>
		</c:forEach>
	</table>
</springform:form>

<SCRIPT>
	function addRow(tableID) { //6 cells
		var table = document.getElementById(tableID);

		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);

		var cell0 = row.insertCell(0);
		var cell1 = row.insertCell(1);
		var cell2 = row.insertCell(2);
		var cell3 = row.insertCell(3);
		var cell4 = row.insertCell(4);
		var cell5 = row.insertCell(5);

		var cell0Element = document.createElement("input");
		cell0Element.type = "checkbox";
		cell0Element.name = "locations[" + (rowCount - 1) + "].locationId";
		cell0.appendChild(cell0Element);

		var cell1Element = document.createElement("input");
		cell1Element.type = "text";
		cell1Element.name = "locations[" + (rowCount - 1) + "].area";
		cell1.appendChild(cell1Element);

		var cell2Element = document.createElement("input");
		cell2Element.type = "text";
		cell2Element.name = "locations[" + (rowCount - 1) + "].pincode";
		cell2.appendChild(cell2Element);

		var cell3Element = document.createElement("input");
		cell3Element.type = "text";
		cell3Element.name = "locations[" + (rowCount - 1) + "].city";
		cell3.appendChild(cell3Element);

		var cell4Element = document.createElement("input");
		cell4Element.type = "text";
		cell4Element.name = "locations[" + (rowCount - 1) + "].state";
		cell4.appendChild(cell4Element);

		cell5.innerHTML = "<input type='button' name='DeleteRow' value='Delete Row' id='"
				+ (rowCount - 1) + "' onclick='deleteRow(this.id);' />";

	}

	function deleteRow(rowId) {
		try {
			document.getElementById('locationsTable').deleteRow(rowId);
		} catch (e) {
			alert(e);
		}
	}
</SCRIPT>
