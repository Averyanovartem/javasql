/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttestsystem;

import java.util.Scanner;

/**
 *
 * @author User
 */

public class Adding {
    
    public static void run() {
        Scanner in = new Scanner(System.in);
        String buf = "";
         System.out.println("type 'help'");
        OUTER:
        while (true) {
            buf = in.next();
            switch (buf) {
                case "addUser":
                    addUser(in);
                    break;
                case "addAnswer":
                    addAnswer(in);
                    break;
                case "addCourse":
                    addCourse(in);
                    break;
                case "addQuestion":
                    addQuestion(in);
                    break;
                case "addTest":
                    addTest(in);
                    break;
                case "addUserCourse":
                    addUserCourse(in);
                    break;
                case "addUserTestResult":
                    addUserTestResult(in);
                    break;
                case "exit":
                    break OUTER;
                case "help":
                    printCommands();
                    break;
                case "printUsers":
                    Storage.printUsers();
                    break;
                case "printAnswers":
                    Storage.printAnswers();
                    break;
                case "printTests":
                    Storage.printTests();
                    break;
                case "printQuestions":
                    Storage.printQuestions();
                    break;
                case "printCourses":
                    Storage.printCourses();
                    break;
                case "printUsersCourses":
                    Storage.printUsersCourses();
                    break;   
                case "printUsersTestsResults":
                    Storage.printUsersTestsResults();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
    
    private static void addUser(Scanner in) {
        System.out.println("Adding a new user");
        User newbie = new User();
        Storage.increaseMaxId("User");
        newbie.setUserId(Storage.getMaxId("User"));
        System.out.print(" Login: ");
        newbie.setLogin(in.next());
        System.out.print(" Password: ");
        newbie.setPassword(in.next());
        System.out.print(" First Name: ");
        newbie.setFirstName(in.next());
        System.out.print(" Last Name: ");
        newbie.setLastName(in.next());
        Storage.addUser(newbie);
        System.out.println("User added");
    }
    
    private static void addAnswer(Scanner in) {
        System.out.println("Adding a new answer");
        Answer newbie = new Answer();
        Storage.increaseMaxId("Answer");
        newbie.setAnswerId(Storage.getMaxId("Answer"));
        System.out.print(" Question id: ");
        newbie.setQuestionId(in.next());
        System.out.print(" Answer text: ");
        newbie.setAnswerText(in.next());
        System.out.print(" Right (true or false): ");
        newbie.setRight(in.next());
        System.out.print(" Points: ");
        newbie.setPoints(in.next());
        Storage.addAnswer(newbie);
        System.out.println("Answer added");
    }
    
    private static void addCourse(Scanner in) {
        System.out.println("Adding a new course");
        Course newbie = new Course();
        Storage.increaseMaxId("Course");
        newbie.setCourseId(Storage.getMaxId("Course"));
        System.out.print(" Course name: ");
        newbie.setCourseName(in.next());
        System.out.print(" Answer text: ");
        Storage.addCourse(newbie);
        System.out.println("Course added");
    }
    
    private static void addQuestion(Scanner in) {
        System.out.println("Adding a new question");
        Question newbie = new Question();
        Storage.increaseMaxId("Question");
        newbie.setQuestionId(Storage.getMaxId("Question"));
        System.out.print(" Test id: ");
        newbie.setTestId(in.next());
        System.out.print(" Question text: ");
        newbie.setQuestionText(in.next());
        Storage.addQuestion(newbie);
        System.out.println("Question added");
    }
    
    private static void addTest(Scanner in) {
        System.out.println("Adding a new test");
        Test newbie = new Test();
        Storage.increaseMaxId("Test");
        newbie.setTestId(Storage.getMaxId("Test"));
        System.out.print(" Course id: ");
        newbie.setCourseId(in.next());
        Storage.addTest(newbie);
        System.out.println("Test added");
    }
    
    private static void addUserCourse(Scanner in) {
        System.out.println("Adding a new UserCourse");
        UserCourse newbie = new UserCourse();
        Storage.increaseMaxId("UserCourse");
        newbie.setId(Storage.getMaxId("UserCourse"));
        System.out.print(" User id: ");
        newbie.setUserId(in.next());
        System.out.print(" Course id: ");
        newbie.setCourseId(in.next());
        Storage.addUserCourse(newbie);
        System.out.println("UserCourse added");
    }
    
    private static void addUserTestResult(Scanner in) {
        System.out.println("Adding a new UserTestResult");
        UserTestResult newbie = new UserTestResult();
        Storage.increaseMaxId("UserTestResult");
        newbie.setId(Storage.getMaxId("UserTestResult"));
        System.out.print(" User id: ");
        newbie.setUserId(in.next());
        System.out.print(" Test id: ");
        newbie.setTestId(in.next());
        System.out.print(" Points: ");
        newbie.setPoints(in.next());
        System.out.print(" Max points: ");
        newbie.setMaxPoints(in.next());
        Storage.addUserTestResult(newbie);     
        System.out.println("UserCourse added");
    }
    
    
    static void printCommands() {
         System.out.println("Commands: (* = User, Test, Answer, Question, Course, UserCourse, UserTestResult)");
         System.out.println(" add*");
         System.out.println(" print*s");
         System.out.println(" exit");
         
    }
    
}
