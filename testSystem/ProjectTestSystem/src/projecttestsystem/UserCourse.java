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
public class UserCourse {
    private long id;
    private long userId;
    private long courseId;

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
