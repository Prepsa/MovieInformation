package com.prepsa.movieinformation.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.prepsa.movieinformation.service.MovieService;
import com.prepsa.movieinformation.service.UserService;
import com.prepsa.movieinformation.util.ImageUtil;

@Controller
public class ImageDisplayController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/user_image_display",method = RequestMethod.GET)
	public void userDisplayImage(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) {
	   String imageUrl = userService.getUserInfoById(id).getImageUrl();
	   ImageUtil.displayImage(id,imageUrl,request,response);
	}
	
	@RequestMapping(value="/movie_image_display",method = RequestMethod.GET)
	public void movieDisplayImage(@RequestParam int id, HttpServletRequest request, HttpServletResponse response) {
	   String imageUrl = movieService.getMovieInfoById(id).getImageUrl();
	   ImageUtil.displayImage(id,imageUrl,request,response);
	}
	
}
