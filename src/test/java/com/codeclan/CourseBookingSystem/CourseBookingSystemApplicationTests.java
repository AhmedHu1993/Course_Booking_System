package com.codeclan.CourseBookingSystem;

import com.codeclan.CourseBookingSystem.models.Booking;
import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.bookingRepository.BookingRepository;
import com.codeclan.CourseBookingSystem.repositories.courseRepository.CourseRepository;
import com.codeclan.CourseBookingSystem.repositories.customerRepository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCoursesByStarRating(){
		List<Course> foundCourses = courseRepository.findCoursesByStarRating(4);
		assertEquals(4 , foundCourses.get(0).getStarRating());
	}

	@Test
	public void canFindBookingsByDate() {
		List<Booking> foundBookings = bookingRepository.findBookingsByDate("15-01-20");
		assertEquals("15-01-20", foundBookings.get(0).getDate());
	}

	@Test
	public void canFindCustomersForCourse() {
		List<Customer> foundCustomers = customerRepository.findAllCustomersForCourse("Vue");
		assertEquals(3, foundCustomers.size());
	}

	@Test
	public void canFindCoursesForCustomer() {
		List<Course> foundCourses = courseRepository.findAllCoursesForCustomer("Alex");
		assertEquals("Vue", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomersWithTownAndCourse(){
		List<Customer> foundCustomers = customerRepository.findAllCustomersForTownAndCourse("Edinburgh", "Vue");
		assertEquals("Joe", foundCustomers.get(0).getName());
	}

	@Test
	public void findAllCustomersForTownAndCourseGreaterThanAge(){
		List<Customer> foundCustomers = customerRepository.findAllCustomersForTownAndCourseGreaterThanAge("Edinburgh", "Vue", 28);
		assertEquals("Alex", foundCustomers.get(0).getName());
	}
}
