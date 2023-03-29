package cinema.dao.impl;

import cinema.dao.AbstractDao;
import cinema.dao.RoleDao;
import cinema.exception.DataProcessingException;
import cinema.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(String role) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Role r " + "WHERE r.roleName = :role", Role.class)
                    .setParameter("roleName", Role.RoleName.valueOf(role))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get Role by name " + role, e);
        }
    }
}
