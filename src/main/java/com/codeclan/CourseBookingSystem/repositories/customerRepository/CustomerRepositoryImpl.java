package com.codeclan.CourseBookingSystem.repositories.customerRepository;

import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.courseRepository.CourseRepository;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Autowired
    CourseRepository courseRepository;

    @Transactional
    public List<Customer> findAllCustomersForCourse(String name) {
        List<Customer> result = null;
        Course course = courseRepository.findCourseByName(name);

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.createAlias("bookings", "bookingAlias");
            criteria.add(Restrictions.eq("bookingAlias.course", course));

            result = criteria.list();
        } catch(HibernateException exception) {
            exception.printStackTrace();
        }
        return result;
    }

    @Transactional
    public List<Customer> findAllCustomersForTownAndCourse(String customerTown, String courseName) {
        List<Customer> result = null;
        Course course = courseRepository.findCourseByName(courseName);

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Customer.class);
            criteria.add(Restrictions.eq("town", customerTown));
            criteria.createAlias("bookings", "bookingAlias");
            criteria.add(Restrictions.eq("bookingAlias.course", course));

            result = criteria.list();
        } catch (HibernateException exception){
            exception.printStackTrace();
        }

        return result;
    }


}
