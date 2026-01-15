package com.spring.StudentRegistrationApplication.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "student_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen", sequenceName = "student_seq", initialValue = 101, allocationSize = 1)
    int student_id;

    @NotBlank
    @Size(min = 3, max = 50)
    String student_name;

    @NotBlank
    @Size(min = 3, max = 50)
    String department;

    @NotBlank
    @Size(min = 7, max = 100)
    String mail_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> courses = new ArrayList<>();
}