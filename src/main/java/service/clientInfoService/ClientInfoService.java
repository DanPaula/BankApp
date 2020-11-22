package service.clientInfoService;

public interface ClientInfoService {
    void addClientInfo(String tfClientName, String tfPersonalNumericalCode, String tfCardNumber, String tfAddress);

    void updateClientInfo(String tfOldClientName, String tfNewClientName, String tfPersonalNumericalCode, String tfOldCardNumber, String tfNewCardNumber, String tfOldAddress, String tfNewAddress);

    void viewClientInfo(String tfClientName, String tfPersonalNumericalCode);

}
