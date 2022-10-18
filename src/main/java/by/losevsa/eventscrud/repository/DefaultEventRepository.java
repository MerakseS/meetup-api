package by.losevsa.eventscrud.repository;

import java.util.List;
import static java.lang.String.format;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.exception.RepositoryException;
import by.losevsa.eventscrud.util.HibernateUtil;

/**
 * The Default implementation of {@link EventRepository} interface that uses Hibernate.
 */
@Repository
public class DefaultEventRepository implements EventRepository {

    private static final String GET_ALL_EVENTS_QUERY = "from Event";

    @Override
    public Event save(Event event) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(event);
            transaction.commit();
            return event;
        }
        catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RepositoryException(format("Can't persist event. Event: %s", event), e);
        }
    }

    @Override
    public List<Event> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_EVENTS_QUERY, Event.class).getResultList();
        }
        catch (Exception e) {
            throw new RepositoryException("Can't find all events", e);
        }
    }

    @Override
    public Event findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Event.class, id);
        }
        catch (Exception e) {
            throw new RepositoryException(format("Can't find event with id %d", id), e);
        }
    }

    @Override
    public void merge(Event event) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(event);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RepositoryException(format("Can't merge event. Event: %s", event), e);
        }
    }

    @Override
    public void remove(Event event) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(event);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RepositoryException(format("Can't delete event. Event: %s", event), e);
        }
    }
}
