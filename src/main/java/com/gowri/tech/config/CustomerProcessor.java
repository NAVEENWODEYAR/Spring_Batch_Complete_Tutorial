package com.gowri.tech.config;

import org.springframework.batch.item.ItemProcessor;
import com.gowri.tech.entity.Customer;
/**
 * @author -NaveenWodeyar
 * @date -26-Oct-2024
 * @time - 12:52:53 pm
 * @location -
 */

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
	@Override
	public Customer process(Customer customer) throws Exception {
		return customer;
	}
}