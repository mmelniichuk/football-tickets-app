package spring.web.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import spring.web.dao.AbstractDao;
import spring.web.dao.RoleDao;
import spring.web.lib.exception.DataProcessingException;
import spring.web.model.Role;
import spring.web.model.RoleName;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(RoleName roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Role WHERE roleName = :role", Role.class)
                    .setParameter("role", roleName)
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role by name: "
                    + roleName.toString() + " not found", e);
        }
    }
}
