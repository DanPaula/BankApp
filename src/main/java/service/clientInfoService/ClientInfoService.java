package service.clientInfoService;

import model.User;
import model.validation.Notification;

public interface ClientInfoService {
    Notification<Boolean> addClientInfo(String tfClientName, String tfPersonalNumericalCode, String tfCardNumber, String tfAddress);

    Notification<Boolean> updateClientInfo(String tfOldClientName, String tfNewClientName, String tfPersonalNumericalCode, String tfOldCardNumber, String tfNewCardNumber, String tfOldAddress, String tfNewAddress);

    Notification<Boolean> viewClientInfo(String tfClientName, String tfPersonalNumericalCode);

}
