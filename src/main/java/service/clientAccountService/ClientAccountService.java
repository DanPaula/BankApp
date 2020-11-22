package service.clientAccountService;

public interface ClientAccountService {

    void createAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount,String accountNumber);

    void updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount);

    void deleteAccount(int tfIdentificationNumber,String getTfAccountType);

    void viewAccount(int tfIdentificationNumber);

    void transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount);
}
