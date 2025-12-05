package com.jjk.springboot.dcb.service;

import com.jjk.springboot.dcb.entity.Department;
import com.jjk.springboot.dcb.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class DepartmentServiceImpl implements  IDepartmentService{

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(BigInteger id) {
        return  departmentRepository.findById(id).orElse(Department.builder().build());
    }

}
