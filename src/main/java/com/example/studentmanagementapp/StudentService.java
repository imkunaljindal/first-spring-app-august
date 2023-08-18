package com.example.studentmanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student getStudent(int regNo){
       return studentRepository.getStudent(regNo);
    }

    public String addStudent(Student student) {
        studentRepository.addStudent(student);
        return "Student added successfully";
    }

    public Student getStudentUsingPath(int regNo) {
        return studentRepository.getStudentUsingPath(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        return studentRepository.updateAge(regNo,newAge);
    }
}
