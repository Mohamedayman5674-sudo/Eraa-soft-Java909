package task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
        new ClassPathXmlApplicationContext("task2/account-context.xml");

        AccountService accountService =
        (AccountService) context.getBean("accountService");

        accountService.getSavePerson("Mohamed");

    }
}