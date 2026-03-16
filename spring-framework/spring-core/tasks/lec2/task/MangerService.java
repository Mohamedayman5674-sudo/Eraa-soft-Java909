package task;

public class MangerService implements UserService {

    @Override
    public void save(String name) {
        System.out.println("Manager Saved: " + name);
    }

    @Override
    public void update(String name) {
        System.out.println("Manager Updated: " + name);
    }

}