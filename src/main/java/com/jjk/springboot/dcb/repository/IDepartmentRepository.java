package com.jjk.springboot.dcb.repository;

import com.jjk.springboot.dcb.entity.Department;
import io.hypersistence.utils.spring.repository.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface IDepartmentRepository extends BaseJpaRepository<Department, BigInteger> {
    public List<Department> findByDepartmentName(String departmentName);

    @Query(value = "SELECT * FROM Department d WHERE LOWER(d.department_Code) like '%' || LOWER(?1) || '%'", nativeQuery = true)
    public List<Department> findByDepartmentCodeIgnoreCase(String departmentCode);
}
