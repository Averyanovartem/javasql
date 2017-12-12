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
public class UserTestResult {
    private long id;
    private long userId;
    private long testId;
    private int points;
    private int maxPoints;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Long.parseLong(id);
    }
    
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
    public void setUserId(String userId) {
        this.userId = Long.parseLong(userId);
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
     * @return the points
     */
    public int getPoints() {
        return points;
    }

    /**
     * @param points the points to set
     */
    public void setPoints(int points) {
        this.points = points;
    }
    public void setPoints(String points) {
        this.points = Integer.parseInt(points);
    }

    /**
     * @return the maxPoints
     */
    public int getMaxPoints() {
        return maxPoints;
    }

    /**
     * @param maxPoints the maxPoints to set
     */
    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }
    public void setMaxPoints(String maxPoints) {
        this.maxPoints = Integer.parseInt(maxPoints);
    }
    
}
