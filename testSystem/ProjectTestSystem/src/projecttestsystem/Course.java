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
public class Course {
    private long courseId;
    private String courseName;
    
    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }
    public void setCourseId(String courseId) {
        this.courseId = Long.parseLong(courseId);
    }
    public long getCourseId() {
        return this.courseId;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseName() {
        return this.courseName;
    }
    
}
