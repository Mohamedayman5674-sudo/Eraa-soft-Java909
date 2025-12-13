package Service;

public interface AccountValidationService {
    boolean validateUserName(String username);

    boolean validatePassword(String password);

    boolean validateAge(Integer age);

    boolean validatePhoneNumber(String phoneNumber);

}
