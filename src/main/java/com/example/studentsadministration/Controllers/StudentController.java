package com.example.studentsadministration.Controllers;

import com.example.studentsadministration.Models.Courses;
import com.example.studentsadministration.Models.Students;
import com.example.studentsadministration.Repositories.ICourseRepository;
import com.example.studentsadministration.Repositories.IStudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Here is a full CRUD REST API of 'Students'
@RestController
public class StudentController {

  IStudentRepository studentRepository;
  ICourseRepository courseRepository;

  public StudentController(IStudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  // Create -> POST
  @PostMapping("/students")
  public Students create(@RequestBody Students student) {
    Students savedStudent = studentRepository.save(student);
    return savedStudent;
  }

  //Read All -> GET
  @GetMapping("/students")
  public ResponseEntity<List<Students>> getStudentsAndCourses() {
    List<Students> students = studentRepository.findAll();
    //for each student, we add enrolled courses to the students list
    students.forEach(student -> student.getEnrolledCourses());
    //The return for finding all, will be a 'OK' http status
    return ResponseEntity.status(HttpStatus.OK).body(students);
  }

  //Read One (by id) -> GET
  @GetMapping("/students/{id}")
  public ResponseEntity<Students> readOne(@PathVariable long id) {
    Optional<Students> studentById = studentRepository.findById(id);
    Students student = studentById.get();
    //adding courses to the list of students
    student.getEnrolledCourses();
    return ResponseEntity.status(HttpStatus.OK).body(student);
  }

  // Update -> PUT
  @PutMapping("/students/{id}")
  public Students update(@PathVariable long id, @RequestBody Students student) {
    Students updatedStudent = studentRepository.save(student);
    return updatedStudent;
  }

  // Update -> PUT - assignment 2 student enroll for course
  @PutMapping("/students/{id}/courses/{course_id}")
  public ResponseEntity<Students> update(
    @PathVariable long id,
    @RequestBody Students student,
    @PathVariable long course_id
  ) {
    Optional<Students> studentEnrolsToCourse = studentRepository.findById(id);
    Optional<Courses> courseId = courseRepository.findById(course_id);

    Students oneStudent = studentEnrolsToCourse.get();
    Courses course = courseId.get();

    student.enrollStudent(course);
    studentRepository.save(oneStudent);

    return ResponseEntity.status(HttpStatus.OK).body(oneStudent);
  }

  // Delete -> Delete
  @DeleteMapping("/students/{id}")
  public ResponseEntity<Void> delete(@PathVariable long id) {
    studentRepository.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
