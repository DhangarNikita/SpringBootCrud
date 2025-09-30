package com.example.SpringBootCrud.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "student_list")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int rollNo;
    String name;
    float percentage;
    String branch;
}
