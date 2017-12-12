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
    private long answerId;
    private long questionId;
    private String answerText;
    private boolean right;
    private int points;
    
    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
    public void setAnswerId(String answerId) {
        this.answerId = Long.parseLong(answerId);
    }
    public long getAnswerId() {
        return this.answerId;
    }    
    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }
    public void setQuestionId(String questionId) {
        this.questionId = Long.parseLong(questionId);
    }
    public long getQuestionId() {
        return this.questionId;
    }
    public void setAnswerText(String questionText) {
        this.answerText = questionText;
    }
    public String getAnswerText() {
        return this.answerText;
    }
    public void setRight(boolean right) {
        this.right = right;
    }
    public void setRight(String right) {
        this.right = Boolean.parseBoolean(right);
    }
    public boolean getRight() {
        return this.right;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public void setPoints(String points) {
        this.points = Integer.parseInt(points);
    }
    public int getPoints() {
        return this.points;
    }
}
