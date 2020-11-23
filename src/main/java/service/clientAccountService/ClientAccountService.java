package service.clientAccountService;

import model.validation.Notification;

public interface ClientAccountService {

    Notification<Boolean> createAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount, String accountNumber);

    Notification<Boolean> updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount);

    Notification<Boolean> deleteAccount(int tfIdentificationNumber,String getTfAccountType);

    Notification<Boolean> viewAccount(int tfIdentificationNumber);

    Notification<Boolean> transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount);

    Notification<Boolean> payBills(int tfMoneyAmount, String tfCompanyName,String clientName);
}
