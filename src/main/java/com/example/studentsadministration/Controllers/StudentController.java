package com.example.studentsadministration.Controllers;
import com.example.studentsadministration.DTO.EnrolmentDTO;
import com.example.studentsadministration.Models.Courses;
import com.example.studentsadministration.Models.Students;
import com.example.studentsadministration.Repositories.IStudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Here is a full CRUD REST API of 'Students'
@RestController
public class StudentController {

    IStudentRepository studentRepository;

    public StudentController(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    // Create -> POST
    @PostMapping("/students")
    public Students create(@RequestBody Students student){
        Students savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    //Read All -> GET
    @GetMapping("/students")
    public ResponseEntity<List<Students>> index() {
        //The return for finding all, will be a 'OK' http status
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());

        List<EnrolmentDTO> studentsWithCourses = new ArrayList<>();

        for (Students student : students) {
            EnrolmentDTO studentDTO = new EnrolmentDTO(();
            studentDTO.setStudentId((student.getId());
            studentDTO.setSName(student.getName());

            List<String> enrolledCourses = student.getCourses().stream()
                    .map(Courses::getCourseName)
                    .collect(Collectors.toList());

            studentDTO.setEnrolledCourses(enrolledCourses);
            studentsWithCourses.add(studentDTO);
        }
    }

    //Read One (by id) -> GET
    @GetMapping("/students/{id}")
    public Optional<Students> readOne(@PathVariable long id){
        return studentRepository.findById(id);
    }

    // Update -> PUT
    @PutMapping("/students/{id}")
    public Students update(@PathVariable long id, @RequestBody Students student){
        Students updatedStudent = studentRepository.save(student);
        return updatedStudent;
    }

    // Update -> PUT - assignment 2 student enroll for course


    // Delete -> Delete
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
