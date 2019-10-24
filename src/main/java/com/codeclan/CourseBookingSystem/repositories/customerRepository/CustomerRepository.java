package com.codeclan.CourseBookingSystem.repositories.customerRepository;

import com.codeclan.CourseBookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {
    Customer findCustomerByNameIgnoreCase(String name);
}
