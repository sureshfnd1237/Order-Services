package com.order.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.DAO.CustomerDAO;
import com.order.DAO.OrderDAO;
import com.order.controller.OrderController;
import com.order.entity.Customer;
import com.order.entity.Order;
import com.order.model.CustomerModel;
import com.order.model.OrderModel;
import com.order.model.OrderResponse;

@Component
public class OrderControllerImpl implements OrderController {

	@Autowired
	private OrderDAO orderDAO;
	
	@Autowired
	private CustomerDAO customerDAO;
	

	@Override
	public List<Order> getOrders() {
		List<Order> ordersList = orderDAO.getOrders();
		return ordersList;
	}
	
	@Override
	public Order getOrder(Integer id) {

		Order order = orderDAO.getOrder(id);
		return order;
	}

	@Override
	public Order createOrder(OrderModel orderModel) {
     Order order = convertOrderModelToOrder(orderModel);
		order = orderDAO.createOrder(order);
		return order;
	}

	

	@Override
	public Order updateOrder(OrderModel orderModel) {

		Order order = orderDAO.getOrder(orderModel.getId());
		order.setOrderStatus(orderModel.getOrderStatus());
		order.setOrderType(orderModel.getOrderType());		

		order = orderDAO.updateOrder(order);
		return order;
	}

	@Override
	public void deleteOrder(Integer id) {
		orderDAO.deleteOrder(id);
	}

	/**
	 * This Method is to fill the OrderResponse Object with the Order entity
	 * Details.
	 * 
	 * @param ordersList
	 * @return OrderResponse
	 */
	@Override
	public OrderResponse convertOrdersListToOrderResponse(List<Order> ordersList) {

		OrderResponse orderResponse = new OrderResponse();

		List<OrderModel> orderModelList = new ArrayList<>();
		for (Order order : ordersList) {
		OrderModel orderModel =	convertOrderToOrderModel(order);
			orderModelList.add(orderModel);
		}
		orderResponse.setOrderList(orderModelList);
		return orderResponse;

	}
	@Override
	public OrderModel convertOrderToOrderModel(Order order){
		OrderModel orderModel = new OrderModel();
		orderModel.setId(order.getId());
		orderModel.setOrderStatus(order.getOrderStatus());
		orderModel.setOrderType(order.getOrderType());
		Customer customer = order.getCustomer();

		CustomerModel customerModel = new CustomerModel();
		customerModel.setId(customer.getId());
		customerModel.setCustomerFirstName(customer.getCustomerFirstName());
		customerModel.setCustomerLastName(customer.getCustomerLastName());
		customerModel.setCustomerAddress(customer.getCustomerAddress());
		customerModel.setCustomerEmail(customer.getCustomerEmail());
		customerModel.setCustomerMobile(customer.getCustomerMobile());
		customerModel.setCustomerCountry(customer.getCustomerCountry());
		customerModel.setCustomerState(customer.getCustomerState());
		customerModel.setCustomerPostcode(customer.getCustomerPostcode());

		orderModel.setCustomer(customerModel);
		return orderModel;
	}

	@Override
	public Order convertOrderModelToOrder(OrderModel orderModel){
		Order order = new Order();
		order.setOrderStatus(orderModel.getOrderStatus());
		order.setOrderType(orderModel.getOrderType());
		Customer customer = customerDAO.getCustomer(orderModel.getCustomer().getId());
		order.setCustomer(customer);
		return order;
	}

}
