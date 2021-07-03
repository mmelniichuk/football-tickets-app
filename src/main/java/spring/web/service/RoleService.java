package spring.web.service;

import spring.web.model.Role;
import spring.web.model.RoleName;

public interface RoleService {
    Role add(Role role);

    Role getRoleByName(RoleName roleName);
}
