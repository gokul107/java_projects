package HospitalAppointment;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private boolean cancelled;

    public Appointment(Patient patient, Doctor doctor,
                       LocalDate appointmentDate, LocalTime appointmentTime) {

        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.cancelled = false;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public LocalTime getAppointmentTime() {
        return appointmentTime;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void cancelAppointment() {
        cancelled = true;
    }

    public void displayAppointment() {
        System.out.println("Patient: " + patient.getPatientName());
        System.out.println("Doctor: " + doctor.getDoctorName());
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time: " + appointmentTime);
        System.out.println("Status: " + (cancelled ? "Cancelled" : "Booked"));
        System.out.println("-----------------------------");
    }
}
