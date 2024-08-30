/*
*@ (#) CourseList.java		1.0 Aug 29, 2024
*
*Copyright (c) 2024 IUH. All rights reserved
*/
package iuh.fit.se;



import java.util.Arrays;
import java.util.Comparator;


/*
*@description:
*@author: Chu Anh Khoi
*@date: Aug 29, 2024
*version: 1.0
*/
public class CourseList {
    private Course[] courses;
    private int count = 0;

    public CourseList(int n) {
        if (n<=0)
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        courses = new Course[n];
    }

    public boolean addCourse(Course course){
        //Check if course is null
        if (course==null)
            return false;
        //Check if course is exists
        if (isExists(course)) {
            throw new IllegalArgumentException("Course already exists");
        }
        //Check if courses is full
        if (count==courses.length) {
            throw new IllegalStateException("Course list is full");
//            return false;
        }

        courses[count++] = course;
        return true;
    }

    private boolean isExists(Course course) {
        for (int i=0; i<count; i++)
            if (courses[i].getId().equalsIgnoreCase(course.getId()))
                return true;
        return false;
    }

    public Course[] getCourses() {
        return courses;
    }

    public boolean removeCourseByID(String id) {
        for (int i=0; i<count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id)) {
                for (int j = i; j < count - 1; j++)
                    courses[j] = courses[j + 1];
                courses[count-1] = null;
                count--;
                return true;
            }

        }
//        System.out.println("Error: Course with id " + id + " does not exist");
        return false;
    }

    public Course findCourseByID(String id) {
        for (int i=0; i<count; i++) {
            if (courses[i].getId().equalsIgnoreCase(id))
                return courses[i];
        }
        return null;
    }

    public Course[] findCoursesByTitle(String title) {
        Course[] matchingCourses = new Course[count];
        int matchingCount = 0;
        for (int i=0; i<count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(title.toLowerCase())){
                matchingCourses[matchingCount++] = courses[i];
            }
        }
        if (matchingCount == 0)
            return null;
        else return matchingCourses;
    }

    public Course[] findCoursesByDepartment(String department) {
        Course[] matchingCourses = new Course[count];
        int matchingCount = 0;
        for (int i=0; i<count; i++) {
            if (courses[i].getDepartment().equalsIgnoreCase(department)){
                matchingCourses[matchingCount++] = courses[i];
            }
        }
        if (matchingCount == 0)
            return null;
        else return matchingCourses;
    }

    public Course[] getSortedCoursesByTitle() {
        Course[] sortedCourses = Arrays.copyOf(courses, count);
        Arrays.sort(sortedCourses, Comparator.comparing(Course::getTitle));
        return sortedCourses;
    }

    public Course[] getCoursesWithMaxCredit() {
        int maxCredit = courses[0].getCredit();
        for (int i=1; i<count; i++) {
            if (courses[i].getCredit() > maxCredit){
                maxCredit = courses[i].getCredit();
            }
        }

        int maxCreditCount = 0;
        Course[] courseWithMaxCredit = new Course[count];
        for (int i=0; i<count; i++) {
            if (courses[i].getCredit() == maxCredit){
                courseWithMaxCredit[maxCreditCount++] = courses[i];
            }
        }
        return courseWithMaxCredit;
    }
}
