package com.example.studentsadministration.DTO;

import java.util.List;

public class EnrolmentDTO {

    private Long studentId;
    private Long courseId;
    private List<String> enrolledCourses;

    public EnrolmentDTO() {
    }

    public EnrolmentDTO(Long studentId, Long courseId, List<String> enrolledCourses) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrolledCourses = enrolledCourses;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<String> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }
}
