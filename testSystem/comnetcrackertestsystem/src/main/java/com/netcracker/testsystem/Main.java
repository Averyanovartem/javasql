package com.netcracker.testsystem;

import org.hibernate.Query;
import org.hibernate.Session;
import com.netcracker.testsystem.HibernateSessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Project Test System");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();


//        Query query =  session.createQuery("delete UsercourseEntity where courseId = :param");
//        query.setParameter("param", 0);
//        int result = query.executeUpdate();
//        System.out.println(result);

        Adding.run(session);
//        Query query = session.createQuery("from UserEntity where firstName = :paramName");
//        query.setParameter("paramName", "Ivan");
//        List<UserEntity> list = query.list();
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).getLastName());
//        }
//        Storage.printUsers(session);

//        session.beginTransaction();



//        UserEntity userEntity = new UserEntity();
//        userEntity.setFirstName("Petr");
//        userEntity.setLastName("Petrov");
//        userEntity.setLogin("petrov");
//        userEntity.setPassword("1937476");
//        userEntity.setId(3);

//        session.save(userEntity);
//        session.getTransaction().commit();

//        session.close();
        HibernateSessionFactory.shutdown();
    }
}
