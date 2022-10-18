package by.losevsa.eventscrud.repository;

import java.util.List;
import static java.lang.String.format;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.util.HibernateUtil;

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
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Event> events = session.createQuery(GET_ALL_EVENTS_QUERY, Event.class).getResultList();
            transaction.commit();

            return events;
        }
        catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new RepositoryException("Can't find all events", e);
        }
    }
}
