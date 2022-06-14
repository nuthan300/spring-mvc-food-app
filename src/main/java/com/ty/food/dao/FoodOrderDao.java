package com.ty.food.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

@Component
public class FoodOrderDao {

	@Autowired
	private EntityManager entityManager;

	private EntityTransaction entityTransaction;

	public boolean saveFoodOrder(FoodOrder foodOrder) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		int total = 0;
		for (Item item1 : foodOrder.getItems()) {
			item1.setFoodOrder(foodOrder);
			total += item1.getCost();
		}
		foodOrder.setTotal(total);
		entityManager.persist(foodOrder);
		entityTransaction.commit();

		return true;
	}

	public FoodOrder getFoodOrderById(int id) {
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		return foodOrder;
	}

	public boolean deleteFoodOrderById(int id) {
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		System.out.println(foodOrder);
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(foodOrder);
		entityTransaction.commit();
		return true;
	}

	public boolean updateFoodOrder(int id, Item item) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		foodOrder.getItems().add(item);
		int total = 0;
		for (Item item1 : foodOrder.getItems()) {
			item1.setFoodOrder(foodOrder);
			total += item1.getCost();
		}
		foodOrder.setTotal(total);
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return true;
	}

	public FoodOrder getFoodOrderByPhone(long phone) {
		String sql = "SELECT f FROM FoodOrder f WHERE phone=?1";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, phone);
		return (FoodOrder)query.getSingleResult();
	}

	public FoodOrder getFoodOrdersByName(String name) {
		Query query = entityManager.createQuery("SELECT f FROM FoodOrder f WHERE f.name=?1");
		query.setParameter(1, name);
		return (FoodOrder)query.getSingleResult();
	}

}
