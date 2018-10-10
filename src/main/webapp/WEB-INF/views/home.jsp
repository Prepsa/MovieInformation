<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="resources/css/displayLayout.css">
<%@ include file="header.jsp"%>
</head>
<body>
	<div class="outer">
		<c:if test="${!empty movies}">
			<div class="container">
				<c:forEach items="${movies }" var="m" varStatus="u">
				<c:if test="${m.releaseDate >= currentDate}">
					<div class="box">
						<div class="imgBox">
							<img src="movie_image_display?id=${m.id}" alt="pic"
								id="movie_img"  />
						</div>
						<div class="infoBox">
							Movie Name: ${m.movieName} <br /> Director: ${m.director}<br />
							Release Date: ${m.releaseDate}<br /> 
							RunTime: ${m.runTime}
						</div>
					</div>
					</c:if>
				</c:forEach>
			</div>
		</c:if>
	</div>
</body>
</html>