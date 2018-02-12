package com.netcracker.testsystem;

import javax.persistence.*;

@Entity
@Table(name = "usertestresult", schema = "testsystem", catalog = "")
public class UsertestresultEntity {
    private int id;
    private int points;
    private int maxPoints;
    private int userId;
    private int testId;

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

    public  void setUserId(String userId) { this.userId = Integer.parseInt(userId);}

    @Basic
    @Column(name = "testId", nullable = false)
    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public  void setTestId(String testId) { this.testId = Integer.parseInt(testId);}

    @Basic
    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public  void setPoints(String points) { this.points = Integer.parseInt(points);}

    @Basic
    @Column(name = "maxPoints", nullable = false)
    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

    public  void setMaxPoints(String maxPoints) { this.maxPoints = Integer.parseInt(maxPoints);}



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsertestresultEntity that = (UsertestresultEntity) o;

        if (id != that.id) return false;
        if (points != that.points) return false;
        if (maxPoints != that.maxPoints) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + points;
        result = 31 * result + maxPoints;
        return result;
    }


}
