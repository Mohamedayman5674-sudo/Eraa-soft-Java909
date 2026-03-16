package task2;

public class PersonService implements UserService {
	
	 @Override
	    public void save(String name) {
	        System.out.println("Person Saved: " + name);
	    }

}
