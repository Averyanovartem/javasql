package com.netcracker.testsystem.model;


import com.netcracker.testsystem.HibernateSessionFactory;
import com.netcracker.testsystem.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Model {
//    static {
//        session = HibernateSessionFactory.getSessionFactory().openSession();
//        System.out.println("Session opened");
//    }
    private static Model instance = new Model();
    //private static Session session;
    private List<UserEntity> users;

    public static Model getInstance() {
        return instance;
    }

    private Model() {
        users = new ArrayList<>();

    }

    public void addUser(UserEntity user) {
        //model.add(user);
        System.out.println("Start adding user");
        Session session = null;
        try {
            session = HibernateSessionFactory.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        System.out.println("User added");

    }

    public List<String> listUsers() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Query query = session.createQuery("from UserEntity");
        List<Object> usersList = query.list();

        return usersList.stream()
                .map(user -> (UserEntity) user)
                .map(UserEntity::getLastName)
                .collect(Collectors.toList());
    }
}
