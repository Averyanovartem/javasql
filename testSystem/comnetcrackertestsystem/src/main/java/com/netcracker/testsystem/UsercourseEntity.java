package com.netcracker.testsystem;

import javax.persistence.*;

@Entity
@Table(name = "usercourse", schema = "testsystem", catalog = "")
public class UsercourseEntity {
    private int id;
    private int userId;
    private int courseId;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userId", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserId(String userId) { this.userId = Integer.parseInt(userId);}

    @Basic
    @Column(name = "courseId", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.userId = courseId;
    }

    public void setCourseId(String courseId) { this.courseId = Integer.parseInt(courseId);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsercourseEntity that = (UsercourseEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

}
