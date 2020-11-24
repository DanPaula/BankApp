import model.ClientInfo;
import model.builder.ClientInfoBuilder;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import repository.Cache;
import repository.clientInfo.ClientInfoRepository;
import repository.clientInfo.ClientInfoRepositoryCacheDecorator;
import repository.clientInfo.ClientRepositoryMock;

import static org.junit.Assert.assertTrue;

public class ClientInfoRepositoryMockTest {

    private static ClientInfoRepository repository;

    @BeforeClass
    public static void setupClass(){
        repository = new ClientInfoRepositoryCacheDecorator(
                new ClientRepositoryMock(),
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
        assertTrue(repository.addClientInfo(clientInfo).getResult());
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
        assertTrue(repository.addClientInfo(clientInfo).getResult());
    }

    @Test
    public void updateClientInfo() throws Exception{
        assertTrue(repository.updateClientInfo("Ionescu Raluca","Ionescu Maria","str. Macinului, nr 14","str. Macinului, nr 24","234509","238908","1234567890145").getResult());
    }

    @Test
    public void deleteClientInfo() throws Exception{
        assertTrue(repository.viewClientInfo("Ionescu Maria","1234567890134").getResult());
    }
}
