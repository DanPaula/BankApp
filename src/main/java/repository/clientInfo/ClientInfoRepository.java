package repository.clientInfo;

import model.ClientInfo;
import model.builder.ClientInfoBuilder;

public interface ClientInfoRepository {

    void addClientInfo(ClientInfo clientInfo);

    void updateClientInfo(String tfOldClientName, String tfNewClientName, String tfOldAddress, String tfNewAddress, String tfOldCardNumber, String tfNewCardNumber, String tfPersonalNumericalCode);

    void viewClientInfo(String tfClientName, String tfPersonalNumericalCode);
}
