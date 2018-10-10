<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Profile</title>
<%@ include file = "header.jsp" %>
</head>
<body>
<div class="container">
		<div class="row col-md-10">
			<div class="col-md-2"></div>
			<div class="col-md-8 jumbotron">
	<fieldset>
		<legend>Profile edit</legend>

		<form action="user_update" method="post" class= "form-horizontal" enctype="multipart/form-data">
		<div>
		<label>ID</label><input type="text" name= "id" readonly="readonly" value="${user.id}" class = "form-control"/>
		</div>
			<div class="form-group">
				<label> Name</label> <input type="text" name="name"
					value="${user.name}" class="form-control">
			</div>

			<div class="form-group">
				<label>Email</label> <input type="text" name="email"
					value="${user.email}" class="form-control">
			</div>
			<div class="form-group">
				<label>Contact Number</label> <input type="number" name="number"
					value="${user.number}" class="form-control">
			</div>
			<div class="form-group">
				<label>Password</label> <input type="text" name="password"
					value="${user.password}" class="form-control">
			</div>
			<div class="form-group">
				<label>Gender</label> <input type="radio" name="gender" value="Male"
					${user.gender=='Male'?'checked':''}>Male <input
					type="radio" name="gender" value="Female"
					${user.gender=='Female'?'checked':''}>Female
			</div>
			<div class="form-group">
				<label>DOB</label> <input type="date" name="dob" value="${user.dob}"
					class="form-control">
			</div>

			<div class="form-group">
				<label>Upload</label> <input type="file" name="file"
					class="form-control">
			</div>
<!-- 
			<div class="form-group">
				<input type="checkbox" name="tandc" class="form-control"><label>I
					accept the Terms and Conditions </label>
			</div>
			 -->
			<div class="form-group">
				<input type="submit" value="Submit" class="btn btn-primary">
			</div>
		</form>
	</fieldset>
	</div>
	<div class="col-md-2"></div>
	</div>
	</div>
</body>
</html>