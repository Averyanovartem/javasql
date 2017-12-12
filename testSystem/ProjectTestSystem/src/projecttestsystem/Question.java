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
    private long QuestionId;
    private long testId;
    private String questionText;

    /**
     * @return the QuestionId
     */
    public long getQuestionId() {
        return QuestionId;
    }

    /**
     * @param QuestionId the QuestionId to set
     */
    public void setQuestionId(long QuestionId) {
        this.QuestionId = QuestionId;
    }
    public void setQuestionId(String QuestionId) {
        this.QuestionId = Long.parseLong(QuestionId);
    }

    public long getTestId() {
        return testId;
    }

    public void setTestId(long testId) {
        this.testId = testId;
    }
    public void setTestId(String testId) {
        this.testId = Long.parseLong(testId);
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
