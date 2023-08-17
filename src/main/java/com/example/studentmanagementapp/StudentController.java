package com.example.studentmanagementapp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    Map<Integer,Student> db = new HashMap<>();

    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return db.get(regNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        db.put(student.getRegNo(),student);
        return "Student has been added successfully";
    }

    @GetMapping("/getByPath/{id}")
    public Student getStudentUsingPath(@PathVariable("id") int regNo){
        return db.get(regNo);
    }

    @PutMapping("/update-age")
    public Student updateAge(@RequestParam("id") int regNo, @RequestParam("age") int newAge){
        db.get(regNo).setAge(newAge);
        return db.get(regNo);
    }

    // delete a student  --> request param

    // delete a student ---> path variable

    // change course of a student (regNo, course)  ---> Both as request params

    // change course of a student  ----> Both as path variables

    // change course --> One as request param, one as path variable

    // change course and age ---> regNo as request param, entire student object as request body
}
