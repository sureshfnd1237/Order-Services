package com.order.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

public class OrderModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String orderStatus;

	private String orderType;
	
	private CustomerModel customer;

	public OrderModel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderType() {
		return this.orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public CustomerModel getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerModel customer) {
		this.customer = customer;
	}
}