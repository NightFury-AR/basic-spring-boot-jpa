package com.basicjpaweb.basicjpaweb.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    private ServiceGeneric<StudentRepository,Student> studentService1;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping("delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") String studentId) {
        studentService.deleteStudentById(studentId);
    }

    @PutMapping("update/{studentId}")
    public void updateStudent(@PathVariable("studentId") String studentId, @RequestParam(required = false) String name,@RequestParam(required = false) String email) {
        studentService.updateStudent(Long.parseLong(studentId),name,email);
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId") Long studentId) {
        return studentService.getStudentById(studentId);
    }


}
