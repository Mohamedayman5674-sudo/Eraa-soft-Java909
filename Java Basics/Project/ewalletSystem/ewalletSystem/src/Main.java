import Service.ApplicationService;
import Service.impl.EWalletServiceImpl;

public class Main {
    public static void main(String[] args) {

        ApplicationService applicationService = new EWalletServiceImpl();
        applicationService.startApp();
    }
}