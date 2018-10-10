<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movie profile</title>
<link rel="stylesheet" href="resources/css/displayLayout.css">
<%@ include file = "header.jsp" %>
</head>
<body>
<div class="outer">
	<div class="container">
	<c:if test="${!empty searchResult}">
	<c:forEach items="${searchResult}" var="search" varStatus="s">
		<div class="box" >
		<div>
	<img src="movie_image_display?id=${search.id}" alt="pic" id="movie_img" />
	</div>
		<div class="infoBox">
							Movie Name: ${search.movieName} <br /> Director: ${search.director}<br />
							Release Date: ${search.releaseDate}<br /> 
							RunTime: ${search.runTime}
						</div>			
		</div>
		</c:forEach>
		</c:if>
	</div>
	</div>
</body>
</html>