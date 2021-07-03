package spring.web.dao;

import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import spring.web.lib.exception.DataProcessingException;

public abstract class AbstractDao<T> {
    protected final SessionFactory factory;
    private final Class<T> clazz;

    protected AbstractDao(SessionFactory factory, Class<T> clazz) {
        this.factory = factory;
        this.clazz = clazz;
    }

    public T add(T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't save to db "
                    + clazz.getSimpleName() + " " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Optional<T> get(Long id) {
        try (Session session = factory.openSession()) {
            return Optional.ofNullable(session.get(clazz, id));
        } catch (Exception e) {
            throw new DataProcessingException("Can't get from db"
                + clazz.getSimpleName() + ", id: " + id, e);
        }
    }

    public List<T> getAll() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all "
                + clazz.getSimpleName() + "s from db", e);
        }
    }

    public T update(T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't update "
                + clazz.getSimpleName() + " " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Long id) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            T entity = session.get(clazz, id);
            session.delete(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete "
                + clazz.getSimpleName() + " with id: " + id, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
