package task;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import task.PersonService;
import task.MangerService;

@Configuration
public class Appconfig {

	 @Bean
	    public PersonService personService() {
	        return new PersonService();
	    }

	    @Bean
	    public MangerService mangerService() {
	        return new MangerService();
	    }
	
}
