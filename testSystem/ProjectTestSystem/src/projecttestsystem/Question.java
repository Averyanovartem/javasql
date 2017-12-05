/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecttestsystem;

/**
 *
 * @author User
 */
public class Question {
    private int QuestionId;
    private Test test;
    private String questionText;

    /**
     * @return the QuestionId
     */
    public int getQuestionId() {
        return QuestionId;
    }

    /**
     * @param QuestionId the QuestionId to set
     */
    public void setQuestionId(int QuestionId) {
        this.QuestionId = QuestionId;
    }

    /**
     * @return the test
     */
    public Test getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * @return the questionText
     */
    public String getQuestionText() {
        return questionText;
    }

    /**
     * @param questionText the questionText to set
     */
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    
}
