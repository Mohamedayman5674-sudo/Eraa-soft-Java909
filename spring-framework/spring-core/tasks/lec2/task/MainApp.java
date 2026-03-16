package task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import task.UserService;

public class MainApp {
	 public static void main(String[] args) {

	        ApplicationContext context =
	                new ClassPathXmlApplicationContext("task/applicationContext.xml");

	        UserService person =
	                (UserService) context.getBean("personService");

	        person.save("Mohamed");
	        person.update("Mohamed");

	        UserService manager =
	                (UserService) context.getBean("managerService");

	        manager.save("Ali");
	        manager.update("Ali");

	    }

}
