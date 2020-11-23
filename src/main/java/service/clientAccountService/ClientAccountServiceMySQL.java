package service.clientAccountService;


import model.ClientAccount;
import model.ClientInfo;
import model.builder.ClientAccountBuilder;
import model.builder.ClientInfoBuilder;
import model.validation.ClientAccountValidator;
import model.validation.ClientValidator;
import model.validation.Notification;
import repository.clientAccount.ClientAccountRepository;

import java.sql.Timestamp;
import java.util.Date;


public class ClientAccountServiceMySQL implements ClientAccountService {

    private final ClientAccountRepository clientAccountRepository;

    public ClientAccountServiceMySQL(ClientAccountRepository clientAccountRepository) {
        this.clientAccountRepository = clientAccountRepository;
    }


    @Override
    public Notification<Boolean> createAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount, String accountNumber) {
        Notification<Boolean> createAccountNotification = new Notification<>();
        ClientAccount account = new ClientAccountBuilder().setIdentificationNumber(tfIdentificationNumber).setAccountNumber(tfAccountType).setAccountType(tfAccountType).setMoneyAmount(tfMoneyAmount).setAccountNumber(accountNumber).build();
        ClientAccountValidator clientValidator =new ClientAccountValidator(account);
        boolean clientValid = clientValidator.validate();

        if(!clientValid){
            clientValidator.getErrors().forEach(createAccountNotification::addError);
            createAccountNotification.setResult(Boolean.FALSE);
        }else{
            ClientAccountBuilder clientAccountBuilder = new ClientAccountBuilder();

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            clientAccountRepository.createAccount((clientAccountBuilder.setIdentificationNumber(tfIdentificationNumber).setAccountType(tfAccountType)
                    .setMoneyAmount(tfMoneyAmount).setCreationData(ts).setAccountNumber(accountNumber)).build());
        }
        return createAccountNotification;
    }

    @Override
    public Notification<Boolean> updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount) {

        Notification<Boolean> updateAccountNotification = new Notification<>();
        ClientAccount account = new ClientAccountBuilder().setIdentificationNumber(tfIdentificationNumber).setAccountNumber(tfAccountType).setAccountType(tfAccountType).setMoneyAmount(tfMoneyAmount).setAccountNumber("default account number").build();
        ClientAccountValidator clientValidator =new ClientAccountValidator(account);
        boolean clientValid = clientValidator.validate();
        if(!clientValid){
            clientValidator.getErrors().forEach(updateAccountNotification::addError);
            updateAccountNotification.setResult(Boolean.FALSE);
        }else{
            clientAccountRepository.updateAccount(tfIdentificationNumber,tfAccountType,tfMoneyAmount);
        }
        return updateAccountNotification;
    }

    @Override
    public Notification<Boolean> deleteAccount(int tfIdentificationNumber,String tfAccountType) {
        Notification<Boolean> deleteAccountNotification = new Notification<>();
        ClientAccount account = new ClientAccountBuilder().setIdentificationNumber(tfIdentificationNumber).setAccountNumber("default").setAccountType(tfAccountType).setMoneyAmount(234).setAccountNumber("default account number").build();
        ClientAccountValidator clientValidator =new ClientAccountValidator(account);
        boolean clientValid = clientValidator.validate();

        if(!clientValid){
            clientValidator.getErrors().forEach(deleteAccountNotification::addError);
            deleteAccountNotification.setResult(Boolean.FALSE);
        }else{
            clientAccountRepository.delete(tfIdentificationNumber,tfAccountType);
        }
        return deleteAccountNotification;
    }

    @Override
    public Notification<Boolean> viewAccount(int tfIdentificationNumber) {
        Notification<Boolean> viewAccountNotification = new Notification<>();
        ClientAccount account = new ClientAccountBuilder().setIdentificationNumber(tfIdentificationNumber).setAccountNumber("default").setAccountType("Default").setMoneyAmount(234).setAccountNumber("default account number").build();
        ClientAccountValidator clientValidator =new ClientAccountValidator(account);
        boolean clientValid = clientValidator.validate();

        if(!clientValid){
            clientValidator.getErrors().forEach(viewAccountNotification::addError);
            viewAccountNotification.setResult(Boolean.FALSE);
        }else{
            clientAccountRepository.viewAccount(tfIdentificationNumber);
        }
        return viewAccountNotification;
    }

    @Override
    public Notification<Boolean> transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount) {
        Notification<Boolean> transferMoneyNotification = new Notification<>();
        ClientAccount account = new ClientAccountBuilder().setIdentificationNumber(123456).setAccountNumber(tfAccountNumberSender).setAccountType("Default").setMoneyAmount(tfMoneyAmount).setAccountNumber("default account number").build();
        ClientAccountValidator clientValidator =new ClientAccountValidator(account);
        boolean clientValid = clientValidator.validate();

        if(!clientValid){
            clientValidator.getErrors().forEach(transferMoneyNotification::addError);
            transferMoneyNotification.setResult(Boolean.FALSE);
        }else{
            clientAccountRepository.transferMoney(tfAccountNumberSender,tfAccountNumberReceiver,tfMoneyAmount);
        }
        return transferMoneyNotification;
    }

    @Override
    public Notification<Boolean> payBills(int tfMoneyAmount, String tfCompanyName,String clientName) {
        Notification<Boolean> payBillsNotification = new Notification<>();
        ClientAccount account = new ClientAccountBuilder().setIdentificationNumber(123456).setAccountNumber("default").setAccountType("Default type").setMoneyAmount(tfMoneyAmount).setAccountNumber("default account number").build();
        ClientAccountValidator clientValidator =new ClientAccountValidator(account);
        boolean clientValid = clientValidator.validate();

        if(!clientValid){
            clientValidator.getErrors().forEach(payBillsNotification::addError);
            payBillsNotification.setResult(Boolean.FALSE);
        }else{
            clientAccountRepository.payBill(tfMoneyAmount,tfCompanyName,clientName);
        }
        return payBillsNotification;
    }
}
