package com.example.SpringBootCrud.repository;

import com.example.SpringBootCrud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
