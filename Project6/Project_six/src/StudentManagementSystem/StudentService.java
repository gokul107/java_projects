
package StudentManagementSystem;

import java.util.HashMap;

public class StudentService {

    private HashMap<Integer, Student> students =
            new HashMap<>();

    // Add Student
    public void addStudent(Student student) {

        if (students.containsKey(student.getId())) {

            throw new IllegalArgumentException(
                "Student ID already exists!"
            );
        }

        students.put(student.getId(), student);

        System.out.println("Student added successfully!");
    }

    // Display All Students
    public void displayAllStudents() {

        if (students.isEmpty()) {

            System.out.println("No students available!");
            return;
        }

        for (Student student : students.values()) {

            student.displayStudent();
        }
    }

    // Search Student By ID
    public Student searchById(int id) {

        Student student = students.get(id);

        if (student == null) {
            System.out.println("Student not found!");
        } else {
            student.displayStudent();
        }

        return student;
    }

    // Search Student By Name
    public void searchByName(String name) {

        boolean found = false;

        for (Student student : students.values()) {

            if (student.getName().equalsIgnoreCase(name)) {

                student.displayStudent();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }
    }

    // Update Student Marks
    public void updateMarks(int id, double marks) {

        Student student = students.get(id);

        if (student == null) {

            System.out.println("Student not found!");
            return;
        }

        student.setMarks(marks);

        System.out.println("Marks updated successfully!");
    }

    // Update Attendance
    public void updateAttendance(int id, int attendance) {

        Student student = students.get(id);

        if (student == null) {

            System.out.println("Student not found!");
            return;
        }

        student.setAttendance(attendance);

        System.out.println("Attendance updated successfully!");
    }

    // Calculate Grade
    public void calculateGrade(int id) {

        Student student = students.get(id);

        if (student == null) {

            System.out.println("Student not found!");

        } else {

            System.out.println(
                "Student Grade: " + student.calculateGrade()
            );
        }
    }

    // Remove Student
    public void removeStudent(int id) {

        Student removed = students.remove(id);

        if (removed != null) {

            System.out.println("Student removed successfully!");

        } else {

            System.out.println("Student not found!");
        }
    }

    // Display Topper
    public void displayTopper() {

        Student topper = students.values()
                .stream()
                .max((s1, s2) ->
                    Double.compare(
                        s1.getMarks(),
                        s2.getMarks()
                    ))
                .orElse(null);

        if (topper == null) {

            System.out.println("No students available!");

        } else {

            System.out.println("Topper Details:");
            topper.displayStudent();
        }
    }

    // Get All Students
    public HashMap<Integer, Student> getStudents() {

        return students;
    }

    // Load Students
    public void setStudents(
            HashMap<Integer, Student> students) {

        this.students = students;
    }
}
