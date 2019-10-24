package com.codeclan.CourseBookingSystem.repositories.customerRepository;

import com.codeclan.CourseBookingSystem.models.Customer;

import java.util.List;

public interface CustomerRepositoryCustom {

    public List<Customer> findAllCustomersForCourse(String name);

}
