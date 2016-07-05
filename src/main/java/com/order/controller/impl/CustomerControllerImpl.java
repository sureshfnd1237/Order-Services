package com.order.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.DAO.CustomerDAO;
import com.order.controller.CustomerController;
import com.order.entity.Customer;
import com.order.model.CustomerModel;
import com.order.model.CustomerResponse;

@Component
public class CustomerControllerImpl implements CustomerController {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers() {

		List<Customer> customerList = customerDAO.getCustomers();
		return customerList;
	}

	@Override
	public Customer getCustomer(Integer id) {

		Customer customer = customerDAO.getCustomer(id);
		return customer;
	}

	@Override
	public Customer createCustomer(CustomerModel customerModel) {

		Customer customer = new Customer();
		customer.setCustomerFirstName(customerModel.getCustomerFirstName());
		customer.setCustomerLastName(customerModel.getCustomerLastName());
		customer.setCustomerAddress(customerModel.getCustomerAddress());
		customer.setCustomerMobile(customerModel.getCustomerMobile());
		customer.setCustomerEmail(customerModel.getCustomerEmail());
		customer.setCustomerPostcode(customerModel.getCustomerPostcode());
		customer.setCustomerPhone(customerModel.getCustomerPostcode());
		customer.setCustomerCountry(customerModel.getCustomerCountry());
		customer.setCustomerState(customerModel.getCustomerState());

		customer = customerDAO.createCustomer(customer);
		return customer;
	}

	/**
	 * This Method is to fill the OrderResponse Object with the Order entity
	 * Details.
	 * 
	 * @param ordersList
	 * @return OrderResponse
	 */
	@Override
	public CustomerResponse convertCustomersListToCustomerResponse(List<Customer> customersList) {

		CustomerResponse customerResponse = new CustomerResponse();

		List<CustomerModel> customerModelList = new ArrayList<>();
		for (Customer customer : customersList) {
			CustomerModel CustomerModel = convertCustomerToCustomerModel(customer);
			customerModelList.add(CustomerModel);
		}
		customerResponse.setCustomerList(customerModelList);
		return customerResponse;

	}

	@Override
	public CustomerModel convertCustomerToCustomerModel(Customer customer) {
		CustomerModel CustomerModel = new CustomerModel();
		CustomerModel.setId(customer.getId());
		CustomerModel.setCustomerFirstName(customer.getCustomerFirstName());
		CustomerModel.setCustomerLastName(customer.getCustomerLastName());
		CustomerModel.setCustomerAddress(customer.getCustomerAddress());
		CustomerModel.setCustomerEmail(customer.getCustomerEmail());
		CustomerModel.setCustomerMobile(customer.getCustomerMobile());
		CustomerModel.setCustomerCountry(customer.getCustomerCountry());
		CustomerModel.setCustomerState(customer.getCustomerState());
		CustomerModel.setCustomerPostcode(customer.getCustomerPostcode());
		return CustomerModel;

	}

	@Override
	public Customer updateCustomer(CustomerModel customerModel) {

		Customer customer = customerDAO.getCustomer(customerModel.getId());

		customer.setCustomerFirstName(customerModel.getCustomerFirstName());
		customer.setCustomerLastName(customerModel.getCustomerLastName());
		customer.setCustomerAddress(customerModel.getCustomerAddress());
		customer.setCustomerMobile(customerModel.getCustomerMobile());
		customer.setCustomerEmail(customerModel.getCustomerEmail());
		customer.setCustomerPostcode(customerModel.getCustomerPostcode());
		customer.setCustomerPhone(customerModel.getCustomerPostcode());
		customer.setCustomerCountry(customerModel.getCustomerCountry());
		customer.setCustomerState(customerModel.getCustomerState());

		customer = customerDAO.updateCustomer(customer);
		return customer;
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerDAO.deleteCustomer(id);
	}

}
