package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.Item;

@Component
public class ItemDao {

	@Autowired
	private EntityManager entityManager;

	private EntityTransaction entityTransaction;

	
	public boolean saveItem(Item item) {
	
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(item);
		entityTransaction.commit();
		return true;
	}

	public Item getItemById(int id) {
		
		return entityManager.find(Item.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Item> getAllItem() {
		
		Query query = entityManager.createQuery("Select i from Item i");
		return query.getResultList();
	}

	public boolean updateItem(Item item) {

		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
		return true;
	}

	public boolean deleteItem(int id) {

		Item item = entityManager.find(Item.class, 1);
		if (item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
