package com.gowri.tech.config;
/**
 * @author -NaveenWodeyar
 * @date -26-Oct-2024
 * @time - 12:52:53 pm
 * @location -
 */
import org.springframework.batch.item.ItemProcessor;
import com.gowri.tech.entity.Customer;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
	@Override
	public Customer process(Customer customer) throws Exception {
		// if (customer.getCountry().equals("United States"))
		return customer;
//		else
//			return null;
	}
}