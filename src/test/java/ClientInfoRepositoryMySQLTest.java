import database.DBConnectionFactory;
import model.ClientInfo;
import model.builder.ClientInfoBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.Cache;
import repository.admin.AdminRepositoryMySQL;
import repository.clientInfo.ClientInfoRepository;
import repository.clientInfo.ClientInfoRepositoryCacheDecorator;
import repository.clientInfo.ClientInfoRepositoryMySQL;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientInfoRepositoryMySQLTest {
    private static ClientInfoRepository clientInfoRepository;

    @BeforeClass
    public static void setupClass(){
        clientInfoRepository = new ClientInfoRepositoryCacheDecorator(
                new ClientInfoRepositoryMySQL(
                        new DBConnectionFactory().getConnectionWrapper(true).getConnection(),
                        new AdminRepositoryMySQL(new DBConnectionFactory().getConnectionWrapper(true).getConnection())
                ),
                new Cache<>()
        );
    }

    @Test
    public void addClientInfo() throws Exception{
        ClientInfo clientInfo = new ClientInfoBuilder()
                .setClientName("Ionescu Raluca")
                .setCardnumber("234509")
                .setPersonalNumericalCode("1234567890123")
                .setAdress("str. Macinului, nr 12")
                .setId((long)1)
                .build();
        assertTrue(clientInfoRepository.addClientInfo(clientInfo).getResult());
    }

    @Test
    public void addClientInfo1() throws Exception{
        ClientInfo clientInfo = new ClientInfoBuilder()
                .setClientName("Ionescu Maria")
                .setCardnumber("234508")
                .setPersonalNumericalCode("1234567890134")
                .setAdress("str. Macinului, nr 13")
                .setId((long)2)
                .build();
        assertTrue(clientInfoRepository.addClientInfo(clientInfo).getResult());
    }

    @Test
    public void updateClientInfo() throws Exception{
        assertTrue(clientInfoRepository.updateClientInfo("Ionescu Raluca","Ionescu Maria","str. Macinului, nr 14","str. Macinului, nr 24","234509","238908","1234567890145").getResult());
    }

    @Test
    public void deleteClientInfo() throws Exception{
        assertTrue(clientInfoRepository.viewClientInfo("Ionescu Maria","1234567890134").getResult());
    }


}
