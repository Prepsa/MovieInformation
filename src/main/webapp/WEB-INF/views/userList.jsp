<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Member List</title>
<%@ include file = "header.jsp" %>
</head>
<body>
	<h1>List of members</h1>
	<a href="user_form">New User</a>
	<c:if test="${!empty users}">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>SN</th>
				<th>ID</th>
				<th>User Name</th>
				<th>Email</th>
				<th>Contact Number</th>
				<th>Gender</th>
				<th>DOB</th>
				<th>Photo</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${users}" var="user" varStatus="u">
				<tr>
					<td>${u.count}</td>
					<td>${user.id}</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.number}</td>
					<td>${user.gender}</td>
					<td>${user.dob}</td>
					<td><img src="user_image_display?id=${user.id}" alt="pic" width="50px" height="50px"></td>
					<td><a href="user_edit?id=${user.id}">Edit</a> | <a href="user_delete?id=${user.id}">Delete</a></td>
				</tr>
				</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>