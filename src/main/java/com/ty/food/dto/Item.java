package com.ty.food.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name, remarks;
	private int quantity;
	private double cost;
	private double mrp;

	@ManyToOne
	@JoinColumn(name = "my_FoodOrder_Id")
	FoodOrder foodOrder;

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.mrp = cost;
	}

	public FoodOrder getFoodOrder() {
		return foodOrder;
	}

	public void setFoodOrder(FoodOrder foodOrder) {
		this.foodOrder = foodOrder;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.cost = quantity * mrp;
	}

	
	public static int i;  // In order to Print Items In Serial Order from Menu

	@Override
	public String toString() {
		System.out.println(i++ + "\t" + name + "\t   " + quantity + "       " + mrp + "\t" + cost);
		return "";
	}

}
