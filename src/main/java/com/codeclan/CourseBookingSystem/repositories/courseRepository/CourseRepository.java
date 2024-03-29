package com.codeclan.CourseBookingSystem.repositories.courseRepository;

import com.codeclan.CourseBookingSystem.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>, CourseRepositoryCustom {

    List<Course> findCoursesByStarRating(int starRating);
    Course findCourseByNameIgnoreCase(String name);
}
