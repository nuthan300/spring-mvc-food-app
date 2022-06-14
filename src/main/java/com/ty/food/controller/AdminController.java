package com.ty.food.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginadmin")
	public ModelAndView loginAdmin(HttpServletRequest req) {

		String user = req.getParameter("user");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		ModelAndView modelAndView = null;
		if (user.equals("admin")) { // Admin Login

			if (email.equals("admin@gmail.com") && password.equals("admin123")) {
				modelAndView = new ModelAndView("adminmenu.jsp");
				modelAndView.addObject("msg", "login successfull");
			} else {
				modelAndView = new ModelAndView("login.jsp");
				modelAndView.addObject("msg", "Incorrect username and password");
			}

		} else if (user.equals("user")) {
			User user2 = userService.validateUser(email, password);
			if (user2 != null) {
				HttpSession session = req.getSession() ;
				modelAndView = new ModelAndView("loaduser");
				session.setAttribute("userid", user2.getId());
				session.setAttribute("orderlist", user2.getFoodOrders());
				modelAndView.addObject("msg", "login successfull");
			} else {
				modelAndView = new ModelAndView("login.jsp");
				modelAndView.addObject("msg", "Incorrect username and password");
			}
		}
		return modelAndView;
	}
}
