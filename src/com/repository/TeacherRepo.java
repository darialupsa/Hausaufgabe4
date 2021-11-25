package com.repository;

import com.entities.Course;
import com.entities.Person;
import com.entities.Teacher;

import java.util.List;

public class TeacherRepo extends InMemoryRepo<Teacher>{
    public TeacherRepo() {
        super();
    }

    /**
     * Updateaza obiectul de tip Teacher
     *
     * @param obj
     * @return noul obiect actualizat
     */
    @Override
    public Teacher update(Teacher obj) {
        Teacher teacherToUpdate = this.repoList.stream()
                .filter(teacher -> teacher.getFirstName() == obj.getFirstName())
                .findFirst()
                .orElseThrow();

        teacherToUpdate.setLastName(obj.getLastName());
        teacherToUpdate.setCourses(obj.getCourses());
        return teacherToUpdate;
    }
}
