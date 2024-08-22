package ait;

import ait.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UserXmlHibernateRepository {
    private final HibernateConfiguration hibernateConfiguration;
    private final EntityManager entityManager;

    public UserXmlHibernateRepository(HibernateConfiguration hibernateConfiguration) {
        this.hibernateConfiguration = hibernateConfiguration;
        entityManager = hibernateConfiguration.getEntityManager();
    }

    public List<User> findAll() {
        //достаем запрос в таблицу Users из entityManager
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    public User findById(Integer id) {
        return entityManager.find(User.class, id);
    }

    public User create(User user) {

        //создаем объект hibernate, который будет хранить операции и если весь процесс завершится неудачей, то транзакция откатится к моменту до ее создания
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(user); //метод сохранения
            transaction.commit(); //завершить транзакцию
            return user;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            throw new RuntimeException("Create new user fail!: " + user);
        }

    }

}
