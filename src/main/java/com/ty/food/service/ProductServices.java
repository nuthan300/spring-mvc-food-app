package com.ty.food.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dao.ProductDao;
import com.ty.food.dto.Products;

@Component
public class ProductServices {

	@Autowired
	private ProductDao dao;

	public boolean saveProduct(Products products) {

		return dao.saveProduct(products);
	}

	public boolean deleteProduct(int id) {

		return dao.deleteProduct(id);
	}

	public boolean updateProduct(Products products) {

		return dao.updateProduct(products);
	}
	
	public List<Products> getAllProducts(){
		return dao.getAllProducts();
	}
	
	public Products getProductById(int id) {
		return dao.getProductById(id);
	}
}