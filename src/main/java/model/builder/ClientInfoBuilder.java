package model.builder;

import model.ClientInfo;


public class ClientInfoBuilder {

    private ClientInfo clientInfo;

    public ClientInfoBuilder() {
        clientInfo = new ClientInfo();
    }

    public ClientInfoBuilder setClientName(String author) {
        clientInfo.setClientName(author);
        return this;
    }

    public ClientInfoBuilder setCardnumber(String title) {
        clientInfo.setCardNumber(title);
        return this;
    }

    public ClientInfoBuilder setPersonalNumericalCode(String personalNumericalCode) {
        clientInfo.setPersonalNumericalCode(personalNumericalCode);
        return this;
    }

    public ClientInfoBuilder setId(Long id) {
        clientInfo.setId(id);
        return this;
    }

    public ClientInfoBuilder setAdress(String adress){
        clientInfo.setAddress(adress);
        return this;
    }

    public ClientInfo build() {
        return clientInfo;
    }
}