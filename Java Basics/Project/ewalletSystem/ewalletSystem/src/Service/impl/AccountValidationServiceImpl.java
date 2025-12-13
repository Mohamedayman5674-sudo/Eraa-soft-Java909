package Service.impl;

import Exceptions.InvalidInputException;
import Service.AccountValidationService;

public class AccountValidationServiceImpl implements AccountValidationService {

    @Override
    public boolean validateUserName(String username) {

        if (username == null || username.length() < 3) {
            throw new InvalidInputException("Username must be at least 3 characters");
        }

        if (!Character.isUpperCase(username.charAt(0))) {
            throw new InvalidInputException("Username must start with uppercase letter");
        }

        return true;
    }

    @Override
    public boolean validatePassword(String password) {

        if (password == null || password.length() < 8) {
            throw new InvalidInputException("Password must be at least 8 characters");
        }

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else hasSpecial = true;
        }

        if (!(hasUpper && hasLower && hasDigit && hasSpecial)) {
            throw new InvalidInputException(
                    "Password must contain upper, lower, digit and special character"
            );
        }

        return true;
    }

    @Override
    public boolean validateAge(Integer age) {

        if (age == null || age < 18) {
            throw new InvalidInputException("Age must be 18 or older");
        }

        return true;
    }

    @Override
    public boolean validatePhoneNumber(String phoneNumber) {

        if (phoneNumber == null) {
            throw new InvalidInputException("Phone number is required");
        }

        if (!phoneNumber.matches("^(010|011|012|015)[0-9]{8}$")) {
            throw new InvalidInputException("Invalid Egyptian phone number");
        }

        return true;
    }
}