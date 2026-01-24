package RE.manyToMany;


public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor(1L, "Dr. Ahmed", 15000);
        Doctor doctor2 = new Doctor(2L, "Dr. Sara", 17000);

        Patient patient1 = new Patient(101L, "Ali", 25);
        Patient patient2 = new Patient(102L, "Mona", 30);

        doctor1.addPatient(patient1);
        doctor1.addPatient(patient2);

        doctor2.addPatient(patient1);

        System.out.println("Patients of " + doctor1.getName());
        for (Patient p : doctor1.getPatients()) {
            System.out.println("- " + p.getName());
        }

        System.out.println("\nDoctors of " + patient1.getName());
        for (Doctor d : patient1.getDoctors()) {
            System.out.println("- " + d.getName());
        }
    }
}