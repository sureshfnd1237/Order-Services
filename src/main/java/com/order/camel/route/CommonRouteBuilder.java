package com.order.camel.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.controller.CustomerController;
import com.order.controller.impl.CustomerControllerImpl;

@Component
public class CommonRouteBuilder extends RouteBuilder{

	@Autowired
	CustomerController customerController;
	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("seda:getCustomersRoute1")
		.aggregate(constant(false),new CommonAggregationStrategy())
        .log(LoggingLevel.INFO, "Invoices processing STARTED")
		.split(body())
        .parallelProcessing()
		.bean(customerController, "processRoute1")
		.end();
	}

}
