package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return studentService.getStudent(regNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/getByPath/{id}")
    public Student getStudentUsingPath(@PathVariable("id") int regNo){
        return studentService.getStudentUsingPath(regNo);
    }

    @PutMapping("/update-age")
    public Student updateAge(@RequestParam("id") int regNo, @RequestParam("age") int newAge){
       return studentService.updateAge(regNo,newAge);
    }

    // delete a student  --> request param

    // delete a student ---> path variable

    // change course of a student (regNo, course)  ---> Both as request params

    // change course of a student  ----> Both as path variables

    // change course --> One as request param, one as path variable

    // change course and age ---> regNo as request param, entire student object as request body
}
