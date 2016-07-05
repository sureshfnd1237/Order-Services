package com.order.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.order.DAO.OrderDAO;
import com.order.entity.Order;

@Component
public class OrderDAOImpl implements OrderDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Order> getOrders() {
		List<Order> ordersList = (List<Order>) entityManager.createNamedQuery("Order.findAll").getResultList();
		return ordersList;
	}
	
	@Transactional
	@Override
	public Order createOrder(Order order) {
		entityManager.persist(order);
		entityManager.flush();
		return order;
	}

	@Transactional
	@Override
	public Order getOrder(Integer orderId) {
		Order order = entityManager.find(Order.class, orderId);
		return order;
	}

	@Transactional
	@Override
	public Order updateOrder(Order order) {
		order = entityManager.merge(order);
		return order;
	}

	@Transactional
	@Override
	public void deleteOrder(Integer orderId) {
		Order order = entityManager.find(Order.class, orderId);
		entityManager.remove(order);
	}

}
