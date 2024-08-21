package ait;

public class Main {
    public static void main(String[] args) {
        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        UserXmlHibernateRepository repository = new UserXmlHibernateRepository(hibernateConfiguration);

        System.out.println(repository.findAll());
    }
}