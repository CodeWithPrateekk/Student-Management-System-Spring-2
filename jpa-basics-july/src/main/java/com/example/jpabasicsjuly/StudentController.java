package com.example.jpabasicsjuly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
            StudentService studentService;

    @PostMapping("/add-student")
        public ResponseEntity addStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.ACCEPTED);
        }

        @GetMapping("/get-by-id")
    public ResponseEntity getById(@RequestParam("rollNo") int rollNo) {
            Student student = studentService.getById(rollNo);

            if (student == null)
                return new ResponseEntity("Invalid RollNo ", HttpStatus.NOT_FOUND);


            return new ResponseEntity(student, HttpStatus.FOUND);
        }
}
