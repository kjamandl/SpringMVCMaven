<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title><tiles:insertAttribute name="title" /></title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.18/jquery-ui.min.js"></script>
</head>
<body>	
	<table width="100%" border="thin" bordercolor="aqua">
		<tr><td colspan="2"><!-- Header -->
		<tiles:insertAttribute name="header"/></td>
		</tr>
		<tr height="775px"><td style="vertical-align:top;width: 20%;"><tiles:insertAttribute name="menu" /></td> <td style="vertical-align:top;width: 80%;"><tiles:insertAttribute name="body" /></td>
		</tr>
		<tr> <td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
		
	</table>
	
	
</body>
</html>