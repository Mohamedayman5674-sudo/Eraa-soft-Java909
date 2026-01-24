package RE.oneToMany;

public class Teacher {

    private Long id;
    private String name;
    private double salary;
    private Language language;

    public Teacher(Long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setLanguage(Language language) {
        this.language = language;
        if (language != null && !language.getTeachers().contains(this)) {
            language.getTeachers().add(this);
        }
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

    public Language getLanguage() {
        return language;
    }
}
