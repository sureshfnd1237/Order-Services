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

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.controller.CustomerController;
import com.order.entity.Customer;
import com.order.model.CustomerModel;
import com.order.model.CustomerResponse;

@Component
@Path("/customers")
public class CustomerService {

	public static final Logger logger =Logger.getLogger(CustomerService.class);
	@Autowired
	private CustomerController customerController;

	@GET
	@Path("/getCustomers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomers() {
		logger.debug("Entered "+ CustomerService.class);
		List<Customer> customersList = customerController.getCustomers();
		CustomerResponse customerResponse = customerController.convertCustomersListToCustomerResponseUsingCamel(customersList);
//		CustomerResponse customerResponse = customerController.convertCustomersListToCustomerResponse(customersList);
		return Response.status(200).entity(customerResponse).build();

	}

	@GET
	@Path("/getCustomers/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomer(@PathParam("id") Integer id) {
		Customer customer = customerController.getCustomer(id);
		CustomerModel customerModel = customerController.convertCustomerToCustomerModel(customer);
		return Response.status(200).entity(customerModel).build();

	}

	@POST
	@Path("/createCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createCustomer(CustomerModel customerModel) {

		Customer customer = customerController.createCustomer(customerModel);
		CustomerModel CustomerModel = customerController.convertCustomerToCustomerModel(customer);
		return Response.status(201).entity(CustomerModel).build();
	}

	@PUT
	@Path("/updateCustomer")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(CustomerModel customerModel) {

		Customer customer = customerController.updateCustomer(customerModel);
		CustomerModel CustomerModel = customerController.convertCustomerToCustomerModel(customer);
		return Response.status(202).entity(CustomerModel).build();
	}

	@DELETE
	@Path("/deleteCustomer/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteCustomer(@PathParam("id") Integer customerId) {

		customerController.deleteCustomer(customerId);
		return Response.status(204).entity("Customer with Id:" + customerId + "Deleted successfully.").build();
	}
}
