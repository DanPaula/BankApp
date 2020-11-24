package repository.clientInfo;

public abstract class ClientInfoRepositoryDecorator implements ClientInfoRepository{

    protected ClientInfoRepository decoratedRepository;

    public ClientInfoRepositoryDecorator(ClientInfoRepository clientInfoRepository) {
        this.decoratedRepository = clientInfoRepository;
    }
}
