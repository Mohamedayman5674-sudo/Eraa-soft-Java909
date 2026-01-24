package RE.manyToMany;

import java.util.HashSet;
import java.util.Set;

public class Doctor {

    private Long id;
    private String name;
    private double salary;
    private Set<Patient> patients;

    public Doctor(Long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.patients = new HashSet<>();
    }

    public void addPatient(Patient patient) {
        if (patient != null && !patients.contains(patient)) {
            patients.add(patient);
            patient.addDoctor(this);
        }
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
