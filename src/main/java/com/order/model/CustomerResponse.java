package com.order.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<CustomerModel> customerList;

	public List<CustomerModel> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<CustomerModel> customerList) {
		this.customerList = customerList;
	}
}