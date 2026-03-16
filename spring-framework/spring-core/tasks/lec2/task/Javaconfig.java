package task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import task.Appconfig;
import task.UserService;

public class Javaconfig {
	 public static void main(String[] args) {

	        ApplicationContext context =
	                new AnnotationConfigApplicationContext(Appconfig.class);

	        UserService person = context.getBean("personService", UserService.class);
	        person.save("Mohamed");
	        person.update("Mohamed");

	        UserService manager = context.getBean("mangerService", UserService.class);
	        manager.save("Ali");
	        manager.update("Ali");

	    }
}
