
package StudentManagementSystem;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String email;
    private double marks;
    private int attendance;
    private StudentStatus status;
    private Course course;

    // Constructor
    public Student(int id, String name, String email,
                   double marks, int attendance,
                   StudentStatus status, Course course) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.marks = marks;
        this.attendance = attendance;
        this.status = status;
        this.course = course;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getMarks() {
        return marks;
    }

    public int getAttendance() {
        return attendance;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public Course getCourse() {
        return course;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMarks(double marks) {

        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException(
                "Marks must be between 0 and 100"
            );
        }

        this.marks = marks;
    }

    public void setAttendance(int attendance) {

        if (attendance < 0 || attendance > 100) {
            throw new IllegalArgumentException(
                "Attendance must be between 0 and 100"
            );
        }

        this.attendance = attendance;
    }

    public void setStatus(StudentStatus status) {
        this.status = status;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Calculate Grade
    public String calculateGrade() {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    // Display Student
    public void displayStudent() {

        System.out.println("\nStudent ID  : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Email       : " + email);
        System.out.println("Marks       : " + marks);
        System.out.println("Attendance  : " + attendance + "%");
        System.out.println("Grade       : " + calculateGrade());
        System.out.println("Status      : " + status);

        if (course != null) {
            System.out.println(
                "Course      : " + course.getCourseName()
            );
        }

        System.out.println("--------------------------------");
    }
}
