package repository.security;

import java.sql.SQLException;

public interface UserRoleRepository {
    void addUserRole(Long roleId, Long rightId);
    long findIdByUser(String username,String password);
}
