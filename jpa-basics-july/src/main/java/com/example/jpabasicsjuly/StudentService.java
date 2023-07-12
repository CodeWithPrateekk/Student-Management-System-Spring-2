package com.example.jpabasicsjuly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Object addStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student getById(int rollNo) {
        Optional<Student> optionalStudent = studentRepository.findById(rollNo);

        if(optionalStudent.isPresent())
            return optionalStudent.get();

        return null;

    }
}
