<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Dojo</title>
</head>
<body>
<h1> <c:out value="${dojo.name}"/> location ninjas</h1>

<table>
	<thead>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ninjas}" var="n">
			<tr>
				<td><c:out value="${n.firstName}"></c:out></td>
				<td><c:out value="${n.lastName}"></c:out></td>
				<td><c:out value="${n.age}"></c:out></td>
			</tr>
		</c:forEach>
	</tbody>


</table>

	
</body>
</html>