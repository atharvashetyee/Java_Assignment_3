import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple class to represent a patient's data.
 */
class Patient {
    int patientId;
    String name;
    String diagnosis;
    int daysAdmitted;

    public Patient(int patientId, String name, String diagnosis, int daysAdmitted) {
        this.patientId = patientId;
        this.name = name;
        this.diagnosis = diagnosis;
        this.daysAdmitted = daysAdmitted;
    }

    @Override
    public String toString() {
        return "ID: " + patientId + ", Name: " + name + ", Diagnosis: " + diagnosis + ", Days Admitted: " + daysAdmitted;
    }
}

/**
 * Manages the collection of patients and user interaction.
 */
public class PatientDatabase {
    ArrayList<Patient> patientList = new ArrayList<>();

    // a. Add a new patient
    public void addPatient(Patient patient) {
        patientList.add(patient);
        System.out.println("SUCCESS: Patient '" + patient.name + "' has been added.");
    }

    // b. Remove a patient by ID
    public void removePatient(int patientId) {
        boolean removed = patientList.removeIf(patient -> patient.patientId == patientId);
        if (removed) {
            System.out.println("SUCCESS: Patient with ID " + patientId + " has been removed.");
        } else {
            System.out.println("ERROR: Patient with ID " + patientId + " not found.");
        }
    }

    // c. Find patients by diagnosis
    public ArrayList<Patient> findPatientsByDiagnosis(String diagnosis) {
        ArrayList<Patient> foundPatients = new ArrayList<>();
        for (Patient patient : patientList) {
            if (patient.diagnosis.equalsIgnoreCase(diagnosis)) {
                foundPatients.add(patient);
            }
        }
        return foundPatients;
    }
    
    // d. Find patients admitted longer than a number of days
    public ArrayList<Patient> findPatientsAdmittedLongerThan(int days) {
        ArrayList<Patient> longStayPatients = new ArrayList<>();
        for (Patient patient : patientList) {
            if (patient.daysAdmitted > days) {
                longStayPatients.add(patient);
            }
        }
        return longStayPatients;
    }
    
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientDatabase db = new PatientDatabase();

        while (true) {+
            System.out.println("\n===== Patient Management System =====");
            System.out.println("1. Add a new patient");
            System.out.println("2. Remove a patient by ID");
            System.out.println("3. Find patients by diagnosis");
            System.out.println("4. Find patients admitted for more than 'X' days");
            System.out.println("5. Display all patients");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();
                    System.out.print("Enter Days Admitted: ");
                    int days = scanner.nextInt();
                    db.addPatient(new Patient(id, name, diagnosis, days));
                    break;

                case 2:
                    System.out.print("Enter Patient ID to remove: ");
                    int removeId = scanner.nextInt();
                    db.removePatient(removeId);
                    break;

                case 3:
                    System.out.print("Enter Diagnosis to find: ");
                    String findDiagnosis = scanner.nextLine();
                    ArrayList<Patient> patientsByDiag = db.findPatientsByDiagnosis(findDiagnosis);
                    System.out.println("--- Search Results ---");
                    break;

                case 4:
                    System.out.print("Find patients admitted longer than (days): ");
                    int findDays = scanner.nextInt();
                    ArrayList<Patient> longStayers = db.findPatientsAdmittedLongerThan(findDays);
                    System.out.println("--- Search Results ---");
                    
                    break;

               
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}