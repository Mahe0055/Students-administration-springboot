package com.example.studentsadministration.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Students {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String name;

  @ManyToMany(
    mappedBy = "students",
    cascade = CascadeType.ALL,
    fetch = FetchType.LAZY
  )
  private List<Courses> enrolledCourses = new ArrayList<>();

  public Students() {}

  public List<Courses> getEnrolledCourses() {
    return enrolledCourses;
  }

  public Students(String name) {
    this.name = name;
  }

  //method for student to enrol a course (assignment 2)
  public void enrollStudent(Courses course) {
    enrolledCourses.add(course);
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
