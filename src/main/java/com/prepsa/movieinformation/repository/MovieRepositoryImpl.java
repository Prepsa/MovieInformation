package com.prepsa.movieinformation.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prepsa.movieinformation.model.Movie;
import com.prepsa.movieinformation.model.User;
import com.prepsa.movieinformation.util.HibernateUtil;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveOrUpdateMovieInfo(Movie movie) {

		HibernateUtil.getSession(sessionFactory).merge(movie);
	}

	@Override
	public void deleteMovieInfo(int id) {
		Movie movie = getMovieInfoById(id);
		if(movie!=null) {
			HibernateUtil.getSession(sessionFactory).delete(movie);
		}
	}

	@Override
	public Movie getMovieInfoById(int id) {
		return (Movie) HibernateUtil.getSession(sessionFactory).get(Movie.class,id);
	}

	@Override
	public List<Movie> getAllMovieInfo() {
		return HibernateUtil.getSession(sessionFactory).createCriteria(Movie.class).list();
	}

	@Override
	public List<Movie> getMovieIdByName(String name) {
//		Criteria criteria = HibernateUtil.getSession(sessionFactory).createCriteria(Movie.class);
//		Movie movie = (Movie) criteria.add(Restrictions.eq("movieName", name)).uniqueResult();
//		if (movie != null) {
//			return movie.getId();
//		} else {
//			return 0;
//		}
		
		Criteria criteria = HibernateUtil.getSession(sessionFactory).createCriteria(Movie.class);
		return criteria.add(Restrictions.like("movieName", name+"%")).list();
	}

}
