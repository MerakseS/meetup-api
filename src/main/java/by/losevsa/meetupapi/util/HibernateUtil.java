package by.losevsa.meetupapi.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The util for building hibernate {@link SessionFactory}.
 */
@Component
public class HibernateUtil {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);

    private SessionFactory sessionFactory;

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }

        return sessionFactory;
    }

    private SessionFactory buildSessionFactory() {
        try {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metaData = new MetadataSources(registry).getMetadataBuilder().build();
            return metaData.buildSessionFactory();
        }
        catch (Throwable e) {
            LOG.error("Can't build session factory.", e);
            throw new ExceptionInInitializerError(e);
        }
    }
}
