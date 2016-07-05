package com.order.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.controller.OrderController;
import com.order.entity.Order;
import com.order.model.OrderModel;
import com.order.model.OrderResponse;

@Component
@Path("/orders")
public class OrderService {

	@Autowired
	private OrderController orderController;

	/**
	 * This Service is to get the list of All Orders.
	 * 
	 * @return Response
	 */
	@GET
	@Path("/getOrders")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrders() {

		List<Order> ordersList = orderController.getOrders();
		OrderResponse orderResponse = orderController.convertOrdersListToOrderResponse(ordersList);

		return Response.status(200).entity(orderResponse).build();
	}

	@GET
	@Path("/getOrders/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrder(@PathParam("id") Integer id) {
		Order order = orderController.getOrder(id);
		OrderModel orderModel = orderController.convertOrderToOrderModel(order);
		return Response.status(200).entity(orderModel).build();

	}

	@POST
	@Path("/createOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createOrder(OrderModel orderModel) {

		Order order = orderController.createOrder(orderModel);
		OrderModel OrderModel = orderController.convertOrderToOrderModel(order);
		return Response.status(201).entity(OrderModel).build();
	}

	@PUT
	@Path("/updateOrder")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrder(OrderModel orderModel) {

		Order order = orderController.updateOrder(orderModel);
		OrderModel OrderModel = orderController.convertOrderToOrderModel(order);
		return Response.status(202).entity(OrderModel).build();
	}

	@DELETE
	@Path("/deleteOrder/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteOrder(@PathParam("id") Integer orderId) {

		orderController.deleteOrder(orderId);
		return Response.status(204).entity("Order with Id:" + orderId + "Deleted successfully.").build();
	}

}
