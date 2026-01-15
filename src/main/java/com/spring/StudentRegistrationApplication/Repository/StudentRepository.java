package com.spring.StudentRegistrationApplication.Repository;

import com.spring.StudentRegistrationApplication.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>
{

}
