import database.DBConnectionFactory;
import repository.admin.AdminRepository;
import repository.admin.AdminRepositoryMySQL;
import repository.clientInfo.ClientInfoRepository;
import repository.clientInfo.ClientInfoRepositoryMySQL;
import repository.security.RightsRolesRepository;
import repository.security.RightsRolesRepositoryMySQL;
import repository.security.UserRoleRepository;
import repository.security.UserRoleRepositoryMySQL;
import repository.user.UserRepository;
import repository.user.UserRepositoryMySQL;
import service.admin.AdminService;
import service.admin.AdminServiceMySQL;
import service.clientInfoService.ClientInfoService;
import service.clientInfoService.ClientInfoServiceMySQL;
import service.user.AuthenticationService;
import service.user.AuthenticationServiceMySQL;

import java.sql.Connection;


public class ComponentFactory {

    private final AuthenticationService authenticationService;

    private final UserRepository userRepository;
    private final RightsRolesRepository rightsRolesRepository;
    private final UserRoleRepository userRolesRepository;
    private final AdminService adminService;
    private final AdminRepository adminRepository;
    private final ClientInfoRepository clientInfoRepository;
    private final ClientInfoService clientInfoService;

    private static ComponentFactory instance;

    public static ComponentFactory instance(Boolean componentsForTests) {
        if (instance == null) {
            instance = new ComponentFactory(componentsForTests);
        }
        return instance;
    }

    private ComponentFactory(Boolean componentsForTests) {

        Connection connection = new DBConnectionFactory().getConnectionWrapper(componentsForTests).getConnection();
        this.userRolesRepository=new UserRoleRepositoryMySQL(connection);
        this.rightsRolesRepository = new RightsRolesRepositoryMySQL(connection);
        this.userRepository = new UserRepositoryMySQL(connection, rightsRolesRepository, userRolesRepository);
        this.adminRepository=new AdminRepositoryMySQL(connection);
        this.adminService = new AdminServiceMySQL(this.userRepository, this.rightsRolesRepository, this.userRolesRepository, adminRepository);
        this.authenticationService = new AuthenticationServiceMySQL(this.userRepository, this.rightsRolesRepository, this.userRolesRepository);
        this.clientInfoRepository = new ClientInfoRepositoryMySQL(connection);
        this.clientInfoService=new ClientInfoServiceMySQL(this.clientInfoRepository);
    }

    public AdminService getAdminRepository(){return adminService;}

    public ClientInfoService getClientInfoService(){return clientInfoService;}

    public AuthenticationService getAuthenticationService() {
        return authenticationService;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public RightsRolesRepository getRightsRolesRepository() {
        return rightsRolesRepository;
    }
}