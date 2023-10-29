package com.example.studentsadministration.Repositories;

import com.example.studentsadministration.Models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Courses, Long> {}
