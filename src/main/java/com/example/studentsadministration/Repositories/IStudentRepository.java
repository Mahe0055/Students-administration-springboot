package com.example.studentsadministration.Repositories;

import com.example.studentsadministration.Models.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Students, Long> {}
