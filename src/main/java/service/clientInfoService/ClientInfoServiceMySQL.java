package service.clientInfoService;

import model.builder.ClientInfoBuilder;
import repository.admin.AdminRepository;
import repository.clientInfo.ClientInfoRepository;
import repository.security.RightsRolesRepository;
import repository.security.UserRoleRepository;
import repository.user.UserRepository;

public class ClientInfoServiceMySQL implements ClientInfoService{

    private final ClientInfoRepository clientInfoRepository;

    public ClientInfoServiceMySQL(ClientInfoRepository clientInfoRepository) {
        this.clientInfoRepository = clientInfoRepository;
    }

    @Override
    public void addClientInfo(String tfClientName, String tfPersonalNumericalCode, String tfCardNumber, String tfAddress) {
        ClientInfoBuilder clientInfoBuilder = new ClientInfoBuilder();
        clientInfoRepository.addClientInfo((clientInfoBuilder.setClientName(tfClientName).setPersonalNumericalCode(tfPersonalNumericalCode)
                .setAdress(tfAddress).setCardnumber(tfCardNumber)).build());
    }

    @Override
    public void updateClientInfo(String tfOldClientName, String tfNewClientName, String tfPersonalNumericalCode, String tfOldCardNumber, String tfNewCardNumber, String tfOldAddress, String tfNewAddress) {
        clientInfoRepository.updateClientInfo(tfOldClientName,tfNewClientName,tfOldAddress,tfNewAddress,tfOldCardNumber,tfNewCardNumber,tfPersonalNumericalCode);

    }

    @Override
    public void viewClientInfo(String tfClientName, String tfPersonalNumericalCode) {
        clientInfoRepository.viewClientInfo(tfClientName,tfPersonalNumericalCode);
    }


}
