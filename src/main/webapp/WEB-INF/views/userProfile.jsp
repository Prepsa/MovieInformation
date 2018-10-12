<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
<link rel="stylesheet" href="resources/css/displayLayout.css">
<%@ include file="header.jsp"%>
</head>
<body>
<div class="outer">
	<div class="container">
		<div class="box" >
		<div>
	<img src="user_image_display?id=${userid}" alt="pic" id="user_img"/>
	</div>
	<div class="infoBox">
	<h1>Your info:</h1>
			<h2>${user.id}</h2>
			<h2>${user.name}</h2>
			<h2>${user.email}</h2>
			<h2>${user.number}</h2>
			<h2>${user.gender}</h2>
			<h2>${user.dob}</h2>
			</div>			
		</div>
	</div>
	</div>
</body>
</html>