/*
*@ (#) TestCourse.java		1.0 Aug 30, 2024
*
*Copyright (c) 2024 IUH. All rights reserved
*/
package iuh.fit.se;

import java.util.Scanner;

/*
*@description:
*@author: Chu Anh Khoi
*@date: Aug 30, 2024
*version: 1.0
*/
public class TestCourse {
    public static void main(String[] args) {

        CourseList courseList = new CourseList(10);
        //add course
        initData(courseList);
        //display course
        System.out.printf("%-10s %-30s %10s %-20s%n", "id", "title", "credit", "department");
        Course[] temp = courseList.getCourses();
        for (Course course : temp) {
            if (course != null) {
                System.out.println(course);
            }
        }
        //delete course
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter course ID you want to delete: ");
        String id = sc.nextLine();
        if (courseList.removeCourseByID(id)) {
            System.out.println("Course with ID " + id + " was deleted.");
            //display course
            for (Course course : temp) {
                if (course != null) {
                    System.out.println(course);
                }
            }
        }
        else System.out.println("Course with ID " + id + " was not found.");

        //search course by id
        System.out.print("Enter course ID you want to find: ");
        id = sc.nextLine();
        Course searchResult = courseList.findCourseByID(id);
        if (searchResult != null) {
            System.out.println(searchResult);
        }
        else System.out.println("Course with ID " + id + " was not found.");
        //relative search course by name
        System.out.print("Enter course title you want to find: ");
        String searchTitle = sc.nextLine();
        Course[] resultSearchByTitle = courseList.findCoursesByTitle(searchTitle);
        if (resultSearchByTitle != null) {
            System.out.println("Found " + resultSearchByTitle.length + " courses:");
            for (Course course : resultSearchByTitle) {
                System.out.println(course);
            }
        }
        //search course by department
        System.out.print("Enter course department you want to find: ");
        String searchDepartment = sc.nextLine();
        Course[] resultSearchByDepartment = courseList.findCoursesByDepartment(searchDepartment);
        if (resultSearchByDepartment != null) {
            System.out.println("Found " + resultSearchByDepartment.length + " courses:");
            for (Course course : resultSearchByDepartment) {
                System.out.println(course);
            }
        }
        else System.out.println("Course with department " + searchDepartment + " was not found.");
        //sort courses by title
        Course[] sortedCourses = courseList.getSortedCoursesByTitle();
        if (sortedCourses != null) {
            System.out.println("Courses sorted by title:");
            for (Course course : sortedCourses) {
                System.out.println(course);
            }
        }
        //list course with max credit
        Course[] maxCreditCourses = courseList.getCoursesWithMaxCredit();
        if (maxCreditCourses != null) {
            System.out.println("Max credit courses found:");
            for (Course course : maxCreditCourses) {
                System.out.println(course);
            }
        }
        sc.close();
    }

    private static void initData(CourseList courseList) {
        Course c1 = new Course(3, "Java Programming","CS101","CS");
        Course c2 = new Course(3, "Database Programming","CS102","IS");
        Course c3 = new Course(3, "C# Programming","CS103","SE");
        
        courseList.addCourse(c1);
        courseList.addCourse(c2);
        courseList.addCourse(c3);

    }
}
