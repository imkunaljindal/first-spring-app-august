package com.example.studentmanagementapp;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Repository
public class StudentRepository {

    Map<Integer,Student> db = new HashMap<>();

    public Student getStudent(int regNo){
        return db.get(regNo);
    }

    public void addStudent(Student student) {
        db.put(student.getRegNo(),student);
    }

    public Student getStudentUsingPath(int regNo) {
        return db.get(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        db.get(regNo).setAge(newAge);
        return db.get(regNo);
    }

}
