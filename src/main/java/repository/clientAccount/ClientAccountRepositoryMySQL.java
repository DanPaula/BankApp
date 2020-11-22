package repository.clientAccount;

import model.ClientAccount;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

import static database.Constants.Tables.USER;

public class ClientAccountRepositoryMySQL implements ClientAccountRepository{

    private final Connection connection;

    public ClientAccountRepositoryMySQL(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createAccount(ClientAccount clientAccount) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    @Override
    public void updateAccount(int tfIdentificationNumber, String tfAccountType, int tfMoneyAmount) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("update ClientAccount set AccountType = ?, MoneyAmount = ? where IdentificationNumber=?;", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, tfAccountType);
            insertUserStatement.setInt(2,tfMoneyAmount);
            insertUserStatement.setInt(3,tfIdentificationNumber);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int tfIdentificationNumber,String TfAccountType) {
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("delete from ClientAccount where IdentificationNumber=? and AccountType = ?;", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setInt(1, tfIdentificationNumber);
            insertUserStatement.setString(2, TfAccountType);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewAccount(int tfIdentificationNumber) {
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
            writer.close();
            System.out.println("Successfully wrote to the file.");
        }catch(SQLException| IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void transferMoney(String tfAccountNumberSender, String tfAccountNumberReceiver,int tfMoneyAmount) {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
