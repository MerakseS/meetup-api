package by.losevsa.eventscrud.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import by.losevsa.eventscrud.entity.Event;
import by.losevsa.eventscrud.util.HibernateUtil;

@Repository
public class DefaultEventRepository implements EventRepository {

    public static final Logger LOG = LoggerFactory.getLogger(DefaultEventRepository.class);

    @Override
    public List<Event> findAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            List<Event> events = session.createQuery("from Event", Event.class).getResultList();
            transaction.commit();

            return events;
        }
        catch (Exception e) {
            LOG.error("Can't find all events.", e);
            if (transaction != null) {
                transaction.rollback();
            }

            return null;
        }
    }
}
