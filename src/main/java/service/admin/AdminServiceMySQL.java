package service.admin;

import model.builder.UserBuilder;
import repository.admin.AdminRepository;
import repository.security.RightsRolesRepository;
import repository.security.UserRoleRepository;
import repository.user.UserRepository;

import java.security.MessageDigest;

public class AdminServiceMySQL implements  AdminService{

    private final UserRepository userRepository;
    private final RightsRolesRepository rightsRolesRepository;
    private final UserRoleRepository userRolesRepository;
    private final AdminRepository adminRepository;

    public AdminServiceMySQL(UserRepository userRepository, RightsRolesRepository rightsRolesRepository, UserRoleRepository userRolesRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.rightsRolesRepository = rightsRolesRepository;
        this.userRolesRepository = userRolesRepository;
        this.adminRepository = adminRepository;
    }

    @Override
    public void createEmployee(String name,String username, String password) {
        UserBuilder user= new UserBuilder();
        userRepository.save(user.setUsername(username).setPassword(encodePassword(password)).build());
        adminRepository.createEmployee(name);

    }

    @Override
    public void readEmployee() {
        adminRepository.readEmployee();
    }

    @Override
    public void updateEmployee(String oldName,String newName,String oldUsername,String newUsername, String password) {
        UserBuilder user= new UserBuilder();
        userRepository.update(oldUsername,newUsername,encodePassword(password));
        adminRepository.updateEmployee(oldName,newName);
    }

    @Override
    public void deleteEmployee(String name, String username) {
        userRepository.delete(username);
        adminRepository.deleteEmployee(name);
    }

    private String encodePassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
