package com.prepsa.movieinformation.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.prepsa.movieinformation.model.User;
import com.prepsa.movieinformation.service.UserService;
import com.prepsa.movieinformation.util.ImageUtil;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_form", method = RequestMethod.GET)
	public String getUserForm() {
		return "userForm";
	}

	@RequestMapping(value = "/user_edit", method = RequestMethod.GET)
	public String editUserForm(@RequestParam int id, Model model) {
		model.addAttribute("user", userService.getUserInfoById(id));
		return "userEditForm";
	}

	@RequestMapping(value = "/user_save", method = RequestMethod.POST)
	public String saveUserInfo(@ModelAttribute User user, @RequestParam CommonsMultipartFile file,HttpSession session) {
		String username = user.getName();
		session.setAttribute("username", username);
		String imageUrl=ImageUtil.writeImageToFile(file);
		user.setImageUrl(imageUrl);
		userService.saveUserInfo(user);
		return "redirect:/home";
	}

	@RequestMapping(value = "/user_update", method = RequestMethod.POST)
	public String updateUserInfo(@ModelAttribute User user, @RequestParam CommonsMultipartFile file) {
		String imageUrl="";
		if(file.getOriginalFilename().isEmpty()) {
			imageUrl = userService.getUserInfoById(user.getId()).getImageUrl();
		}else {
			imageUrl = ImageUtil.writeImageToFile(file);
		}
		user.setImageUrl(imageUrl);
		userService.updateUserInfo(user);
		return "redirect:/user_list";
	}

	@RequestMapping(value = "/user_list", method = RequestMethod.GET)
	public String getUserList(Model model) {
		model.addAttribute("users", userService.getAllUsersInfo());
		return "userList";
	}

	@RequestMapping(value = "/user_delete", method = RequestMethod.GET)
	public String deleteUser(@RequestParam int id) {
		userService.deleteUserInfo(id);
		return "redirect:/user_list";
	}

	@RequestMapping(value = "/user_profile", method = RequestMethod.GET)
	public String getUserProfile(@RequestParam int id,Model model) {
		model.addAttribute("user", userService.getUserInfoById(id));
		return "userProfile";
	}
}
