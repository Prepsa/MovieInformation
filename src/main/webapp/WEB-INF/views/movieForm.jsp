<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add a new movie</title>
<%@ include file="header.jsp"%>
</head>
<body>
	<div class="container">
		<div class="row col-md-10">
			<div class="col-md-2"></div>
			<div class="col-md-8 jumbotron">
				<fieldset style="width: 500px">
					<legend>Add a new movie</legend>

					<form action="movie_saveOrUpdate" method="post"
						class="form-horizontal" enctype="multipart/form-data">
						<div class="form-group">
							<label> Title</label> <input type="text" name="movieName"
								value="${m.movieName}" class="form-control">
						</div>

						<div class="form-group">
							<label>Release Date</label> <input type="date" name="releaseDate"
								value="${m.releaseDate}" class="form-control">
						</div>
						
						<div class="form-group">
							<label>Run Time</label> <input type="text" name="runTime"
								value="${m.runTime}" class="form-control">
						</div>
						<div class="form-group">
							<label>Director</label> <input type="text" name="director"
								value="${m.director}" class="form-control">
						</div>
						<div class="form-group">
							<label>Genre</label> <input type="text" name="genre"
								value="${m.genre}" class="form-control">
						</div>
						<div class="form-group">
							<label>Cast</label> <input type="text" name="cast"
								value="${m.cast}" class="form-control">
						</div>
						<div class="form-group">
							<label>Synopsis</label> <input type="text" name="synopsis"
								value="${m.synopsis}" class="form-control">
						</div>
						
						<div class="form-group">
							<label>Movie Poster</label> <input type="file" name="file"
								class="form-control">
						</div>
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