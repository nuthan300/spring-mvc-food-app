package com.ty.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.Products;
import com.ty.food.service.ProductServices;

@Controller
public class ProductController {

	@Autowired
	private ProductServices productServices;
	
	@RequestMapping("/loadproduct")
	private ModelAndView loadProduct() {
		ModelAndView modelAndView = new ModelAndView("loadproduct.jsp");
		modelAndView.addObject("product", new Products());
		return modelAndView;
	}
	
	@RequestMapping("/saveproduct")
	private ModelAndView saveProduct(@ModelAttribute Products products){
		ModelAndView modelAndView = new ModelAndView("adminmenu.jsp");
		productServices.saveProduct(products);
		modelAndView.addObject("msg","item added successfully");
		return modelAndView;
	}
}
