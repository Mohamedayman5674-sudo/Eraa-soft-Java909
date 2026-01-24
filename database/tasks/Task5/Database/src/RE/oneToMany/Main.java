package RE.oneToMany;


public class Main {
    public static void main(String[] args) {
        Language english = new Language(1L, "English");

        Teacher teacher1 = new Teacher(101L, "Ahmed", 8000);
        Teacher teacher2 = new Teacher(102L, "Sara", 9000);

        english.addTeacher(teacher1);
        english.addTeacher(teacher2);

        System.out.println("Language: " + english.getName());
        for (Teacher t : english.getTeachers()) {
            System.out.println(t.getName() + " teaches " + t.getLanguage().getName());
        }
    }
}