package com.codeclan.CourseBookingSystem.repositories.courseRepository;

import com.codeclan.CourseBookingSystem.models.Course;

import java.util.List;

public interface CourseRepositoryCustom {

    List<Course> findAllCoursesForCustomer(String customerName);


}
