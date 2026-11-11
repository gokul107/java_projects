package HospitalAppointment;
import java.util.ArrayList;
import java.time.LocalTime;

public class Doctor {

    private int doctorId;
    private String doctorName;
    private String specialization;

    private ArrayList<LocalTime> availableSlots = new ArrayList<>();

    public Doctor(int doctorId, String doctorName, String specialization) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;

        availableSlots.add(LocalTime.of(10, 0));
        availableSlots.add(LocalTime.of(11, 0));
        availableSlots.add(LocalTime.of(12, 0));
        availableSlots.add(LocalTime.of(14, 0));
        availableSlots.add(LocalTime.of(15, 0));
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public ArrayList<LocalTime> getAvailableSlots() {
        return availableSlots;
    }

    public void displayDoctor() {
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Doctor Name: " + doctorName);
        System.out.println("Specialization: " + specialization);
    }
}
