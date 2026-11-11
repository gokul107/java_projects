
package HospitalAppointment;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;

public class HospitalService {

    private HashMap<Integer, Patient> patients = new HashMap<>();
    private HashMap<Integer, Doctor> doctors = new HashMap<>();

    // Key: Doctor ID + Date + Time
    private HashMap<String, Appointment> appointments = new HashMap<>();

    // Keeps appointment history, including cancelled appointments
    private ArrayList<Appointment> appointmentHistory = new ArrayList<>();

    // Register Patient
    public void registerPatient(int id, String name, int age, String disease) {

        if (patients.containsKey(id)) {
            throw new IllegalArgumentException("Patient ID already exists!");
        }

        Patient patient = new Patient(id, name, age, disease);
        patients.put(id, patient);

        System.out.println("Patient registered successfully!");
    }

    // Add Doctor
    public void addDoctor(int id, String name, String specialization) {

        if (doctors.containsKey(id)) {
            throw new IllegalArgumentException("Doctor ID already exists!");
        }

        Doctor doctor = new Doctor(id, name, specialization);
        doctors.put(id, doctor);

        System.out.println("Doctor added successfully!");
    }

    // Book Appointment
    public void bookAppointment(int patientId, int doctorId,
                                 String dateInput, String timeInput) {

        Patient patient = patients.get(patientId);
        Doctor doctor = doctors.get(doctorId);

        if (patient == null) {
            throw new IllegalArgumentException("Patient not found!");
        }

        if (doctor == null) {
            throw new IllegalArgumentException("Doctor not found!");
        }

        LocalDate date = LocalDate.parse(dateInput);
        LocalTime time = LocalTime.parse(timeInput);

        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot book a past date!");
        }

        if (!doctor.getAvailableSlots().contains(time)) {
            throw new IllegalArgumentException("Invalid time slot!");
        }

        String key = doctorId + "_" + date + "_" + time;

        if (appointments.containsKey(key)) {
            throw new IllegalArgumentException("This time slot is already booked!");
        }

        Appointment appointment =
                new Appointment(patient, doctor, date, time);

        appointments.put(key, appointment);
        appointmentHistory.add(appointment);

        System.out.println("Appointment booked successfully!");
        appointment.displayAppointment();
    }

    // Cancel Appointment
    public void cancelAppointment(int doctorId, String dateInput,
                                  String timeInput) {

        LocalDate date = LocalDate.parse(dateInput);
        LocalTime time = LocalTime.parse(timeInput);

        String key = doctorId + "_" + date + "_" + time;

        Appointment appointment = appointments.remove(key);

        if (appointment == null) {
            throw new IllegalArgumentException("Appointment not found!");
        }

        appointment.cancelAppointment();

        System.out.println("Appointment cancelled successfully!");
    }

    // View Available Slots
    public void viewAvailableSlots(int doctorId, String dateInput) {

        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new IllegalArgumentException("Doctor not found!");
        }

        LocalDate date = LocalDate.parse(dateInput);

        if (date.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Cannot check slots for a past date!");
        }

        System.out.println("\nAvailable slots for "
                + doctor.getDoctorName());

        boolean found = false;

        for (LocalTime time : doctor.getAvailableSlots()) {

            String key = doctorId + "_" + date + "_" + time;

            if (!appointments.containsKey(key)) {
                System.out.println(time);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No available slots.");
        }
    }

    // View Doctor Schedule
    public void viewDoctorSchedule(int doctorId) {

        Doctor doctor = doctors.get(doctorId);

        if (doctor == null) {
            throw new IllegalArgumentException("Doctor not found!");
        }

        System.out.println("\nSchedule for Dr. "
                + doctor.getDoctorName());

        boolean found = false;

        for (Map.Entry<String, Appointment> entry
                : appointments.entrySet()) {

            Appointment appointment = entry.getValue();

            if (appointment.getDoctor().getDoctorId() == doctorId) {
                appointment.displayAppointment();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointments booked.");
        }
    }

    // View Patient History
    public void viewPatientHistory(int patientId) {

        Patient patient = patients.get(patientId);

        if (patient == null) {
            throw new IllegalArgumentException("Patient not found!");
        }

        System.out.println("\nAppointment history for "
                + patient.getPatientName());

        boolean found = false;

        for (Appointment appointment : appointmentHistory) {

            if (appointment.getPatient().getPatientId() == patientId) {
                appointment.displayAppointment();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No appointment history found.");
        }
    }

    // Display Patients
    public void displayPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patients registered.");
            return;
        }

        for (Patient patient : patients.values()) {
            patient.displayPatient();
            System.out.println("-----------------------------");
        }
    }

    // Display Doctors
    public void displayDoctors() {

        if (doctors.isEmpty()) {
            System.out.println("No doctors registered.");
            return;
        }

        for (Doctor doctor : doctors.values()) {
            doctor.displayDoctor();
            System.out.println("-----------------------------");
        }
    }
}
