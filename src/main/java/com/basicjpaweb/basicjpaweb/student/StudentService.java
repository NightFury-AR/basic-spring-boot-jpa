package com.basicjpaweb.basicjpaweb.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Invalid student Id");
        }
        studentRepository.save(student);
    }

    public void deleteStudentById(String studentId) {
        Optional<Student> studentOptional = studentRepository.findById(Long.parseLong(studentId));
        if(!studentOptional.isPresent()) {
            throw new IllegalStateException(" The Given Id doesn't exist !");
        }
        studentRepository.deleteById(Long.parseLong(studentId));
    }

    @Transactional
    public void updateStudent(Long studentId,String name,String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("not valid ID"));
        if(name!=null && name.length()>0 && !Objects.equals(student.getName(),name)) {
            student.setName(name);
        }
        if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)) {
            student.setEmail(email);
        }
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(!studentOptional.isPresent()) {
            throw new IllegalStateException("Given Id is not found !");
        }
        return studentOptional.get();
    }
}
