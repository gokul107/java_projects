package HospitalAppointment;

public class Patient {

    private int patientId;
    private String patientName;
    private int age;
    private String disease;

    public Patient(int patientId, String patientName, int age, String disease) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.age = age;
        this.disease = disease;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getAge() {
        return age;
    }

    public String getDisease() {
        return disease;
    }

    public void displayPatient() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Patient Name: " + patientName);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
    }
}
