package repository.clientInfo;

import model.ClientInfo;
import model.validation.Notification;

public interface ClientInfoRepository {

    Notification<Boolean> addClientInfo(ClientInfo clientInfo);

    Notification<Boolean> updateClientInfo(String tfOldClientName, String tfNewClientName, String tfOldAddress, String tfNewAddress, String tfOldCardNumber, String tfNewCardNumber, String tfPersonalNumericalCode);

    Notification<Boolean> viewClientInfo(String tfClientName, String tfPersonalNumericalCode);

}
