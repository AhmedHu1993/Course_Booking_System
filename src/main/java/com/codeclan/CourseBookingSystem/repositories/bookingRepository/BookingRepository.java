package com.codeclan.CourseBookingSystem.repositories.bookingRepository;

import com.codeclan.CourseBookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
