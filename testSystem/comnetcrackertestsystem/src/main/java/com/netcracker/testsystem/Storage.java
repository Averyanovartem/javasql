package com.netcracker.testsystem;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Storage {

    static void printUsers(Session session) {
        Query query = session.createQuery("from UserEntity");
        List<UserEntity> list = query.list();
        for(int i = 0; i < list.size(); i++){
            System.out.println("ID: " + list.get(i).getId() + " " +
                    list.get(i).getFirstName() + " " +
                    list.get(i).getLastName());
            //System.out.println("Last name: " + list.get(i).getLastName());
        }
    }

    static void addUser(Session session, UserEntity user) {
//        Query query = session.createQuery("update UserEntity set firstName = :firstNameParam, lastName = :lastNameParam" +
//                ", login = :loginParam" +
//                ", password = :passwordParam" +
//                " where firstName = :nameCode");

//        session.beginTransaction();
//
//        UserEntity user = new UserEntity();
//        user.setFirstName("Petr");
//        user.setLastName("Petrov");
//        user.setLogin("petrov");
//        user.setPassword("1937476");
//
//        session.save(user);
//        session.getTransaction().commit();
//        session.close();
//
//        query.setParameter("nameCode", "Nick");
//        query.setParameter("nameParam", "NickChangedName1");
//        query.setParameter("lastNameParam", "LastNameChanged1" );
//        query.setParameter("birthDateParam", new Date());
//
//        int result = query.executeUpdate();
    }
}
