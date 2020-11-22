package model.builder;

import model.ClientAccount;

import java.sql.Timestamp;


public class ClientAccountBuilder {

    private ClientAccount clientAccount;

    public ClientAccountBuilder() {
        clientAccount = new ClientAccount();
    }

    public ClientAccountBuilder setIdentificationNumber(int identificationNumber) {
        clientAccount.setIdentificationNumber(identificationNumber);
        return this;
    }

    public ClientAccountBuilder setAccountType(String accountType) {
        clientAccount.setAccountType(accountType);
        return this;
    }

    public ClientAccountBuilder setMoneyAmount(int moneyAmount) {
        clientAccount.setMoneyAmount(moneyAmount);
        return this;
    }

    public ClientAccountBuilder setId(Long id) {
        clientAccount.setId(id);
        return this;
    }

    public ClientAccountBuilder setCreationData(Timestamp creationData){
        clientAccount.setCreationData(creationData);
        return this;
    }

    public ClientAccountBuilder setAccountNumber(String accountNumber){
        clientAccount.setAccountNumber(accountNumber);
        return this;
    }

    public ClientAccount build() {
        return clientAccount;
    }
}