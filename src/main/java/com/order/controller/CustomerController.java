package com.order.controller;

import java.util.List;

import org.apache.camel.Exchange;

import com.order.entity.Customer;
import com.order.model.CustomerModel;
import com.order.model.CustomerResponse;

public interface CustomerController {
	public List<Customer> getCustomers();

	public CustomerResponse convertCustomersListToCustomerResponse(List<Customer> customersList);

	public Customer createCustomer(CustomerModel customerModel);

	public CustomerModel convertCustomerToCustomerModel(Customer customer);

	public Customer updateCustomer(CustomerModel customerModel);

	public void deleteCustomer(Integer customerId);

	public Customer getCustomer(Integer id);

	CustomerResponse convertCustomersListToCustomerResponseUsingCamel(List<Customer> customersList);

	public Exchange processRoute1(Exchange exchange);

}
