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
public class Answer {
    private int answerId;
    private Question question;
    private String questionText;
    private boolean right;
    private int points;
    
    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }
    public int getAnswerId() {
        return this.answerId;
    }    
    public void setQuestion(Question question) {
        this.question = question;
    }
    public Question getQuestion() {
        return this.question;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    public String getQuestionText() {
        return this.questionText;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public boolean getRight() {
        return this.right;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoints() {
        return this.points;
    }
}
