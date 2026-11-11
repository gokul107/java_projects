
package StudentManagementSystem;

import java.io.Serializable;

public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    private int courseId;
    private String courseName;
    private int duration;

    // Constructor
    public Course(int courseId, String courseName, int duration) {

        this.courseId = courseId;
        this.courseName = courseName;
        this.duration = duration;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getDuration() {
        return duration;
    }

    // Display Course
    public void displayCourse() {

        System.out.println("Course ID   : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Duration    : " + duration + " months");
    }
}
