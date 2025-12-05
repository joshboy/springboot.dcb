package com.jjk.springboot.dcb.service;

import com.jjk.springboot.dcb.entity.Department;

import java.math.BigInteger;
import java.util.List;

public interface IDepartmentService {
    Department saveDepartment(Department department);
    List<Department> fetchDepartmentList();
    Department fetchDepartmentById(BigInteger id);
}
