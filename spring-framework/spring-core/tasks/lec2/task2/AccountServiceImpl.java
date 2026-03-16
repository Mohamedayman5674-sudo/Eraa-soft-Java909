package task2;

public class AccountServiceImpl implements AccountService {

	  private UserService userService;

	    public void setUserService(UserService userService) {
	        this.userService = userService;
	    }

	    @Override
	    public void getSavePerson(String name) {

	        userService.save(name);

	    }
}
