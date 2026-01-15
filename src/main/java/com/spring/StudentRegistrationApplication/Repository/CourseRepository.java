package com.spring.StudentRegistrationApplication.Repository;

import com.spring.StudentRegistrationApplication.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
