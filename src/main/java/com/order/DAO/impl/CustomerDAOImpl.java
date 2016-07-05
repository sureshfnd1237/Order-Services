package com.order.DAO.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.order.DAO.CustomerDAO;
import com.order.entity.Customer;

@Component
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> getCustomers() {
		List<Customer> customerList = (List<Customer>) entityManager.createNamedQuery("Customer.findAll")
				.getResultList();
		return customerList;
	}

	@Transactional
	@Override
	public Customer createCustomer(Customer customer) {
		entityManager.persist(customer);
		entityManager.flush();
		return customer;
	}

	@Transactional
	@Override
	public Customer getCustomer(Integer customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		// entityManager.flush();
		return customer;
	}

	@Transactional
	@Override
	public Customer updateCustomer(Customer customer) {
		customer = entityManager.merge(customer);
		entityManager.flush();
		return customer;
	}

	@Transactional
	@Override
	public void deleteCustomer(Integer customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		entityManager.remove(customer);
		entityManager.flush();
	}
}
