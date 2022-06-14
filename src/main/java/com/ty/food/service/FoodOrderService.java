package com.ty.food.service;

import static com.ty.food.util.Tax.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

@Component
public class FoodOrderService {

	@Autowired
	FoodOrderDao dao;

	public boolean saveFoodOrder(FoodOrder foodOrder) {
		return dao.saveFoodOrder(foodOrder);
	}

	public FoodOrder getFoodOrderById(int id) {
		return dao.getFoodOrderById(id);
	}

	public boolean deleteFoodOrderById(int id) {
		return dao.deleteFoodOrderById(id);
	}

	public boolean updateFoodOrder(int id, Item item) {
		return dao.updateFoodOrder(id, item);
	}

	public FoodOrder getFoodOrderByPhone(long phone) {
		return dao.getFoodOrderByPhone(phone);
	}

	public FoodOrder getFoodOrdersByName(String name) {

		return dao.getFoodOrdersByName(name);
	}

	public double billGenerated(double amount) {
		double gst = amount + getCgst(amount) + getSgst(amount);
		return gst;
	}

	public double getCgst(double amount) {
		return amount *(CGST/100);
	}

	public double getSgst(double amount) {
		return amount * (SGST/100);
	}
}
