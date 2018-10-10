package com.prepsa.movieinformation.service;

import java.util.List;

import com.prepsa.movieinformation.model.Movie;

public interface MovieService {

	public void saveOrUpdateMovieInfo(Movie movie);
	//public void updateMovieInfo(Movie movie);
	public void deleteMovieInfo(int id);
	public Movie getMovieInfoById(int id);
	public List<Movie> getAllMovieInfo();
	public List<Movie> getMovieIdByName(String name);
}
