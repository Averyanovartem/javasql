package com.netcracker.testsystem;

import org.hibernate.Session;

import java.util.Scanner;

public class Adding {

    public static void run(Session session) {
        Scanner in = new Scanner(System.in);
        String buf = "";
        System.out.println("type 'help'");
        OUTER:
        while (true) {

            buf = in.next();
            if (buf.equals("addUser")) {
                Adding.addUser(session, in);
            } else if (buf.equals("addAnswer")) {
                Adding.addAnswer(session, in);
            } else if (buf.equals("addCourse")) {
                Adding.addCourse(session, in);
            } else if (buf.equals("addQuestion")) {
                Adding.addQuestion(session, in);
            } else if (buf.equals("addTest")) {
                Adding.addTest(session, in);
            } else if (buf.equals("addUserCourse")) {
                Adding.addUserCourse(session, in);
            } else if (buf.equals("addUserTestResult")) {
                Adding.addUserTestResult(session, in);
            } else if (buf.equals("help")) {
                Adding.printCommands();
            } else if (buf.equals("exit")) {
                break OUTER;
            } else {
                System.out.println("Unknown command");
            }
//            switch (buf) {
//                case "addUser":
//                    addUser(session, in);
//                    break;
//                case "addAnswer":
//                    addAnswer(in);
//                    break;
//                case "addCourse":
//                    addCourse(in);
//                    break;
//                case "addQuestion":
//                    addQuestion(in);
//                    break;
//                case "addTest":
//                    addTest(in);
//                    break;
//                case "addUserCourse":
//                    addUserCourse(in);
//                    break;
//                case "addUserTestResult":
//                    addUserTestResult(in);
//                    break;
//                case "exit":
//                    break OUTER;
//                case "help":
//                    printCommands();
//                    break;
//                case "printUsers":
//                    Storage.printUsers();
//                    break;
//                case "printAnswers":
//                    Storage.printAnswers();
//                    break;
//                case "printTests":
//                    Storage.printTests();
//                    break;
//                case "printQuestions":
//                    Storage.printQuestions();
//                    break;
//                case "printCourses":
//                    Storage.printCourses();
//                    break;
//                case "printUsersCourses":
//                    Storage.printUsersCourses();
//                    break;
//                case "printUsersTestsResults":
//                    Storage.printUsersTestsResults();
//                    break;
//                default:
//                    System.out.println("Unknown command");
//                    break;
//            }
        }
    }

    private static void addUser(Session session, Scanner in) {
        System.out.println("Adding a new user");
        UserEntity newbie = new UserEntity();
        System.out.print(" First Name: ");
        newbie.setFirstName(in.next());
        System.out.print(" Last Name: ");
        newbie.setLastName(in.next());
        System.out.print(" Login: ");
        newbie.setLogin(in.next());
        System.out.print(" Password: ");
        newbie.setPassword(in.next());
//        Storage.addUser(session, newbie);
        session.beginTransaction();
        session.save(newbie);
        session.getTransaction().commit();
        System.out.println("User added");
    }

    private static void addAnswer(Session session, Scanner in) {
        System.out.println("Adding a new answer");
        AnswerEntity newbie = new AnswerEntity();
        System.out.print(" Answer text: ");
        newbie.setText(in.next());
        System.out.print(" QuestionId: ");
        newbie.setQuestionId(in.next());
        System.out.print(" Right (true or false): ");
        newbie.setRight(in.next());
        System.out.print(" Points: ");
        newbie.setPoint(in.next());
        session.beginTransaction();
        session.save(newbie);
        session.getTransaction().commit();
        System.out.println("Answer added");
    }

    private static void addCourse(Session session, Scanner in) {
        System.out.println("Adding a new course");
        CourseEntity newbie = new CourseEntity();
        System.out.print(" Course name: ");
        newbie.setCourseName(in.next());
        session.beginTransaction();
        session.save(newbie);
        session.getTransaction().commit();
        System.out.println("Course added");
    }

    private static void addQuestion(Session session, Scanner in) {
        System.out.println("Adding a new question");
        QuestionEntity newbie = new QuestionEntity();
        System.out.print(" Test id: ");
        newbie.setTestId(in.next());
        System.out.print(" Question text: ");
        newbie.setText(in.next());
        session.beginTransaction();
        session.save(newbie);
        session.getTransaction().commit();
        System.out.println("Question added");
    }

    private static void addTest(Session session, Scanner in) {
        System.out.println("Adding a new test");
        TestEntity newbie = new TestEntity();
        System.out.print(" Course id: ");
        newbie.setCourseId(in.next());
        newbie.setDate();
        session.beginTransaction();
        session.save(newbie);
        session.getTransaction().commit();
        System.out.println("Test added");
    }

    private static void addUserCourse(Session session, Scanner in) {
        System.out.println("Adding a new UserCourse");
        UsercourseEntity newbie = new UsercourseEntity();
        System.out.print(" User id: ");
        newbie.setUserId(in.next());
        System.out.print(" Course id: ");
        newbie.setCourseId(in.next());
        session.beginTransaction();
        session.save(newbie);
        session.getTransaction().commit();
        System.out.println("UserCourse added");
    }

    private static void addUserTestResult(Session session, Scanner in) {
        System.out.println("Adding a new UserTestResult");
        UsertestresultEntity newbie = new UsertestresultEntity();
        System.out.print(" User id: ");
        newbie.setUserId(in.next());
        System.out.print(" Test id: ");
        newbie.setTestId(in.next());
        System.out.print(" Points: ");
        newbie.setPoints(in.next());
        System.out.print(" Max points: ");
        newbie.setMaxPoints(in.next());
        session.beginTransaction();
        session.save(newbie);
        session.getTransaction().commit();
        System.out.println("UserCourse added");
    }

    static void printCommands() {
        System.out.println("Commands: (* = User, Test, Answer, Question, Course, UserCourse, UserTestResult)");
        System.out.println(" add*");
        //System.out.println(" print*s");
        System.out.println(" exit");

    }

}
