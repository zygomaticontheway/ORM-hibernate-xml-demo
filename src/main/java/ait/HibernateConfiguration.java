package ait;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
    private final EntityManager entityManager;

    public HibernateConfiguration() {
        entityManager = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory()
                .createEntityManager();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
