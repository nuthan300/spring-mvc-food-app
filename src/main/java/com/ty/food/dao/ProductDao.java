package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Products;

@Component
public class ProductDao {

	@Autowired
	private EntityManager entityManager;

	private EntityTransaction entityTransaction;


	public boolean saveProduct(Products products) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(products);
		entityTransaction.commit();
		return true;
	}

	public boolean deleteProduct(int id) {
		Products products = entityManager.find(Products.class, id);
		if (products == null) {
			return false;
		}
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(products);
		entityTransaction.commit();
		return true;
	}

	public boolean updateProduct(Products products) {
		if (entityManager.find(Products.class, products.getId()) == null) {
			return false;
		}
		entityTransaction.begin();
		entityManager.merge(products);
		entityTransaction.commit();
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Products> getAllProducts(){
		Query query = entityManager.createQuery("SELECT p FROM Products p");
		return query.getResultList();
	}
	
	public Products getProductById(int id) {
		return entityManager.find(Products.class, id);
	}
}
