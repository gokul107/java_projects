package HospitalAppointment;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        HospitalService hospital = new HospitalService();

        while (true) {

            System.out.println("\n===== HOSPITAL APPOINTMENT MANAGEMENT =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Display Patients");
            System.out.println("4. Display Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. View Available Slots");
            System.out.println("8. View Doctor Schedule");
            System.out.println("9. View Patient History");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Enter Patient ID: ");
                        int patientId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Patient Name: ");
                        String patientName = sc.nextLine();

                        System.out.print("Enter Age: ");
                        int age = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Disease: ");
                        String disease = sc.nextLine();

                        hospital.registerPatient(
                                patientId, patientName, age, disease);
                        break;

                    case 2:
                        System.out.print("Enter Doctor ID: ");
                        int doctorId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Doctor Name: ");
                        String doctorName = sc.nextLine();

                        System.out.print("Enter Specialization: ");
                        String specialization = sc.nextLine();

                        hospital.addDoctor(
                                doctorId, doctorName, specialization);
                        break;

                    case 3:
                        hospital.displayPatients();
                        break;

                    case 4:
                        hospital.displayDoctors();
                        break;

                    case 5:
                        System.out.print("Enter Patient ID: ");
                        int pId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Doctor ID: ");
                        int dId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();

                        System.out.print("Enter Time (HH:MM): ");
                        String time = sc.nextLine();

                        hospital.bookAppointment(pId, dId, date, time);
                        break;

                    case 6:
                        System.out.print("Enter Doctor ID: ");
                        int cancelDoctorId =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Appointment Date (YYYY-MM-DD): ");
                        String cancelDate = sc.nextLine();

                        System.out.print("Enter Appointment Time (HH:MM): ");
                        String cancelTime = sc.nextLine();

                        hospital.cancelAppointment(
                                cancelDoctorId, cancelDate, cancelTime);
                        break;

                    case 7:
                        System.out.print("Enter Doctor ID: ");
                        int slotDoctorId =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String slotDate = sc.nextLine();

                        hospital.viewAvailableSlots(slotDoctorId, slotDate);
                        break;

                    case 8:
                        System.out.print("Enter Doctor ID: ");
                        int scheduleDoctorId =
                                Integer.parseInt(sc.nextLine());

                        hospital.viewDoctorSchedule(scheduleDoctorId);
                        break;

                    case 9:
                        System.out.print("Enter Patient ID: ");
                        int historyPatientId =
                                Integer.parseInt(sc.nextLine());

                        hospital.viewPatientHistory(historyPatientId);
                        break;

                    case 10:
                        System.out.println("Thank you for using Hospital Management System!");
                        sc.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");

            } catch (DateTimeParseException e) {
                System.out.println("Invalid date or time format!");
                System.out.println("Date: YYYY-MM-DD | Time: HH:MM");

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
