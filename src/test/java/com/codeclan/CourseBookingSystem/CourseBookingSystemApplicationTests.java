package com.codeclan.CourseBookingSystem;

import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.repositories.courseRepository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canFindCoursesByStarRating(){
		List<Course> foundCourses = courseRepository.findCoursesByStarRating(4);
		assertEquals(4 , foundCourses.get(0).getStarRating());
	}
}
