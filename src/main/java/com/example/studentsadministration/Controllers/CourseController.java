package com.example.studentsadministration.Controllers;

import com.example.studentsadministration.Models.Courses;
import com.example.studentsadministration.Models.Students;
import com.example.studentsadministration.Repositories.ICourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {

    ICourseRepository courseRepository;

    public CourseController(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Create -> POST
    @PostMapping("/courses")
    public Courses create(@RequestBody Courses course){
        Courses savedCourse = courseRepository.save(course);
        return savedCourse;
    }

    //Read All -> GET
    @GetMapping("/courses")
    public ResponseEntity<List<Courses>> index() {
        //The return for finding all, will be a 'OK' http status
        return ResponseEntity.status(HttpStatus.OK).body(courseRepository.findAll());
    }

    //Read One (by id) -> GET
    @GetMapping("/courses/{id}")
    public Optional<Courses> readOne(@PathVariable long id){
        return courseRepository.findById(id);
    }

    // Update -> PUT
    @PutMapping("/courses/{id}")
    public Courses update(@PathVariable long id, @RequestBody Courses course){
        Courses updatedCourse = courseRepository.save(course);
        return updatedCourse;
    }

    // Delete -> Delete
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        courseRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
