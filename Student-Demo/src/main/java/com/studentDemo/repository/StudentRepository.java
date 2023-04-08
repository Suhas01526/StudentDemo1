package com.studentDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentDemo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
