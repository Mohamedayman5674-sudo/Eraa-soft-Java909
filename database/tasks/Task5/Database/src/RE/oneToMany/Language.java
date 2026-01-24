package RE.oneToMany;

import java.util.ArrayList;
import java.util.List;

public class Language {

    private Long id;
    private String name;
    private List<Teacher> teachers;

    public Language(Long id, String name) {
        this.id = id;
        this.name = name;
        this.teachers = new ArrayList<>();
    }


    public void addTeacher(Teacher teacher) {
        if (teacher != null && !teachers.contains(teacher)) {
            teachers.add(teacher);
            teacher.setLanguage(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }
}
