package com.jjk.springboot.dcb.service;

import com.jjk.springboot.dcb.entity.Department;
import com.jjk.springboot.dcb.repository.IDepartmentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

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
        return departmentRepository.findById(id).orElse(Department.builder().build());
    }

    @Override
    public void deleteDepartmentById(BigInteger id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(BigInteger id, Department department) {
        Department depDB = departmentRepository.findById(id).orElse(Department.builder().build());
        return StringUtils.isNotBlank(department.getDepartmentName()) && StringUtils.isNotBlank(department.getDepartmentAddress()) && StringUtils.isNotBlank(department.getDepartmentCode())
                ? departmentRepository.save(depDB.toBuilder().withDepartmentCode(department.getDepartmentCode()).withDepartmentAddress(department.getDepartmentAddress()).withDepartmentName(department.getDepartmentName()).build()) : department;
    }

    @Override
    public List<Department> fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

}
