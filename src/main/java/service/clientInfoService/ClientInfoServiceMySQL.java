package service.clientInfoService;

import model.ClientInfo;
import model.User;
import model.builder.ClientInfoBuilder;
import model.validation.ClientValidator;
import model.validation.Notification;
import repository.clientInfo.ClientInfoRepository;

public class ClientInfoServiceMySQL implements ClientInfoService{

    private final ClientInfoRepository clientInfoRepository;

    public ClientInfoServiceMySQL(ClientInfoRepository clientInfoRepository) {
        this.clientInfoRepository = clientInfoRepository;
    }

    @Override
    public Notification<Boolean> addClientInfo(String tfClientName, String tfPersonalNumericalCode, String tfCardNumber, String tfAddress) {
        Notification<Boolean> addClientNotification = new Notification<>();

        ClientInfo client = new ClientInfoBuilder().setClientName(tfClientName).setCardnumber(tfCardNumber).setPersonalNumericalCode(tfPersonalNumericalCode).setAdress(tfAddress).build();
        ClientValidator clientValidator =new ClientValidator(client);
        boolean clientValid = clientValidator.validate();
        if(!clientValid){
            clientValidator.getErrors().forEach(addClientNotification::addError);
            addClientNotification.setResult(Boolean.FALSE);
        }else{

            ClientInfoBuilder clientInfoBuilder = new ClientInfoBuilder();
            clientInfoRepository.addClientInfo((clientInfoBuilder.setClientName(tfClientName).setPersonalNumericalCode(tfPersonalNumericalCode)
                    .setAdress(tfAddress).setCardnumber(tfCardNumber)).build());

        }
        return addClientNotification;
    }

    @Override
    public Notification<Boolean> updateClientInfo(String tfOldClientName, String tfNewClientName, String tfPersonalNumericalCode, String tfOldCardNumber, String tfNewCardNumber, String tfOldAddress, String tfNewAddress) {
        Notification<Boolean> updateClientNotification = new Notification<>();

        ClientInfo client = new ClientInfoBuilder().setClientName(tfNewClientName).setCardnumber(tfNewCardNumber).setPersonalNumericalCode(tfPersonalNumericalCode).setAdress(tfNewAddress).build();
        ClientValidator clientValidator =new ClientValidator(client);
        boolean clientValid = clientValidator.validate();
        if(!clientValid){
            clientValidator.getErrors().forEach(updateClientNotification::addError);
            updateClientNotification.setResult(Boolean.FALSE);
        }else {
            clientInfoRepository.updateClientInfo(tfOldClientName, tfNewClientName, tfOldAddress, tfNewAddress, tfOldCardNumber, tfNewCardNumber, tfPersonalNumericalCode);
        }
        return updateClientNotification;
    }

    @Override
    public Notification<Boolean> viewClientInfo(String tfClientName, String tfPersonalNumericalCode) {
        Notification<Boolean> viewClientNotification = new Notification<>();

        ClientInfo client = new ClientInfoBuilder().setClientName(tfClientName).setCardnumber("123456").setPersonalNumericalCode(tfPersonalNumericalCode).setAdress("str. Default").build();
        ClientValidator clientValidator =new ClientValidator(client);
        boolean clientValid = clientValidator.validate();
        if(!clientValid){
            clientValidator.getErrors().forEach(viewClientNotification::addError);
            viewClientNotification.setResult(Boolean.FALSE);
        }else {
            clientInfoRepository.viewClientInfo(tfClientName, tfPersonalNumericalCode);
        }
        return viewClientNotification;
    }


}
