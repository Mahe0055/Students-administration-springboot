package com.example.studentsadministration.Models;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Courses {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String courseName;

  @ManyToMany
  private List<Students> students = new ArrayList<>();

  public Courses() {}

  public Courses(String courseName) {
    this.courseName = courseName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }
}
