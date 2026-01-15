package com.spring.StudentRegistrationApplication.Controller;

import com.spring.StudentRegistrationApplication.Entity.*;

import com.spring.StudentRegistrationApplication.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller
{
    @Autowired
    Service ser;

    //status code
    @PostMapping("/students")
    public ResponseEntity<Object> save(@RequestBody Student stud)
    {
        ser.saveStudent(stud);
        return  ResponseEntity.status(HttpStatus.OK).body("Saved Successfully");
    }

    @PostMapping("/courses")
    public ResponseEntity<Object> saveCourse(@RequestBody Course course)
    {
        ser.saveCourse(course);
        return ResponseEntity.status(HttpStatus.OK).body("Saved Successfully");
    }

    @PutMapping("/student/{id}/address")
    public ResponseEntity<Object> addAddress(@PathVariable int id, @RequestBody Address address)
    {
        ser.saveStudentAddress(id, address);
        return ResponseEntity.status(HttpStatus.OK).body("Address Saved Successfully");
    }

    @PutMapping("/student/{Sid}/course/{Cid}")
    public ResponseEntity<Object> addCourse(@PathVariable int Sid, @PathVariable int Cid)
    {
        ser.AddCourse(Sid,Cid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @GetMapping("/students")
    public List<Student> getStudents() {
        return ser.getStudents();
    }

    @GetMapping("/course")
    public List<Course> getCourse()
    {
        return ser.getCourse();
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable int id)
    {
        ser.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted");
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getByid(@PathVariable int id)
    {
        Student stud = ser.getByid(id) .orElseThrow(() -> new RuntimeException("Student not found"));
        return ResponseEntity.status(HttpStatus.OK).body(stud);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Object> getById(@PathVariable int id)
    {
        Course cr = ser.getById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @GetMapping("/student/{string}")
//    public List<String> getStringWithE(@PathVariable String string)
//    {
//        return ser.withLetter(string);
//    }
}