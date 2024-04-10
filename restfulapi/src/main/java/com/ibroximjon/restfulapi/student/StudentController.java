package com.ibroximjon.restfulapi.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
@DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
}
@PutMapping(path = "{studentId}")
public void updateStudent(
       @PathVariable("studentId") Long studentId,
       @RequestParam(name="name",required = false) String studentName,
       @RequestParam(name = "email",required = false) String studentEmail
){
    System.out.println("Id "+studentId+" Student Name "+studentName+" Student email "+studentEmail);
        studentService.updateStudent(studentId,studentName,studentEmail);
}

}
