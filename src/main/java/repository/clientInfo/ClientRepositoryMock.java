package repository.clientInfo;

import model.ClientInfo;
import model.builder.ClientInfoBuilder;
import model.validation.Notification;
import repository.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientRepositoryMock implements ClientInfoRepository{
    private List<ClientInfo> clientInfoList;

    public ClientRepositoryMock() {
        clientInfoList = new ArrayList<>();
    }

    @Override
    public Notification<Boolean> addClientInfo(ClientInfo clientInfo) {
        Notification<Boolean> addClient = new Notification<>();
        this.clientInfoList.add(clientInfo);
        if(this.clientInfoList.contains(clientInfo)){
            addClient.setResult(true);
        }
        else{
            addClient.setResult(false);
            addClient.addError("cannot add the client");
        }
        return addClient;
    }

    @Override
    public Notification<Boolean> updateClientInfo(String tfOldClientName, String tfNewClientName, String tfOldAddress, String tfNewAddress, String tfOldCardNumber, String tfNewCardNumber, String tfPersonalNumericalCode) {
        Notification<Boolean> updateClient = new Notification<>();
        ClientInfo client = new ClientInfo();
        this.clientInfoList.add(client);
        if(this.clientInfoList.contains(client)){
            updateClient.setResult(true);
        }else{
            updateClient.setResult(false);
            updateClient.addError("cannot update client");
        }
        return updateClient;
    }

    @Override
    public Notification<Boolean> viewClientInfo(String tfClientName, String tfPersonalNumericalCode) {
        Notification<Boolean> viewClient = new Notification<>();
        ClientInfo client = new ClientInfo();
        this.clientInfoList.add(client);
        if(this.clientInfoList.contains(client)){
            viewClient.setResult(true);
        }else{
            viewClient.setResult(false);
            viewClient.addError("cannot update client");
        }
        return viewClient;
    }
}
