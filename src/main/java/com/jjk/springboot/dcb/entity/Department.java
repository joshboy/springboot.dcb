package com.jjk.springboot.dcb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.math.BigInteger;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_seq")
    @SequenceGenerator(name = "department_seq", sequenceName = "department_seq", allocationSize = 1)

    private BigInteger departmentId;

    @NotBlank(message = "Please enter department name")
    @Length(max = 15, min =2, message = "Department name should be between 2 to 6 characters")
/*    @Email
    @Positive
    @Negative
    @PositiveOrZero*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
