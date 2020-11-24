package repository.clientInfo;

import model.ClientInfo;
import model.validation.Notification;
import repository.Cache;

import java.util.List;

public class ClientInfoRepositoryCacheDecorator extends ClientInfoRepositoryDecorator{
    private Cache<ClientInfo> cache;

    public ClientInfoRepositoryCacheDecorator(ClientInfoRepository clientInfoRepository, Cache<ClientInfo> cache) {
        super(clientInfoRepository);
        this.cache = cache;
    }


    @Override
    public Notification<Boolean> addClientInfo(ClientInfo clientInfo) {
        return decoratedRepository.addClientInfo(clientInfo);
    }

    @Override
    public Notification<Boolean> updateClientInfo(String tfOldClientName, String tfNewClientName, String tfOldAddress, String tfNewAddress, String tfOldCardNumber, String tfNewCardNumber, String tfPersonalNumericalCode) {
        cache.invalidateCache();
        return decoratedRepository.updateClientInfo(tfOldClientName,tfNewClientName,tfOldAddress,tfNewAddress,tfOldCardNumber,tfNewCardNumber,tfPersonalNumericalCode);
    }

    @Override
    public Notification<Boolean> viewClientInfo(String tfClientName, String tfPersonalNumericalCode) {
        cache.invalidateCache();
        return decoratedRepository.viewClientInfo(tfClientName,tfPersonalNumericalCode);
    }
}
