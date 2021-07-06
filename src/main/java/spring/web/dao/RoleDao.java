package spring.web.dao;

import java.util.Optional;
import spring.web.model.Role;
import spring.web.model.RoleName;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(RoleName roleName);
}
