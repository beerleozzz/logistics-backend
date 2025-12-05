package com.logistics.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // แค่นี้เลย! JpaRepository จะเสกคำสั่ง SELECT, INSERT, UPDATE, DELETE ให้เราเองหมด
}