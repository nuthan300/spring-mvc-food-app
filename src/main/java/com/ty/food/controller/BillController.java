package com.ty.food.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ty.food.dto.FoodOrder;
import com.ty.food.service.FoodOrderService;

@Controller
public class BillController {

	@Autowired
	FoodOrderService orderService;
	
	@RequestMapping("/generatebill")
	public ModelAndView generateBill(HttpServletRequest req, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("bill.jsp");
		int orderId = Integer.parseInt(req.getParameter("id"));
		FoodOrder foodOrder= orderService.getFoodOrderById(orderId);
		modelAndView.addObject("displayorderlist",foodOrder.getItems());
		double total = foodOrder.getTotal();
		modelAndView.addObject("total",total);
		modelAndView.addObject("CGST",orderService.getCgst(total));
		modelAndView.addObject("SGST",orderService.getSgst(total));
		modelAndView.addObject("totalbill",orderService.billGenerated(total));
		return modelAndView;
	}
}
