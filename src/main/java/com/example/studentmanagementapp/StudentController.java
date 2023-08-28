package com.example.studentmanagementapp;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;

@RestController
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentRepository studentRepository;

//    public Logger log = Logger.getLogger(String.valueOf(StudentController.class));

    @GetMapping("/get")
    public Student getStudent(@RequestParam("q") int regNo){
        return studentService.getStudent(regNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        log.trace("This is a TRACE log");
        log.debug("This is a DEBUG log");
        log.info("This is a INFO log");
        log.warn("This is a WARN log");
        log.error("This is a ERROR log");
        return studentService.addStudent(student);
    }

    @GetMapping("/getByPath/{id}")
    public ResponseEntity getStudentUsingPath(@PathVariable("id") int regNo){
        Student student = studentService.getStudentUsingPath(regNo);
        if(student==null){
            return new ResponseEntity("Id doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(student,HttpStatus.FOUND);
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
