package com.codeclan.CourseBookingSystem.repositories.courseRepository;

import com.codeclan.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
