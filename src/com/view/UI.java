package com.view;

import com.controller.RegistrationSystem;
import com.exception.ObjectNotFound;

import java.util.Scanner;

public class UI {
    private RegistrationSystem registrationSystem;
    private final Scanner input = new Scanner(System.in);

    public UI(RegistrationSystem registrationSystem) {
        this.registrationSystem = registrationSystem;
    }

    public void show() throws ObjectNotFound{
        while (true){
            System.out.println("---------Menu----------");
            System.out.print("""
                1.Get all courses
                2.Get all teachers
                3.Get all students
                4.Register
                5.Retrieve courses with free places
                6.Retrieve students enrolled for a course
                7.Sort students by credits
                8.Sort courses by name
                9.Filter students with less than 20 credits
                10.Filter courses with max students
                11.Quit
                Choose option : \n                """);
            int ok = 1;
            int option = input.nextInt();
            switch (option){
                case 1:
                    System.out.println(registrationSystem.getAllCourses());
                    break;
                case 2:
                    System.out.println(registrationSystem.getAllTeachers());
                    break;
                case 3:
                    System.out.println(registrationSystem.getAllStudents());
                    break;
                case 4:
                    System.out.println("Id:\n");
                    long StudentId = input.nextLong();
                    System.out.println("Name:\n");
                    String name = input.next();
                    registrationSystem.register(StudentId, name);
                    break;
                case 5:
                    System.out.println(registrationSystem.retrieveCoursesWithFreePlaces());
                    break;
                case 6:
                    System.out.println("Name Course= ");
                    name = input.next();
                    System.out.println(registrationSystem.retrieveStudentsEnrolledForACourse(name));
                    break;
                case 7:
                    registrationSystem.sortStudentsByCredits();
                    System.out.println(registrationSystem.getAllStudents());
                    break;
                case 8:
                    registrationSystem.sortCoursesByName();
                    System.out.println(registrationSystem.getAllCourses());
                    break;
                case 9:
                    System.out.println(registrationSystem.filterStudentsWithLessThan20Credits());
                    break;
                case 10:
                    System.out.println(registrationSystem.filterCoursesWithMaxStudents());
                    break;
                case 11:
                    ok = 0;
                    break;
            }
            if (ok == 0)
                break;
        }
    }

}
