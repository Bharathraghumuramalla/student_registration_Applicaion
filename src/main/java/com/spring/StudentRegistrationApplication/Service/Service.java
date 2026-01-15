package com.spring.StudentRegistrationApplication.Service;

import com.spring.StudentRegistrationApplication.Entity.Address;
import com.spring.StudentRegistrationApplication.Entity.Course;
import com.spring.StudentRegistrationApplication.Entity.Student;
import com.spring.StudentRegistrationApplication.Repository.CourseRepository;
import com.spring.StudentRegistrationApplication.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service
{
    @Autowired
    StudentRepository srepo;

    @Autowired
    CourseRepository crepo;

    public void saveStudent(Student stud)
    {
        srepo.save(stud);
    }

    public void saveCourse(Course course)
    {
        crepo.save(course);
    }

    public void saveStudentAddress(int id, Address address)
    {
        Student stud = srepo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        stud.setAddress(address);
        srepo.save(stud);
    }


    public void AddCourse(int Sid, int Cid)
    {
        Student stud = srepo.findById(Sid).orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = crepo.findById(Cid).orElseThrow(() -> new RuntimeException("Course not found"));

        //stud.getCoures().add(course);
        List<Course> list = stud.getCourses();
        list.add(course);
        srepo.save(stud);
    }

    public List<Student> getStudents()
    {
        return srepo.findAll();
    }

    public List<Course> getCourse()
    {
        return crepo.findAll();
    }


    public void deleteStudent(int id)
    {
        srepo.deleteById(id);
    }

    public Optional<Student> getByid(int id)
    {
        return srepo.findById(id);
    }

    public Optional<Course> getById(int id)
    {
        return crepo.findById(id);
    }

//    public List<String> withLetter(String string)
//    {
//        String n = string.toLowerCase();
//        List<Student> students = srepo.findAll();
//        List<String> ans = new ArrayList<>();
//        for(Student s : students)
//        {
//            String name = s.getName().toLowerCase();
//
//            if(name.contains(n))
//            {
//                ans.add(name);
//            }
//        }
//        return ans;
//    }
}
