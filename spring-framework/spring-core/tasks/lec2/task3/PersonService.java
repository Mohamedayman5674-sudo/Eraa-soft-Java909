package task3;

public class PersonService implements UserService {
	
	 public PersonService() {
	        System.out.println("PersonService Constructor Called");
	    }

	    @Override
	    public void save(String name) {
	        System.out.println("Saving user: " + name);
	    }

	    // init method
	    public void initMethod() {
	        System.out.println("PersonService Init Method");
	    }

	    // destroy method
	    public void destroyMethod() {
	        System.out.println("PersonService Destroy Method");
	    }

}
