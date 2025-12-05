package com.jjk.springboot.dcb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true, setterPrefix = "with")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
