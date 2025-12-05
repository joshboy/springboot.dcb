package com.jjk.springboot.dcb.repository;

import com.jjk.springboot.dcb.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface IDepartmentRepository extends JpaRepository<Department, BigInteger>{
    public List<Department> findByDepartmentName(String departmentName);
}
