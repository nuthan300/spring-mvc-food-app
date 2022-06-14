package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ty.food.dto.User;

@Component
public class UserDao {

	@Autowired
	private EntityManager entityManager;

	private EntityTransaction entityTransaction;

	public boolean saveUser(User user) {
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return true;
	}

	public User getUserById(int id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	public boolean deleteUserbyId(int id) {
		User user = entityManager.find(User.class, id);
		entityTransaction.begin();
		entityManager.remove(user);
		entityTransaction.commit();
		return true;

	}

	public User validateUser(String email, String password) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=?1 AND u.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		User user = null;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException e) {
			e.printStackTrace();
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> getAllUser() {
		Query query = entityManager.createQuery("SELECT u FROM User u");
		return query.getResultList();
	}
}
