package com.jjk.springboot.dcb.controller;

import com.jjk.springboot.dcb.entity.Department;
import com.jjk.springboot.dcb.service.IDepartmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {

        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartments() {
        log.info("fetchDepartments {}");
        return  departmentService.fetchDepartmentList(Example.of(Department.builder().build()));
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") BigInteger id) {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") BigInteger id) {
        departmentService.deleteDepartmentById(id);
        return "Department deleted successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") BigInteger id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }


    @GetMapping("departments/name/{name}")
    public List<Department> fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }

    @GetMapping("departments/code/{code}")
    public List<Department> fetchDepartmentByCode(@PathVariable("code") String code) {
        return departmentService.fetchDepartmentByCode(code);
    }

/*
    @PostConstruct
    public void init() {
        try {
//            List<Department> department = objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Department>>(){});

            //ClassPathResource cpr = new FileInputStream("src/main/resources/department.json");


            List<Department> department = new ObjectMapper().readValue(new ClassPathResource("department.json").getInputStream(), new TypeReference<List<Department>>() {
            });
            department.forEach(departmentService::saveDepartment);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
