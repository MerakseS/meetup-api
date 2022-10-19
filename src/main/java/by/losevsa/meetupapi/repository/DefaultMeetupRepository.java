package by.losevsa.meetupapi.repository;

import java.util.List;
import static java.lang.String.format;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import by.losevsa.meetupapi.entity.Meetup;
import by.losevsa.meetupapi.exception.RepositoryException;
import by.losevsa.meetupapi.util.HibernateUtil;

/**
 * The Default implementation of {@link MeetupRepository} interface that uses Hibernate.
 */
@Repository
public class DefaultMeetupRepository implements MeetupRepository {

    private static final String GET_ALL_EVENTS_QUERY = "from Meetup";

    @Override
    public Meetup save(Meetup meetup) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(meetup);
            transaction.commit();
            return meetup;
        }
        catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RepositoryException(format("Can't persist meetup. Meetup: %s", meetup), e);
        }
    }

    @Override
    public List<Meetup> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(GET_ALL_EVENTS_QUERY, Meetup.class).getResultList();
        }
        catch (Exception e) {
            throw new RepositoryException("Can't find all meetups", e);
        }
    }

    @Override
    public Meetup findById(long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Meetup.class, id);
        }
        catch (Exception e) {
            throw new RepositoryException(format("Can't find meetup with id %d", id), e);
        }
    }

    @Override
    public void merge(Meetup meetup) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(meetup);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RepositoryException(format("Can't merge meetup. Meetup: %s", meetup), e);
        }
    }

    @Override
    public void remove(Meetup meetup) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(meetup);
            transaction.commit();
        }
        catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }

            throw new RepositoryException(format("Can't delete meetup. Meetup: %s", meetup), e);
        }
    }
}
