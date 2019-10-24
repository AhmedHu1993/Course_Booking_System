package com.codeclan.CourseBookingSystem.components;

import com.codeclan.CourseBookingSystem.models.Booking;
import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.bookingRepository.BookingRepository;
import com.codeclan.CourseBookingSystem.repositories.courseRepository.CourseRepository;
import com.codeclan.CourseBookingSystem.repositories.customerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        Customer customer1 = new Customer("Joe", "Edinburgh", 26);
        Customer customer2 = new Customer("Ahmed", "Glasgow", 26);
        Customer customer3 = new Customer("Alex", "Edinburgh", 30);
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        Course course1 = new Course("Intro to Spring", "Edinburgh", 4);
        Course course2 = new Course("Vue", "Glasgow", 5);
        courseRepository.save(course1);
        courseRepository.save(course2);

        Booking booking1 = new Booking("20-11-19", course1,customer1);
        Booking booking2 = new Booking("30-10-19", course1,customer2);
        Booking booking3 = new Booking("05-01-20",course2, customer1);
        Booking booking4 = new Booking("15-01-20",course2, customer2);
        Booking booking5 = new Booking("30-01-20", course2, customer3);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);
        bookingRepository.save(booking5);


    }

}
