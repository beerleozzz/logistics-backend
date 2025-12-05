package com.logistics.backend;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // บอก Java ว่าคลาสนี้คือตารางใน Database
@Table(name = "employees") // ชื่อตารางต้องตรงเป๊ะ
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName; // ใน Java ใช้ camelCase แต่ DB เป็น snake_case (JPA แปลงให้เอง!)

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private BigDecimal salary; // ใช้ BigDecimal กับเรื่องเงินเสมอ (เหมือน NUMERIC ใน DB)

    @Column(name = "department_id")
    private Integer departmentId; // ตอนนี้เอา ID มาแปะก่อน (เดี๋ยวสอนทำ Join แบบ OOP ทีหลัง)

    // --- Getters & Setters ---
    // (ถ้าใช้ Lombok ใส่ @Data ข้างบน class ได้เลย แต่ถ้าไม่มีต้อง Generate เอง)
    // วิธี Generate ใน IntelliJ: คลิกขวา -> Generate -> Getter and Setter -> เลือกทั้งหมด -> OK
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public BigDecimal getSalary() { return salary; }
    public void setSalary(BigDecimal salary) { this.salary = salary; }

    // เพิ่มต่อจาก Getter/Setter ของ Salary
    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}