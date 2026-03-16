package task3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainJavaConfig {
	
	public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(PersonService.class);

        userService.save("Mohamed");

        context.close();
    }

}
