package com.prepsa.movieinformation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.prepsa.movieinformation.model.Movie;
import com.prepsa.movieinformation.service.MovieService;
import com.prepsa.movieinformation.util.ImageUtil;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/movie_form",method = RequestMethod.GET)
	public String movieForm() {
		return "movieForm";
	}
	
	@RequestMapping(value="/movie_edit",method = RequestMethod.GET)
	public String movieEdit(@RequestParam int id, Model model) {
		model.addAttribute("m", movieService.getMovieInfoById(id));
		return "movieEditForm";
	}
	
	@RequestMapping(value="/movie_saveOrUpdate",method = RequestMethod.POST)
	public String movieFormPost(@ModelAttribute Movie movie, @RequestParam CommonsMultipartFile file) {
		String imageUrl="";
		if(file.getOriginalFilename().isEmpty()) {
			imageUrl = movieService.getMovieInfoById(movie.getId()).getImageUrl();
		}else {
			imageUrl = ImageUtil.writeImageToFile(file);
		}
		movie.setImageUrl(imageUrl);
		movieService.saveOrUpdateMovieInfo(movie);
		return "redirect:/movie_list";
	}
	
	@RequestMapping(value="/movie_list",method = RequestMethod.GET)
	public String movieList(Model model) {
		model.addAttribute("movies", movieService.getAllMovieInfo());
		return "movieList";
	}
	
	@RequestMapping(value="/movie_delete",method = RequestMethod.GET)
	public String deleteMovie(@RequestParam int id) {
		movieService.deleteMovieInfo(id);
		return "redirect:/movie_list";
	}
}
