package task3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	  public static void main(String[] args) {

	        ClassPathXmlApplicationContext context =
	                new ClassPathXmlApplicationContext("applicationContext.xml");

	        UserService userService = context.getBean("personService", UserService.class);

	        userService.save("Mohamed");

	        context.close();
	    }
	
}
