import java.util.*;
class Patient {
    String name, gender;
    int age;
    static int idCounter = 100;
    int id;

    Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = idCounter++;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender);
    }
}

class Appointment {
    int patientId;
    String doctorName, date;

    Appointment(int patientId, String doctorName, String date) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
    }

    public void display() {
        System.out.println("Appointment with Dr. " + doctorName + " on " + date + " for Patient ID: " + patientId);
    }
}

class Staff {
    String name, role;

    Staff(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void display() {
        System.out.println("Name: " + name + ", Role: " + role);
    }
}

class InventoryItem {
    String name;
    int quantity;

    InventoryItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void display() {
        System.out.println("Item: " + name + ", Quantity: " + quantity);
    }
}

public class HospitalManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Patient> patients = new ArrayList<>();
    static List<Appointment> appointments = new ArrayList<>();
    static List<Staff> staffList = new ArrayList<>();
    static List<InventoryItem> inventory = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View EHR");
            System.out.println("4. Billing");
            System.out.println("5. Staff Management");
            System.out.println("6. Inventory Management");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> registerPatient();
                case 2 -> scheduleAppointment();
                case 3 -> viewEHR();
                case 4 -> billing();
                case 5 -> manageStaff();
                case 6 -> manageInventory();
                case 0 -> {
                    System.out.println("Exiting... Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    static void registerPatient() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();
        Patient p = new Patient(name, age, gender);
        patients.add(p);
        System.out.println("Patient Registered. \n ID: " + p.id);
    }

    static void scheduleAppointment() {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();
        System.out.print("Enter Date (dd-mm-yyyy): ");
        String date = sc.nextLine();
        appointments.add(new Appointment(pid, doctor, date));
        System.out.println("Appointment Scheduled!");
    }

    static void viewEHR() {
        System.out.print("Enter Patient ID to view EHR: ");
        int pid = sc.nextInt();
        sc.nextLine();
        for (Patient p : patients) {
            if (p.id == pid) {
                System.out.println("EHR for Patient ID: " + pid);
                p.display();
                System.out.println("Blood Pressure: 120/80\nAllergies: None\nLast Visit: 01-06-2025");
                return;
            }
        }
        System.out.println("Patient not found!");
    }

    static void billing() {
        System.out.print("Enter Patient ID: ");
        int pid = sc.nextInt();
        System.out.println("Billing Summary for Patient ID: " + pid);
        System.out.println("Consultation: $500\nMedicines: $1200\nTotal: $1700");
    }

    static void manageStaff() {
        System.out.print("Enter Staff Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Role: ");
        String role = sc.nextLine();
        staffList.add(new Staff(name, role));
        System.out.println("Staff added!");
        System.out.println("Current Staff List:");
        for (Staff s : staffList) s.display();
    }

    static void manageInventory() {
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = sc.nextInt();
        inventory.add(new InventoryItem(name, qty));
        System.out.println("Inventory updated!");
        System.out.println("Current Inventory:");
        for (InventoryItem item : inventory) item.display();
    }
}
