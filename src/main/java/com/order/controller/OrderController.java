package com.order.controller;

import java.util.List;

import com.order.entity.Order;
import com.order.model.OrderModel;
import com.order.model.OrderResponse;

public interface OrderController {

	public List<Order> getOrders();

	public Order createOrder(OrderModel orderModel);

	public OrderModel convertOrderToOrderModel(Order order);

	public Order updateOrder(OrderModel orderModel);

	public void deleteOrder(Integer orderId);

	public Order getOrder(Integer id);

	public OrderResponse convertOrdersListToOrderResponse(List<Order> ordersList);

	public Order convertOrderModelToOrder(OrderModel orderModel);

}
