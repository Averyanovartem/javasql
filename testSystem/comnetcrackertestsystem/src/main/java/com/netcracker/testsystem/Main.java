package com.netcracker.testsystem;

import org.hibernate.Session;
import com.netcracker.testsystem.HibernateSessionFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Test System");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Petr");
        userEntity.setLastName("Petrov");
        userEntity.setLogin("petrov");
        userEntity.setPassword("1937476");
        userEntity.setId(3);

        session.save(userEntity);
        session.getTransaction().commit();

        session.close();
        HibernateSessionFactory.shutdown();
    }
}
