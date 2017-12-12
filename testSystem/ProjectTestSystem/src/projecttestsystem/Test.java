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
public class Test {
    private long testId;
    private long courseId;
 
    /**
     * @return the testId
     */
    public long getTestId() {
        return testId;
    }

    /**
     * @param testId the testId to set
     */
    public void setTestId(long testId) {
        this.testId = testId;
    }
    public void setTestId(String testId) {
        this.testId = Long.parseLong(testId);
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
     public void setCourseId(String courseId) {
        this.courseId = Long.parseLong(courseId);
    }    
    
}
