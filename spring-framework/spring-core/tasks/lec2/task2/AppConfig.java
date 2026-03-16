package task2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService() {
        return new PersonService();
    }

    @Bean
    public AccountServiceImpl accountService() {

        AccountServiceImpl account = new AccountServiceImpl();
        account.setUserService(personService());

        return account;
    }
}
