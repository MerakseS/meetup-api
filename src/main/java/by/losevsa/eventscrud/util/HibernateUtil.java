package by.losevsa.eventscrud.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The util for building hibernate {@link SessionFactory}.
 */
public class HibernateUtil {

    private static final Logger LOG = LoggerFactory.getLogger(HibernateUtil.class);
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
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

    /**
     * Gets session factory.
     *
     * @return the session factory
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
