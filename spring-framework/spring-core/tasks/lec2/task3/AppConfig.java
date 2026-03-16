package task3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

	 @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
	    @Scope("prototype")
	    public PersonService personService() {
	        return new PersonService();
	    }
	
}
