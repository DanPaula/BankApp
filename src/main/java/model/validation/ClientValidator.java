package model.validation;

import model.ClientInfo;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientValidator {

    private static final String NAME_VALIDATION_REGEX = "^[\\p{L} .'-]+$";
    private static final int CARD_NUMBER_LENGTH = 6;
    private static final int PERSONAL_NUMERICAL_CODE_LENGTH = 13;

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    private final ClientInfo clientInfo;

    public ClientValidator(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
        errors = new ArrayList<>();
    }

    public boolean validate() {
        validateName(clientInfo.getClientName());
        validateCardNumber(clientInfo.getCardNumber());
        validatePersonalCode(clientInfo.getPersonalNumericalCode());
        return errors.isEmpty();
    }

    private void validatePersonalCode(String personalNumericalCode) {
        if (personalNumericalCode.length() < PERSONAL_NUMERICAL_CODE_LENGTH) {
            errors.add("Personal Numerical Code too short!");
        }
    }

    private void validateCardNumber(String cardNumber) {
        if (cardNumber.length() < CARD_NUMBER_LENGTH) {
            errors.add("Card number too short!");
        }
    }

    private void validateName(String clientName) {
        if (!Pattern.compile(NAME_VALIDATION_REGEX).matcher(clientName).matches()) {
            errors.add("Invalid name!");
        }
    }


}
