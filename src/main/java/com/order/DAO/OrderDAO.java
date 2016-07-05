package com.order.DAO;

import java.util.List;

import com.order.entity.Order;

public interface OrderDAO {

	public List<Order> getOrders();

	public Order createOrder(Order order);

	public Order getOrder(Integer orderId);

	public Order updateOrder(Order order);

	public void deleteOrder(Integer orderId);

}
