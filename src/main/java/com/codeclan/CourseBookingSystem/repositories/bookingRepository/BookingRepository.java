package com.codeclan.CourseBookingSystem.repositories.bookingRepository;

import com.codeclan.CourseBookingSystem.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findBookingsByDate(String date);
}
