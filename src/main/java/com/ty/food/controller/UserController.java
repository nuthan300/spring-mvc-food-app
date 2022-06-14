package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.dto.User;
import com.ty.food.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;
	
	@RequestMapping("/adduser")
	public ModelAndView loadUser() {
		ModelAndView modelAndView = new ModelAndView("adduser.jsp");
		modelAndView.addObject("saveuser",new User());
		return modelAndView;
	}
	
	@RequestMapping("/createuser")
	public ModelAndView saveUser(@ModelAttribute User user) {
		service.saveUser(user);
		ModelAndView modelAndView = new ModelAndView("adminmenu.jsp");
		modelAndView.addObject("msg","User Added successfully");
		return modelAndView;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/loaduser")
	public ModelAndView loadUser(HttpSession session) {
		session.setAttribute("itemlist", new ArrayList<Item>());
		ModelAndView modelAndView = new ModelAndView("viewuser.jsp");
		List<FoodOrder> list = (List<FoodOrder>)session.getAttribute("orderlist");
		if(list!= null) {
		modelAndView.addObject("mylist",list);
		}
		return modelAndView;
	}
}
