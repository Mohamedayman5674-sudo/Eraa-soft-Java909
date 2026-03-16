package task;

public class PersonService implements UserService {

    @Override
    public void save(String name) {
        System.out.println("Person Saved: " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("Person Updated: " + name);
    }

}
