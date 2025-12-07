package com.jjk.springboot.dcb.service;

import com.jjk.springboot.dcb.entity.Department;
import com.jjk.springboot.dcb.error.DepartmentNotFound;
import com.jjk.springboot.dcb.repository.IDepartmentRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.persist(department);
    }

    @Override
    public List<Department> fetchDepartmentList(Example<Department> example) {
        return  StreamSupport.stream(departmentRepository.findAll(example).spliterator(), false)
                .toList();
    }

    @Override
    public Department fetchDepartmentById(BigInteger id) {
        // Return the department if present, otherwise throw DepartmentNotFound
        return departmentRepository.findById(id)
                .orElseThrow(DepartmentNotFound::new);

    }

    @Override
    public void deleteDepartmentById(BigInteger id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(BigInteger id, Department department) {
        Department depDB = departmentRepository.findById(id).orElse(Department.builder().build());
        return   departmentRepository.merge(depDB.toBuilder()
                .withDepartmentId(id)
                .withDepartmentCode(StringUtils.isNotBlank(department.getDepartmentCode()) ? department.getDepartmentCode() :depDB.getDepartmentCode())
                .withDepartmentAddress(StringUtils.isNotBlank(department.getDepartmentAddress()) ? department.getDepartmentAddress() :depDB.getDepartmentAddress())
                .withDepartmentName(StringUtils.isNotBlank(department.getDepartmentName()) ? department.getDepartmentName() :depDB.getDepartmentName()).build());
    }

    @Override
    public List<Department> fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public List<Department> fetchDepartmentByCode(String code) {
        return departmentRepository.findByDepartmentCodeIgnoreCase(code);
    }

}
