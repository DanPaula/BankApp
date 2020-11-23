package repository.clientAccount;

import model.ClientAccount;
import model.validation.Notification;

public interface ClientAccountRepository {

    Notification<Boolean> createAccount(ClientAccount build);
    long ClientID(int cardNumber);

    Notification<Boolean> updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount);

    Notification<Boolean> delete(int tfIdentificationNumber,String getTfAccountType);

    Notification<Boolean> viewAccount(int tfIdentificationNumber);

    Notification<Boolean> transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount);

    Notification<Boolean> payBill(int tfMoneyAmount, String tfCompanyName,String clientName);
}
