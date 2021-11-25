package com.repository;

import com.entities.Course;
import com.entities.Person;
import com.entities.Student;

import java.util.List;

public class CourseRepo extends InMemoryRepo<Course>{
    public CourseRepo() {
        super();
    }

    @Override
    public Course update(Course obj) {
        Course courseToUpdate = this.repoList.stream()
                .filter(course -> course.getName() == obj.getName())
                .findFirst()
                .orElseThrow();

        courseToUpdate.setTeacher(obj.getTeacher());
        courseToUpdate.setCredits(obj.getCredits());
        courseToUpdate.setMaxEnrollment(obj.getMaxEnrollment());
        courseToUpdate.setStudentsEnrolled(obj.getStudentsEnrolled());
        return courseToUpdate;
    }


    public Course findCourseByName(String name){
        for (Course course: repoList){
            if (course.getName().equals(name))
                return course;
        }
        return null;
    }
}
