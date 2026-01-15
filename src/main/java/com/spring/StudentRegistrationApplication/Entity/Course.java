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


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course
{
    @Id
    @GeneratedValue(generator = "course_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen", sequenceName = "course_seq", initialValue = 301, allocationSize = 1)
    int course_id;

    @NotBlank
    @Size(min = 3, max = 50)
    String course_name;

    @NotBlank
    @Size(min = 1, max=3)
    String duration_in_weeks;

    @ManyToMany(mappedBy = "courses")
    List<Student> students = new ArrayList<>();
}
