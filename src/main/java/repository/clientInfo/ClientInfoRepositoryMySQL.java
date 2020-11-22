package repository.clientInfo;

import model.ClientInfo;
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
    public void addClientInfo(ClientInfo clientInfo) {
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

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("create client",ts);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateClientInfo(String tfOldClientName, String tfNewClientName, String tfOldAddress, String tfNewAddress, String tfOldCardNumber, String tfNewCardNumber, String tfPersonalNumericalCode) {
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

            Date date= new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);
            adminRepository.addEmployeeActivity("update client",ts);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void viewClientInfo(String tfClientName, String tfPersonalNumericalCode) {
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
            System.out.println("Successfully wrote to the file.");
        }catch(SQLException| IOException e){
            e.printStackTrace();
        }
    }

}
