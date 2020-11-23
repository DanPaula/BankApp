package model.validation;

import model.ClientAccount;
import model.ClientInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ClientAccountValidator {

    private static final String ACCOUNT_TYPE_REGEX = "^[A-Za-z ]+$";
    private static final int IDENTIFICATION_LENGTH = 6;
    private static final String MONEY_REGEX= "^\\d+$";

    public List<String> getErrors() {
        return errors;
    }

    private final List<String> errors;

    private final ClientAccount clientAccount;

    public ClientAccountValidator(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
        errors = new ArrayList<>();
    }

    public boolean validate() {
        validateIdentificationNumber(clientAccount.getIdentificationNumber());
        validateAccountType(clientAccount.getAccountType());
        validateMoneyAmount(clientAccount.getMoneyAmount());
        return errors.isEmpty();
    }

    private void validateIdentificationNumber(int identificationNumber) {
        if (Integer.toString(identificationNumber).length() < IDENTIFICATION_LENGTH) {
            errors.add("Identification Number too short!");
        }
    }

    private void validateAccountType(String accountType) {
        if (!Pattern.compile(ACCOUNT_TYPE_REGEX).matcher(accountType).matches()) {
            errors.add("Invalid account type!");
        }
    }

    private void validateMoneyAmount(int moneyAmount) {
        if (!Pattern.compile(MONEY_REGEX).matcher(Integer.toString(moneyAmount)).matches()) {
            errors.add("Invalid money amount!");
        }
    }

}
