package com.prepsa.movieinformation.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prepsa.movieinformation.service.MovieService;
import com.prepsa.movieinformation.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("movies", movieService.getAllMovieInfo());
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		model.addAttribute("currentDate", currentDate);
		return "home";
	}

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@RequestParam Map<String, String> loginPost, HttpSession session,
			HttpServletRequest request) {
		String username = loginPost.get("uname");
		String password = loginPost.get("upass");
		
		int isUser= userService.login(username, password);
		
		if (isUser >=1) {
			session.setAttribute("username", username);
			session.setAttribute("userid", isUser);
			return "redirect:/home";
		}
		request.setAttribute("loginMsg", "Wrong username or password!!!");
		return "redirect:/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut( HttpSession session, HttpServletRequest request) {
		session.invalidate();
		request.setAttribute("loginMsg", "You are successfully logged out!!!");
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchMovie(@RequestParam Map<String,String> searchMovie, Model model) {
		String searchString =  searchMovie.get("searchField");
		model.addAttribute("searchResult", movieService.getMovieIdByName(searchString));
		return "movieProfile";
	}
}
