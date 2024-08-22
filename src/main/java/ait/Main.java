package ait;

import ait.entity.User;

public class Main {
    public static void main(String[] args) {
        HibernateConfiguration hibernateConfiguration = new HibernateConfiguration();
        UserXmlHibernateRepository repository = new UserXmlHibernateRepository(hibernateConfiguration);

        System.out.println(repository.findAll());
        System.out.println(repository.findById(2));

        System.out.println("---------save--------");
        User newUser = repository.create(new User(null, "Masha", "masha@ma.ma", "pwdnmksdf"));
        System.out.println(newUser);
        System.out.println(repository.findAll());

    }
}