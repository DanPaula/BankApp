package service.clientAccountService;


import model.ClientAccount;
import model.builder.ClientAccountBuilder;
import model.builder.ClientInfoBuilder;
import model.builder.UserBuilder;
import repository.clientAccount.ClientAccountRepository;
import repository.clientInfo.ClientInfoRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;


public class ClientAccountServiceMySQL implements ClientAccountService {

    private final ClientAccountRepository clientAccountRepository;

    public ClientAccountServiceMySQL(ClientAccountRepository clientAccountRepository) {
        this.clientAccountRepository = clientAccountRepository;
    }


    @Override
    public void createAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount,String accountNumber) {
        ClientAccountBuilder clientAccountBuilder = new ClientAccountBuilder();
        //long d = System.currentTimeMillis();
        //Date date = new Date(d);
        //Date object
        Date date= new Date();
        //getTime() returns current time in milliseconds
        long time = date.getTime();
        //Passed the milliseconds to constructor of Timestamp class
        Timestamp ts = new Timestamp(time);
        clientAccountRepository.createAccount((clientAccountBuilder.setIdentificationNumber(tfIdentificationNumber).setAccountType(tfAccountType)
                .setMoneyAmount(tfMoneyAmount).setCreationData(ts).setAccountNumber(accountNumber)).build());
    }

    @Override
    public void updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount) {
        ClientAccountBuilder user= new ClientAccountBuilder();
        clientAccountRepository.updateAccount(tfIdentificationNumber,tfAccountType,tfMoneyAmount);
    }

    @Override
    public void deleteAccount(int tfIdentificationNumber,String getTfAccountType) {
        clientAccountRepository.delete(tfIdentificationNumber,getTfAccountType);
    }

    @Override
    public void viewAccount(int tfIdentificationNumber) {
        clientAccountRepository.viewAccount(tfIdentificationNumber);
    }

    @Override
    public void transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount) {
        clientAccountRepository.transferMoney(tfAccountNumberSender,tfAccountNumberReceiver,tfMoneyAmount);
    }
}
