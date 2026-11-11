package StudentManagementSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class StudentFileService {

    private static final String FILE_NAME = "students.dat";

    // Save Students to File
    public void saveStudents(HashMap<Integer, Student> students) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(students);

            System.out.println("Students saved to file successfully!");

        } catch (IOException e) {

            System.out.println("Error saving students: " + e.getMessage());
        }
    }

    // Load Students from File
    @SuppressWarnings("unchecked")
    public HashMap<Integer, Student> loadStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(file))) {

            Object obj = ois.readObject();

            if (obj instanceof HashMap<?, ?>) {

                return (HashMap<Integer, Student>) obj;
            }

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error loading students: " + e.getMessage());
        }

        return new HashMap<>();
    }
}
