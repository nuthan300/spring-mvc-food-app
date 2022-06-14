package com.ty.food.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.dto.User;
import com.ty.food.service.FoodOrderService;
import com.ty.food.service.UserService;

@Controller
public class FoodOrderController {

	@Autowired
	UserService userService;
	
	@Autowired
	FoodOrderService orderService;
	
	@RequestMapping("/loadorder")
	public ModelAndView loadOrder(HttpServletRequest req, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("addorder.jsp");
		modelAndView.addObject("neworder",new FoodOrder());	
		return modelAndView;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveorder")
	public ModelAndView saveOrder(HttpServletRequest req, @ModelAttribute FoodOrder foodOrder, HttpSession session){	 
		
		User user = userService.getUserById((Integer)session.getAttribute("userid"));
		foodOrder.setUser(user);
		foodOrder.setItems((List<Item>) session.getAttribute("itemlist"));
		orderService.saveFoodOrder(foodOrder);
		ModelAndView modelAndView = new ModelAndView("loaduser");
		modelAndView.addObject("msg","Saved Order");
		return modelAndView;
	}
	
}
