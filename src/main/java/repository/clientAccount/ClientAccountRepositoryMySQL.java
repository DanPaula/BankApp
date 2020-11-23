package repository.clientAccount;

import model.ClientAccount;
import model.User;
import model.validation.Notification;
import repository.admin.AdminRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

import static database.Constants.Tables.USER;

public class ClientAccountRepositoryMySQL implements ClientAccountRepository{

    private final Connection connection;
    private final AdminRepository adminRepository;

    public ClientAccountRepositoryMySQL(Connection connection,AdminRepository adminRepository) {
        this.connection = connection;
        this.adminRepository=adminRepository;
    }

    @Override
    public Notification<Boolean> createAccount(ClientAccount clientAccount) {
        Notification<Boolean> createAccountNotification = new Notification<>();
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO ClientAccount values (null,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setLong(1, ClientID(clientAccount.getIdentificationNumber()));
            insertUserStatement.setInt(2, clientAccount.getIdentificationNumber());
            insertUserStatement.setString(3, clientAccount.getAccountType());
            insertUserStatement.setInt(4, clientAccount.getMoneyAmount());
            insertUserStatement.setTimestamp(5, clientAccount.getCreationData());
            insertUserStatement.setString(6, clientAccount.getAccountNumber());
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            createAccountNotification.setResult(true);

            java.util.Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("create account",ts);

        } catch (SQLException e) {
            createAccountNotification.setResult(false);
            createAccountNotification.addError("Cannot create account: identification number, account type, money amount or account number might be wrong");
        }
        return createAccountNotification;
    }

    @Override
    public long ClientID(int cardNumber) {
        long clientId=0;
        try {
            PreparedStatement findStatement = connection
                    .prepareStatement("Select id from ClientInfo where CardNumber = ?");
            findStatement.setString(1, String.valueOf(cardNumber));
            ResultSet findResultSet = findStatement.executeQuery();
            findResultSet.next();
            clientId=findResultSet.getLong("id");

        } catch (SQLException e) {

        }
        return clientId;
    }

    public long findClientByName(String name) {
        long clientId=0;
        try {
            PreparedStatement findStatement = connection
                    .prepareStatement("Select id from ClientInfo where name = ?");
            findStatement.setString(1, name);
            ResultSet findResultSet = findStatement.executeQuery();
            findResultSet.next();
            clientId=findResultSet.getLong("id");
        } catch (SQLException e) {

        }
        return clientId;
    }

    @Override
    public Notification<Boolean> updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount) {
        Notification<Boolean> updateAccountNotification = new Notification<>();
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("update ClientAccount set AccountType = ?, MoneyAmount = ? where IdentificationNumber=?;", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, tfAccountType);
            insertUserStatement.setInt(2,tfMoneyAmount);
            insertUserStatement.setInt(3,tfIdentificationNumber);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            updateAccountNotification.setResult(true);

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("update account",ts);

        } catch (SQLException e) {
            updateAccountNotification.setResult(false);
            updateAccountNotification.addError("Cannot update account: identification number, account type or money amount might be wrong");
        }
        return updateAccountNotification;
    }

    @Override
    public Notification<Boolean> delete(int tfIdentificationNumber,String TfAccountType) {
        Notification<Boolean> deleteAccountNotification = new Notification<>();
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("delete from ClientAccount where IdentificationNumber=? and AccountType = ?;", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setInt(1, tfIdentificationNumber);
            insertUserStatement.setString(2, TfAccountType);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            deleteAccountNotification.setResult(true);

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("delete account",ts);

        } catch (SQLException e) {
            deleteAccountNotification.setResult(false);
            deleteAccountNotification.addError("Cannot delete account: identification number or account type might be wrong");
        }
        return deleteAccountNotification;
    }

    @Override
    public Notification<Boolean> viewAccount(int tfIdentificationNumber) {
        Notification<Boolean> viewAccountNotification = new Notification<>();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("AccountInformationClient.txt"));

            PreparedStatement readEmployeeStatement = connection
                    .prepareStatement("select* from ClientAccount where IdentificationNumber=? ;",Statement.RETURN_GENERATED_KEYS);
            readEmployeeStatement.setInt(1, tfIdentificationNumber);
            ResultSet readResult = readEmployeeStatement.executeQuery();
            while(readResult.next()){
                String identificationNumber=readResult.getString("IdentificationNumber");
                writer.write(identificationNumber);
                writer.write(" ");
                String accountType=readResult.getString("AccountType");
                writer.write(accountType);
                writer.write(" ");
                String moneyAmount=readResult.getString("MoneyAmount");
                writer.write(moneyAmount);
                writer.write(" ");
                Timestamp creationDate=readResult.getTimestamp("CreationDate");
                writer.write(String.valueOf(creationDate));
                writer.write("\n");

            }
            viewAccountNotification.setResult(true);
            writer.close();
            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("view account",ts);
            System.out.println("Successfully wrote to the file.");
        }catch(SQLException| IOException e){
            viewAccountNotification.setResult(false);
            viewAccountNotification.addError("Cannot view account: identification number might be wrong");
        }
        return viewAccountNotification;
    }

    @Override
    public Notification<Boolean> transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount) {
        Notification<Boolean> transferMoneyNotification = new Notification<>();
        try {

            PreparedStatement senderMoneyStatement = connection
                    .prepareStatement("select MoneyAmount from ClientAccount where AccountNumber=?;", Statement.RETURN_GENERATED_KEYS);
            senderMoneyStatement.setString(1, tfAccountNumberSender);
            ResultSet senderResultSet = senderMoneyStatement.executeQuery();
            senderResultSet.next();

            PreparedStatement receiverMoneyStatement = connection
                    .prepareStatement("select MoneyAmount from ClientAccount where AccountNumber=?;", Statement.RETURN_GENERATED_KEYS);
            receiverMoneyStatement.setString(1, tfAccountNumberReceiver);
            ResultSet receiverResultSet = receiverMoneyStatement.executeQuery();
            receiverResultSet.next();


            int moneySender = Integer.parseInt(senderResultSet.getString("MoneyAmount"));
            int moneyReceiver = Integer.parseInt(receiverResultSet.getString("MoneyAmount"));
            moneyReceiver = moneyReceiver + tfMoneyAmount;
            moneySender = moneySender - tfMoneyAmount;

            PreparedStatement updateMoneySenderStatement = connection
                    .prepareStatement("update ClientAccount set MoneyAmount = ? where AccountNumber=?;", Statement.RETURN_GENERATED_KEYS);
            updateMoneySenderStatement.setInt(1, moneySender);
            updateMoneySenderStatement.setString(2,tfAccountNumberSender);
            updateMoneySenderStatement.executeUpdate();

            PreparedStatement updateMoneyReceiverStatement = connection
                    .prepareStatement("update ClientAccount set MoneyAmount = ? where AccountNumber=?;", Statement.RETURN_GENERATED_KEYS);
            updateMoneyReceiverStatement.setInt(1, moneyReceiver);
            updateMoneyReceiverStatement.setString(2,tfAccountNumberReceiver);
            updateMoneyReceiverStatement.executeUpdate();

            transferMoneyNotification.setResult(true);

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("transfer money",ts);

        } catch (SQLException e) {
            transferMoneyNotification.setResult(false);
            transferMoneyNotification.addError("Cannot view account: identification number might be wrong");
        }
        return transferMoneyNotification;
    }

    @Override
    public Notification<Boolean> payBill(int tfMoneyAmount, String tfCompanyName,String clientName) {
        Notification<Boolean> payBillNotification = new Notification<>();
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("Bill.txt"));

            PreparedStatement findIdByNameStatement = connection
                    .prepareStatement("select id from ClientInfo where ClientName=?;", Statement.RETURN_GENERATED_KEYS);
            findIdByNameStatement.setString(1, clientName);
            ResultSet findIdByNameResultSet = findIdByNameStatement.executeQuery();
            findIdByNameResultSet.next();
            long id = findIdByNameResultSet.getLong("id");

            PreparedStatement findMoneyByForeignKeyMoneyStatement = connection
                    .prepareStatement("select MoneyAmount from ClientAccount where client_id=?;", Statement.RETURN_GENERATED_KEYS);
            findMoneyByForeignKeyMoneyStatement.setLong(1, id);
            ResultSet findMoneyResultSet = findMoneyByForeignKeyMoneyStatement.executeQuery();
            findMoneyResultSet.next();
            int availableMoney = findMoneyResultSet.getInt("MoneyAmount");
            //long client_id = findMoneyResultSet.getLong("client_id");
            availableMoney = availableMoney - tfMoneyAmount;

            PreparedStatement updateMoneyStatement = connection
                    .prepareStatement("update ClientAccount set MoneyAmount = ? where client_id=?;", Statement.RETURN_GENERATED_KEYS);
            updateMoneyStatement.setInt(1, availableMoney);
            updateMoneyStatement.setLong(2, id);
            updateMoneyStatement.executeUpdate();

            billPayment(id,tfCompanyName);
            payBillNotification.setResult(true);

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("pay bill",ts);


        } catch (SQLException|IOException e) {
            payBillNotification.setResult(false);
            payBillNotification.addError("Cannot pay bill something might be wrong");
        }
        return payBillNotification;
    }

    public void billPayment(long client_id , String companyName) {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("Bill.txt"));

            PreparedStatement billStatement = connection
                    .prepareStatement("select* from ClientAccount where client_id=? ;",Statement.RETURN_GENERATED_KEYS);
            billStatement.setLong(1, client_id);
            ResultSet readResult = billStatement.executeQuery();
            while(readResult.next()){
                writer.write(companyName);
                writer.write("\n");
                String identificationNumber=readResult.getString("IdentificationNumber");
                writer.write(identificationNumber);
                writer.write(" ");
                String accountType=readResult.getString("AccountType");
                writer.write(accountType);
                writer.write(" ");
                String moneyAmount=readResult.getString("MoneyAmount");
                writer.write(moneyAmount);
                writer.write(" ");
                Timestamp creationDate=readResult.getTimestamp("CreationDate");
                writer.write(String.valueOf(creationDate));
                writer.write("\n");

            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch(SQLException| IOException e){
            e.printStackTrace();
        }
    }

}
