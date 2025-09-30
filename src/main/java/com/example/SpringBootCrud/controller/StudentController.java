package com.example.SpringBootCrud.controller;

import com.example.SpringBootCrud.entity.Student;
import com.example.SpringBootCrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path = "/student", produces = {"application/xml","application/json"})
    public List<Student> getAllStudent (){
        List <Student> st = studentRepository.findAll();
        return st;
    }

    @GetMapping("/student/{id}")
    @ResponseStatus(code = HttpStatus.FOUND)
    public Student getStudent(@PathVariable int id){
        Student student = studentRepository.findById(id).get();
        return student;
    }

    @PostMapping(path = "/add",produces = {"application/xml","application/json"},consumes = {"application/xml","application/json"})
    @ResponseStatus(code = HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student s){
        Student st = studentRepository.save(s);
        return st;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id){
        Student s = studentRepository.findById(id).get();
        studentRepository.delete(s);
    }

    @PutMapping(path = "/update/{id}",produces = {"application/xml","application/json"},consumes = {"application/xml","application/json"})
    public Student updateStudent(@PathVariable int id, @RequestBody Student s ){
        Student st = studentRepository.findById(id).get();
        st.setName(s.getName());
        st.setBranch(s.getBranch());
        st.setPercentage(s.getPercentage());
        return studentRepository.save(st);
    }

}
