
package StudentManagementSystem;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        StudentFileService fileService =
                new StudentFileService();

        // Load previous student records
        service.setStudents(fileService.loadStudents());

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Search Student By Name");
            System.out.println("5. Update Student Marks");
            System.out.println("6. Update Attendance");
            System.out.println("7. Calculate Grade");
            System.out.println("8. Remove Student");
            System.out.println("9. Display Topper");
            System.out.println("10. Save Student Details");
            System.out.println("11. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Email: ");
                        String email = sc.nextLine();

                        System.out.print("Enter Marks: ");
                        double marks = sc.nextDouble();

                        System.out.print("Enter Attendance: ");
                        int attendance = sc.nextInt();

                        if (marks < 0 || marks > 100) {
                            throw new IllegalArgumentException(
                                "Marks must be between 0 and 100!"
                            );
                        }

                        if (attendance < 0 || attendance > 100) {
                            throw new IllegalArgumentException(
                                "Attendance must be between 0 and 100!"
                            );
                        }

                        sc.nextLine();

                        System.out.print("Enter Course ID: ");
                        int courseId = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Course Name: ");
                        String courseName = sc.nextLine();

                        System.out.print("Enter Course Duration (months): ");
                        int duration = sc.nextInt();

                        if (duration <= 0) {
                            throw new IllegalArgumentException(
                                "Duration must be greater than zero!"
                            );
                        }

                        Course course = new Course(
                            courseId, courseName, duration
                        );

                        Student student = new Student(
                            id,
                            name,
                            email,
                            marks,
                            attendance,
                            StudentStatus.ACTIVE,
                            course
                        );

                        service.addStudent(student);

                        break;

                    case 2:

                        service.displayAllStudents();

                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");

                        int searchId = sc.nextInt();

                        service.searchById(searchId);

                        break;

                    case 4:

                        sc.nextLine();

                        System.out.print("Enter Student Name: ");

                        String searchName = sc.nextLine();

                        service.searchByName(searchName);

                        break;

                    case 5:

                        System.out.print("Enter Student ID: ");

                        int marksId = sc.nextInt();

                        System.out.print("Enter New Marks: ");

                        double newMarks = sc.nextDouble();

                        service.updateMarks(marksId, newMarks);

                        break;

                    case 6:

                        System.out.print("Enter Student ID: ");

                        int attendanceId = sc.nextInt();

                        System.out.print("Enter New Attendance: ");

                        int newAttendance = sc.nextInt();

                        service.updateAttendance(
                            attendanceId, newAttendance
                        );

                        break;

                    case 7:

                        System.out.print("Enter Student ID: ");

                        int gradeId = sc.nextInt();

                        service.calculateGrade(gradeId);

                        break;

                    case 8:

                        System.out.print("Enter Student ID: ");

                        int deleteId = sc.nextInt();

                        service.removeStudent(deleteId);

                        break;

                    case 9:

                        service.displayTopper();

                        break;

                    case 10:

                        fileService.saveStudents(
                            service.getStudents()
                        );

                        break;

                    case 11:

                        fileService.saveStudents(
                            service.getStudents()
                        );

                        System.out.println(
                            "Thank you for using Student Management System!"
                        );

                        sc.close();

                        return;

                    default:

                        System.out.println("Invalid Choice!");

                }

            } catch (IllegalArgumentException e) {

                System.out.println("Error: " + e.getMessage());

            }
        }
    }
}
