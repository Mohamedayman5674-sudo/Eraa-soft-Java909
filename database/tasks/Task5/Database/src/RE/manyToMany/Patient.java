package RE.manyToMany;

import java.util.HashSet;
import java.util.Set;

public class Patient {

    private Long id;
    private String name;
    private int age;
    private Set<Doctor> doctors;

    public Patient(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.doctors = new HashSet<>();
    }

    public void addDoctor(Doctor doctor) {
        if (doctor != null && !doctors.contains(doctor)) {
            doctors.add(doctor);
            doctor.addPatient(this);
        }
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

