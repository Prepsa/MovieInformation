<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie List</title>
<%@ include file = "header.jsp" %>
</head>
<body>
<h1>List of movies</h1>
	<a href="movie_form">New Movie</a>
	<c:if test="${!empty movies}">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>SN</th>
				<th>ID</th>
				<th>Movie Title</th>
				<th>Released Date</th>
				<th>Run Time</th>
				<th>Director</th>
				<th>Genre</th>
				<th>Cast</th>
				<th>Synopsis</th>
				<th>Photo</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${movies}" var="m" varStatus="u">
				<tr>
					<td>${u.count}</td>
					<td>${m.id}</td>
					<td>${m.movieName}</td>
					<td>${m.releaseDate}</td>
					<td>${m.runTime}</td>
					<td>${m.director}</td>
					<td>${m.genre}</td>
					<td>${m.cast}</td>
					<td>${m.synopsis}</td>
					<td><img src="movie_image_display?id=${m.id}" alt="pic" width="50px" height="50px"/></td>
					<td><a href="movie_edit?id=${m.id}">Edit</a> | <a href="movie_delete?id=${m.id}">Delete</a></td>
				</tr>
				</c:forEach>
		</tbody>
	</table>
	</c:if>
</body>
</html>