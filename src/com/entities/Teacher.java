package com.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person {
    private long id;
    private List<Course> courses;

    public Teacher(String firstName, String lastName, long id) {
        super(firstName,lastName);
        this.id = id;
        this.courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "TeacherFirstName=" +getFirstName()+
                ", TeacherLastName=" + getLastName()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return courses.equals(teacher.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courses);
    }
}
