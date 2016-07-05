package com.order.DAO;

import java.util.List;

import com.order.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public Customer createCustomer(Customer customer);

	public Customer getCustomer(Integer customerId);

	public Customer updateCustomer(Customer customer);

	public void deleteCustomer(Integer customerId);
}
