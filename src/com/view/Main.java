package com.view;

import com.controller.RegistrationSystem;
import com.entities.Course;
import com.entities.Person;
import com.entities.Student;
import com.entities.Teacher;
import com.exception.ObjectNotFound;
import com.repository.CourseRepo;
import com.repository.StudentRepo;
import com.repository.TeacherRepo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ObjectNotFound {
        Student student1 = new Student("Lupsa", "Daria", 1);
        Student student2 = new Student("Halip", "Petronela", 2);
        Student student3 = new Student("Morar", "Ana", 3);
        Student student4 = new Student("Moga", "Florian", 4);

        Teacher teacher1 = new Teacher("Pop", "Dorel",100);
        Teacher teacher2 = new Teacher("Popa", "Andrei",101);


        Course course1 = new Course("Datenbanken", teacher1, 20, 5);
        Course course2 = new Course("Computernetzwerke", teacher2, 24, 6);
        Course course3 = new Course("Logische Programmierung", teacher1, 30, 6);
        Course course4 = new Course("Deutsch", teacher2, 21, 4);

        List<Course> coursesTeacher1 = new ArrayList<>();
        coursesTeacher1.add(course1);
        coursesTeacher1.add(course2);
        List<Course> coursesTeacher2 = new ArrayList<>();
        coursesTeacher2.add(course3);
        coursesTeacher2.add(course4);


        CourseRepo courseRepo = new CourseRepo();
        courseRepo.create(course1);
        courseRepo.create(course2);
        courseRepo.create(course3);
        courseRepo.create(course4);

        StudentRepo studentRepo = new StudentRepo();
        studentRepo.create(student1);
        studentRepo.create(student2);
        studentRepo.create(student3);
        studentRepo.create(student4);

        TeacherRepo teacherRepo = new TeacherRepo();
        teacherRepo.create(teacher1);
        teacherRepo.create(teacher2);

        RegistrationSystem registrationSystem = new RegistrationSystem(teacherRepo, studentRepo, courseRepo);

        UI ui = new UI(registrationSystem);
        ui.show();

    }
}
