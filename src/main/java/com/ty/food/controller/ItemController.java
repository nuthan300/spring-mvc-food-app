package com.ty.food.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Item;
import com.ty.food.dto.Products;
import com.ty.food.service.ProductServices;
import com.ty.food.service.UserService;

@Controller
public class ItemController {

	@Autowired
	ProductServices productServices;
	
	@Autowired
	UserService userService;

	@RequestMapping("/loaditem")
	public ModelAndView loadItems(HttpServletRequest req,HttpSession session) {

		session.setAttribute("productlist", productServices.getAllProducts());
		ModelAndView modelAndView = new ModelAndView("displayproducts.jsp");
		modelAndView.addObject("mylist",session.getAttribute("productlist"));
		return modelAndView;
	}
	
	@RequestMapping("/additems")
	public ModelAndView addItems(HttpServletRequest req, HttpSession session) {
		session.setAttribute("productid", Integer.parseInt(req.getParameter("productid")));
		ModelAndView modelAndView = new ModelAndView("additems.jsp");
		Products products = productServices.getProductById((Integer)session.getAttribute("productid"));
		modelAndView.addObject("productname",products.getName());
		modelAndView.addObject("productcost",products.getCost());
		modelAndView.addObject("item", new Item());
		return modelAndView;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/saveitems")
	public ModelAndView saveItems(HttpServletRequest req, @ModelAttribute Item item, HttpSession session) {
		
		ModelAndView modelAndView = new ModelAndView("loaditem");
		List<Item> list =(List<Item>) session.getAttribute("itemlist");
		item.setMrp(item.getMrp());
		list.add(item);
		modelAndView.addObject("msg","Item Added Successfully");
		return modelAndView;
	}
	
	@RequestMapping("/submititem")
	public ModelAndView submitItems(HttpServletRequest req) {
		
		ModelAndView modelAndView = new ModelAndView("loadorder");
		return modelAndView;
	}
	
}
