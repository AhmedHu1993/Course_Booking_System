package com.codeclan.CourseBookingSystem.controllers;


import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.customerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/courses")
    public List<Customer> findAllCustomersForCourse(@RequestParam String name) {
        return customerRepository.findAllCustomersForCourse(name);
    }

    @GetMapping(value = "/town-course")
    public List<Customer> findAllCustomersForTownAndCourse(@RequestParam String town, String course){
        return customerRepository.findAllCustomersForTownAndCourse(town, course);
    }

    @GetMapping(value = "/town-course-overage")
    public List<Customer> findAllCustomersForTownAndCourseGreaterThanAge(@RequestParam String town, String course, int age){
        return customerRepository.findAllCustomersForTownAndCourseGreaterThanAge(town, course, age);
    }

}
