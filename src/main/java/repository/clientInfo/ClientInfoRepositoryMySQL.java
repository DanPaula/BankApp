package repository.clientInfo;

import model.ClientInfo;
import model.validation.Notification;
import repository.admin.AdminRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class ClientInfoRepositoryMySQL implements ClientInfoRepository{

    private final Connection connection;
    private final AdminRepository adminRepository;

    public ClientInfoRepositoryMySQL(Connection connection,AdminRepository adminRepository) {
        this.connection = connection;
        this.adminRepository=adminRepository;
    }

    @Override
    public Notification<Boolean> addClientInfo(ClientInfo clientInfo) {
        Notification<Boolean> addClientNotification = new Notification<>();
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("INSERT INTO ClientInfo values (null, ?, ?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, clientInfo.getClientName());
            insertUserStatement.setString(2, clientInfo.getCardNumber());
            insertUserStatement.setString(3, clientInfo.getPersonalNumericalCode());
            insertUserStatement.setString(4, clientInfo.getAddress());
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            addClientNotification.setResult(true);
            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("create client",ts);

        } catch (SQLException e) {
            addClientNotification.setResult(false);
            addClientNotification.addError("Cannot add client: name, CNP, address or card number might be wrong");
        }
        return addClientNotification;
    }

    @Override
    public Notification<Boolean> updateClientInfo(String tfOldClientName, String tfNewClientName, String tfOldAddress, String tfNewAddress, String tfOldCardNumber, String tfNewCardNumber, String tfPersonalNumericalCode) {
        Notification<Boolean> updateClientNotification = new Notification<>();
        try {
            PreparedStatement insertUserStatement = connection
                    .prepareStatement("update ClientInfo set ClientName=?, CardNumber=?, Adress=? where PersonalNumericalCode=?", Statement.RETURN_GENERATED_KEYS);
            insertUserStatement.setString(1, tfNewClientName);
            insertUserStatement.setString(2, tfNewCardNumber);
            insertUserStatement.setString(3, tfNewAddress);
            insertUserStatement.setString(4, tfPersonalNumericalCode);
            insertUserStatement.executeUpdate();

            ResultSet rs = insertUserStatement.getGeneratedKeys();
            rs.next();
            updateClientNotification.setResult(true);

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("update client",ts);

        } catch (SQLException e) {
            updateClientNotification.setResult(false);
            updateClientNotification.addError("Cannot update client: name, CNP, address or card number might be wrong");
        }
        return updateClientNotification;
    }

    @Override
    public Notification<Boolean> viewClientInfo(String tfClientName, String tfPersonalNumericalCode) {
        Notification<Boolean> viewClientNotification = new Notification<>();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("InformationForClient.txt"));

            PreparedStatement readEmployeeStatement = connection
                    .prepareStatement("select* from ClientInfo where ClientName=? and PersonalNumericalCode=?;",Statement.RETURN_GENERATED_KEYS);
            readEmployeeStatement.setString(1, tfClientName);
            readEmployeeStatement.setString(2, tfPersonalNumericalCode);
            ResultSet readResult = readEmployeeStatement.executeQuery();
            while(readResult.next()){
                String name=readResult.getString("ClientName");
                writer.write(name);
                writer.write(" ");
                String address=readResult.getString("Adress");
                writer.write(address);
                writer.write(" ");
                String cardNumber=readResult.getString("CardNumber");
                writer.write(cardNumber);
                writer.write(" ");
                String personalNumericalCode=readResult.getString("PersonalNumericalCode");
                writer.write(personalNumericalCode);

            }
            writer.close();
            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("view client",ts);

            viewClientNotification.setResult(true);

        }catch(SQLException| IOException e){

            viewClientNotification.setResult(false);
            viewClientNotification.addError("name or CNP might be wrong");
        }
        return viewClientNotification;
    }

}
