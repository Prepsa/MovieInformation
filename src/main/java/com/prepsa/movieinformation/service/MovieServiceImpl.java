package com.prepsa.movieinformation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prepsa.movieinformation.model.Movie;
import com.prepsa.movieinformation.repository.MovieRepository;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	@Override
	public void saveOrUpdateMovieInfo(Movie movie) {
		movieRepository.saveOrUpdateMovieInfo(movie);
	}

	@Override
	public void deleteMovieInfo(int id) {
		movieRepository.deleteMovieInfo(id);
	}

	@Override
	public Movie getMovieInfoById(int id) {
		return movieRepository.getMovieInfoById(id);
	}

	@Override
	public List<Movie> getAllMovieInfo() {
		return movieRepository.getAllMovieInfo();
	}

	@Override
	public List<Movie> getMovieIdByName(String name) {
		return movieRepository.getMovieIdByName(name);
	}

}
