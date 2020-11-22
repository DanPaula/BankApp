package repository.clientAccount;

import model.ClientAccount;

public interface ClientAccountRepository {

    void createAccount(ClientAccount build);
    long ClientID(int cardNumber);

    void updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount);

    void delete(int tfIdentificationNumber,String getTfAccountType);

    void viewAccount(int tfIdentificationNumber);

    void transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount);

    void payBill(int tfMoneyAmount, String tfCompanyName,String clientName);
}
