package com.spring.StudentRegistrationApplication.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address
{
    @Id
    @GeneratedValue(generator = "address_gen", strategy = GenerationType.SEQUENCE )
    @SequenceGenerator(name = "address_gen", sequenceName = "address_seq", initialValue = 201, allocationSize = 1)
    int address_id;

    @NotBlank
    @Size(min = 3, max = 50)
    String city;

    @NotBlank
    @Size(min = 3, max = 70)
    String street;

    @OneToOne(mappedBy = "address")
    private Student student;
}
