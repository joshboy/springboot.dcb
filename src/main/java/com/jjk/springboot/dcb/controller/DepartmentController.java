package com.jjk.springboot.dcb.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjk.springboot.dcb.entity.Department;
import com.jjk.springboot.dcb.service.IDepartmentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments() {
        return  departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") BigInteger id) {
        return departmentService.fetchDepartmentById(id);
    }


    @PostConstruct
    public void init() {
        try {
//            List<Department> department = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Department>>(){});

            //ClassPathResource cpr = new FileInputStream("src/main/resources/department.json");


            List<Department> department = new ObjectMapper().readValue(new ClassPathResource("department.json").getInputStream(), new TypeReference<List<Department>>() {
            });
            department.stream().forEach(departmentService::saveDepartment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
