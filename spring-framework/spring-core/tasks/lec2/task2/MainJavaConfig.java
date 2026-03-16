package task2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import task2.AccountService;
public class MainJavaConfig {
	 public static void main(String[] args) {

	        ApplicationContext context =
	                new AnnotationConfigApplicationContext(AppConfig.class);

	        AccountService accountService =
	                context.getBean("accountService", AccountService.class);

	        accountService.getSavePerson("Ali");

	    }
}
