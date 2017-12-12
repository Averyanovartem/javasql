/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttestsystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author User
 */
public class Storage {  
    static Map<Long, Answer> answers;	
    static Map<Long, Course> courses;
    static Map<Long, Question> questions;
    static Map<Long, Test> tests;
    static Map<Long, User> users;
    static Map<Long, UserCourse> usersCourses;
    static Map<Long, UserTestResult> usersTestsResults;
    
    private static long maxUserId = 0;
    private static Map<String, Long> maxIds;
    
    public static String EMPLOYEE_ROOT = "Tables";
    public static String EMPLOYEE_ELEMENT = "Employees";
    
    public static void init() {
        maxIds = new HashMap<String, Long>();
        answers = new HashMap<>();
        courses = new HashMap<>();
        questions = new HashMap<>();
        tests = new HashMap<>();
        users = new HashMap<>();
        usersCourses = new HashMap<>();
        usersTestsResults = new HashMap<>();
    }
    
    public static void fillAnswers(Map<Long, Answer> answers){
        Storage.answers = answers;
    }
    public static void fillCourses(Map<Long, Course> courses){
        Storage.courses = courses;
    }
    public static void fillQuestions(Map<Long, Question> questions){
        Storage.questions = questions;
    }
    public static void fillTests(Map<Long, Test> tests){
        Storage.tests = tests;
    }
    public static void fillUsers(Map<Long, User> users){
        Storage.users = users;
    }
    public static void fillUsersCourses(Map<Long, UserCourse> usersCourses){
        Storage.usersCourses = usersCourses;
    }
    public static void fillUsersTestsResults(Map<Long, UserTestResult> usersTestsResults){
        Storage.usersTestsResults = usersTestsResults;
    }
    
    public static Set<Map.Entry<Long, Answer>> getAnswers(){
		return answers.entrySet();
    }
    public static Set<Map.Entry<Long, Course>> getCourses(){
		return courses.entrySet();
    }
    public static Set<Map.Entry<Long, Question>> getQuestions(){
		return questions.entrySet();
    }
    public static Set<Map.Entry<Long, Test>> getTests(){
		return tests.entrySet();
    }
     public static Set<Map.Entry<Long, User>> getUsers(){
		return users.entrySet();
    }
    public static Set<Map.Entry<Long, UserCourse>> getUsersCourses(){
		return usersCourses.entrySet();
    }
    public static Set<Map.Entry<Long, UserTestResult>> getUsersTestsResults(){
		return usersTestsResults.entrySet();
    }
     
    public static void addUser(User newbie) {
        users.put(newbie.getUserId(), newbie);
    }
    public static void addAnswer(Answer newbie) {
        answers.put(newbie.getAnswerId(), newbie);
    }
    public static void addCourse(Course newbie) {
        courses.put(newbie.getCourseId(), newbie);
    }
    public static void addQuestion(Question newbie) {
        questions.put(newbie.getQuestionId(), newbie);
    }
    public static void addTest(Test newbie) {
        tests.put(newbie.getTestId(), newbie);
    }
    public static void addUserCourse(UserCourse newbie) {
        usersCourses.put(newbie.getId(), newbie);
    }
    public static void addUserTestResult(UserTestResult newbie) {
        usersTestsResults.put(newbie.getId(), newbie);
    }
    
    public static void increaseMaxUserId() {
        maxUserId = maxUserId + 1;
    }
    
    public static void increaseMaxId(String elementName) {
        long buf = maxIds.get(elementName);
        maxIds.put(elementName, buf + 1);
    }
    
    
    
    
    public static void printUsers() {
        System.out.println("Users:");
        for (Entry entry : users.entrySet()) {
            User user = (User) entry.getValue();
            System.out.println(" ID: " + user.getUserId());
            System.out.println("  first name: " + user.getFirstName());
            System.out.println("  Last name: " + user.getLastName());
            System.out.println("  Login: " + user.getLogin());
            System.out.println("  Password: " + user.getPassword());
        }
     }
    
    public static void printAnswers() {
        System.out.println("Answers:");
        for (Entry entry : answers.entrySet()) {
            Answer element = (Answer) entry.getValue();
            System.out.println(" ID: " + element.getAnswerId());
            System.out.println("  Question ID: " + element.getQuestionId());
            System.out.println("  Answer text: " + element.getAnswerText());
            System.out.println("  Right: " + element.getRight());
            System.out.println("  Points: " + element.getPoints());
        }
     }
    
    public static void printQuestions() {
        System.out.println("Questions:");
        for (Entry entry : questions.entrySet()) {
            Question element = (Question) entry.getValue();
            System.out.println(" ID: " + element.getQuestionId());
            System.out.println("  Test ID: " + element.getTestId());
            System.out.println("  Question text: " + element.getQuestionText());
        }
     }
    
    public static void printCourses() {
        System.out.println("Courses:");
        for (Entry entry : courses.entrySet()) {
            Course element = (Course) entry.getValue();
            System.out.println(" ID: " + element.getCourseId());
            System.out.println("  Course name: " + element.getCourseName());
        }
     }
    
    public static void printTests() {
        System.out.println("Tests:");
        for (Entry entry : tests.entrySet()) {
            Test element = (Test) entry.getValue();
            System.out.println(" ID: " + element.getTestId());
            System.out.println("  Course ID: " + element.getCourseId());
        }
     }
    
    public static void printUsersCourses() {
        System.out.println("UsersCourses:");
        for (Entry entry : usersCourses.entrySet()) {
            UserCourse element = (UserCourse) entry.getValue();
            System.out.println(" ID: " + element.getId());
            System.out.println("  User ID: " + element.getUserId());
            System.out.println("  Course ID: " + element.getCourseId());
        }
    }
    
    public static void printUsersTestsResults() {
        System.out.println("UsersCourses:");
        for (Entry entry : usersTestsResults.entrySet()) {
            UserTestResult element = (UserTestResult) entry.getValue();
            System.out.println(" ID: " + element.getId());
            System.out.println("  User ID: " + element.getUserId());
            System.out.println("  Test ID: " + element.getTestId());
            System.out.println("  Points: " + element.getPoints());
            System.out.println("  Max points: " + element.getMaxPoints());
        }
    }
    
    /**
     * @return the maxUserId
     */
    public static long getMaxUserId() {
        return maxUserId;
    }

    /**
     * @param aMaxUserId the maxUserId to set
     */
    public static void setMaxUserId(long aMaxUserId) {
        maxUserId = aMaxUserId;
    }

    /**
     * @return the maxIds
     */
    public static Map<String, Long> getMaxIds() {
        return maxIds;
    }

    /**
     * @param aMaxIds the maxIds to set
     */
    public static void setMaxIds(Map<String, Long> aMaxIds) {
        maxIds = aMaxIds;
    }
    
    public static void addMaxId(String key, long value) {
        maxIds.put(key, value);
    }
    
    public static void setMaxId(String key, long value) {
        maxIds.put(key, value);
    }
    
    public static long getMaxId(String elementName) {
        return maxIds.get(elementName);
    }
}
