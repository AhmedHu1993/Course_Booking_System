package com.codeclan.CourseBookingSystem.repositories.courseRepository;

import com.codeclan.CourseBookingSystem.models.Course;
import com.codeclan.CourseBookingSystem.models.Customer;
import com.codeclan.CourseBookingSystem.repositories.customerRepository.CustomerRepository;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Autowired
    CustomerRepository customerRepository;

    @Transactional
    public List<Course> findAllCoursesForCustomer(String customerName) {
        List<Course> result = null;

        Customer customer = customerRepository.findCustomerByNameIgnoreCase(customerName);

        Session session = entityManager.unwrap(Session.class);

        try {
            Criteria criteria = session.createCriteria(Course.class);
            criteria.createAlias("bookings", "bookingAlias");
            criteria.add(Restrictions.eq("bookingAlias.customer", customer));

            result = criteria.list();
        } catch(HibernateException exception) {
            exception.printStackTrace();
        }

        return result;
    }

}
