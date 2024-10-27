package com.gowri.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gowri.tech.entity.Customer;

/**
 * @author -NaveenWodeyar
 * @date -26-Oct-2024
 * @time - 12:47:52 pm
 * @location -
 */

public interface Customerrepository extends JpaRepository<Customer, Integer> {

}
