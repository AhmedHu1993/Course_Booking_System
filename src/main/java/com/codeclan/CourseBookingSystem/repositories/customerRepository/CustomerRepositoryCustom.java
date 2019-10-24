package com.codeclan.CourseBookingSystem.repositories.customerRepository;

import com.codeclan.CourseBookingSystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    List<Customer> findAllCustomersForCourse(String name);
    List<Customer> findAllCustomersForTownAndCourse(String  customerTown, String courseName);

}
