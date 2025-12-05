package com.logistics.backend;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees") // บอกว่าถ้าใครเข้าเว็บ /employees ให้มาที่นี่
@CrossOrigin(origins = "*")
public class EmployeeController {

    private final EmployeeRepository repository;

    // Inject Repository เข้ามาใช้งาน
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    // 1. ดึงพนักงานทั้งหมด
    @GetMapping
    public List<Employee> getAllEmployees() {
        return repository.findAll(); // สั่งให้ไป SELECT * FROM employees มาเดี๋ยวนี้!        
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return repository.save(employee); // save() คือคำสั่ง Insert ของ JPA ครับ ง่ายไหมล่ะ!
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id); // สั่ง Database ลบแถวที่มี ID นี้ทิ้งทันที
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee emp = repository.findById(id).orElseThrow(); // หาคนเก่าก่อน
        
        // อัปเดตข้อมูลใหม่ทับลงไป
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmail(employeeDetails.getEmail());
        emp.setSalary(employeeDetails.getSalary());
        emp.setDepartmentId(employeeDetails.getDepartmentId());
        
        return repository.save(emp); // บันทึกกลับลง DB
    }
}