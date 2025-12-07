package com.jjk.springboot.dcb.service;

import com.jjk.springboot.dcb.entity.Department;
import org.springframework.data.domain.Example;

import java.math.BigInteger;
import java.util.List;

public interface IDepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList(Example<Department> example);
    Department fetchDepartmentById(BigInteger id);

    void deleteDepartmentById(BigInteger id);

    Department updateDepartment(BigInteger id, Department department);

    List<Department> fetchDepartmentByName(String name);

    List<Department> fetchDepartmentByCode(String code);
}
