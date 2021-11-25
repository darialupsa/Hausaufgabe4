package com.controller;

import com.entities.Course;
import com.entities.Student;
import com.entities.Teacher;
import com.exception.ObjectNotFound;
import com.repository.CourseRepo;
import com.repository.StudentRepo;
import com.repository.TeacherRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RegistrationSystem {
    private final TeacherRepo teacherRepository;
    private final StudentRepo studentRepository;
    private final CourseRepo courseRepository;

    public RegistrationSystem(TeacherRepo teacherRepository, StudentRepo studentRepository, CourseRepo courseRepository) {
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public StudentRepo getStudentRepository() {
        return studentRepository;
    }

    public TeacherRepo getTeacherRepository() {
        return teacherRepository;
    }

    public CourseRepo getCourseRepository() {
        return courseRepository;
    }

    /**
     *
     * @return toate elementele din CourseRepository
     */
    public List<Course> getAllCourses() {
        return courseRepository.getAll();
    }

    /**
     *
     * @return toate elementele din TeacherRepository
     */
    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAll();
    }

    /**
     *
     * @return toate elementele din StudentRepository
     */
    public List<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    /**
     *
     * @param StudentId id ul studentului pe care l cautam
     * @param name numele cursului
     * @return true daca gasim si Id ul studentului si si numele cursului la care acesta doreste sa se inregistreze
     * @throws ObjectNotFound exceptia aruncata cand nu gasim in liste obiectul dorit
     */
    public boolean register(long StudentId, String name) throws ObjectNotFound {
        if(studentRepository.findStudentId(StudentId) == null)
            throw new ObjectNotFound("Student not found");
        if (courseRepository.findCourseByName(name) == null)
            throw new ObjectNotFound("Course not found");
        Course course = courseRepository.findCourseByName(name);
        Student student = studentRepository.findStudentId(StudentId);
        if (course.getStudentsEnrolled().size() >= course.getMaxEnrollment())
        {
            System.out.println("Not enought places");
            return false;
        }
        if (student.getTotalCredits() + course.getCredits() > 30){
            System.out.println("Too many credits");
            return false;
        }
        //bagam studentul in lista de studenti a cursului si bagam cursul in lista de cursuri a studentului
        course.getStudentsEnrolled().add(student);
        student.getEnrolledCourses().add(course);
        student.setTotalCredits(student.getTotalCredits() + course.getCredits());
        return true;
    }

    /**
     *
     * @return lista noua dupa adaugarea studentilor care s-au mai inscris la cursul respectiv
     */
    public List<Course> retrieveCoursesWithFreePlaces() {
        List<Course> newCouseList = new ArrayList<>();
        for (Course course:courseRepository.getAll()){
            if (course.getMaxEnrollment() > course.getStudentsEnrolled().size()){
                newCouseList.add(course);
            }
        }
        return newCouseList;
     }

    /**
     *
     * @param name numele cursului
     * @return lista cu studentii de la un anumit curs
     * @throws ObjectNotFound
     */
    public List<Student> retrieveStudentsEnrolledForACourse(String name) throws ObjectNotFound {
        if(courseRepository.findCourseByName(name) == null)
            throw new ObjectNotFound("Course not found");
        Course course = courseRepository.findCourseByName(name);
        return course.getStudentsEnrolled();
    }

    /**
     * metoda se sortare a studentilor dupa nr ul de credite
     */
    public void sortStudentsByCredits(){
        Collections.sort(studentRepository.getAll(), new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getTotalCredits() - o2.getTotalCredits();
            }
        });
    }

    /**
     * metoda de sortare a cursurilor dupa nume (ordine alfabetica)
     */
    public void sortCoursesByName(){
        Collections.sort(courseRepository.getAll(), new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    /**
     *
     * @return lista cu studenti dupa filtrare
     */
    public List<Student> filterStudentsWithLessThan20Credits(){
        List<Student> filteredStudents = new ArrayList<>();
        filteredStudents.addAll(studentRepository.getAll());
        filteredStudents.stream().filter(student -> student.getTotalCredits() <= 20);
        return filteredStudents;
    }

    public List<Course> filterCoursesWithMaxStudents(){
        List<Course> filteredCourses = new ArrayList<>();
        filteredCourses.addAll(courseRepository.getAll());
        filteredCourses.stream().filter(course -> course.getStudentsEnrolled().size() == course.getMaxEnrollment());
        return filteredCourses;

    }

}
