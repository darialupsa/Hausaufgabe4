package com.repository;

import com.entities.Course;
import com.entities.Person;
import com.entities.Student;

import java.util.List;

public class StudentRepo extends InMemoryRepo<Student>{
    public StudentRepo() {
        super();
    }

    /**
     * Updateaza obiectul de tip Student
     *
     * @param obj
     * @return noul obiect actualizat
     *
     */
    @Override
    public Student update(Student obj) {
        Student studentToUpdate = this.repoList.stream()
                .filter(student -> student.getStudentId() == obj.getStudentId())
                .findFirst()
                .orElseThrow();

        studentToUpdate.setEnrolledCourses(obj.getEnrolledCourses());
        studentToUpdate.setTotalCredits(obj.getTotalCredits());
        studentToUpdate.setFirstName(obj.getFirstName());
        studentToUpdate.setLastName(obj.getLastName());
        return studentToUpdate;
    }

    public Student findStudentId(long IdStudent){
        for (Student student: repoList){
            if (student.getStudentId() == IdStudent)
                return student;
        }
        return null;
    }
}
