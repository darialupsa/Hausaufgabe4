package com.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private long StudentId;
    private int totalCredits;
    private List<Course> enrolledCourses;

    public Student(String firstName, String lastName, long studentId) {
        super(firstName, lastName);
        StudentId = studentId;
        this.totalCredits = 0;
        this.enrolledCourses = new ArrayList<>();
    }

    public long getStudentId() {
        return StudentId;
    }

    public void setStudentId(long studentId) {
        StudentId = studentId;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Course> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentName=" +getFirstName()+
                ", StudentLastName=" + getLastName()+
                ", StudentId=" + StudentId +
                ", totalCredits=" + totalCredits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return StudentId == student.StudentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentId);
    }
}
