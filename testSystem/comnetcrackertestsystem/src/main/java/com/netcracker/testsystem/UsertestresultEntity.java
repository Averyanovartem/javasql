package com.netcracker.testsystem;

import javax.persistence.*;

@Entity
@Table(name = "usertestresult", schema = "testsystem", catalog = "")
public class UsertestresultEntity {
    private int id;
    private int points;
    private int maxPoints;
    private UserEntity userByUserId;
    private TestEntity testByTestId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "points", nullable = false)
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Basic
    @Column(name = "maxPoints", nullable = false)
    public int getMaxPoints() {
        return maxPoints;
    }

    public void setMaxPoints(int maxPoints) {
        this.maxPoints = maxPoints;
    }

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

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "testId", referencedColumnName = "id", nullable = false)
    public TestEntity getTestByTestId() {
        return testByTestId;
    }

    public void setTestByTestId(TestEntity testByTestId) {
        this.testByTestId = testByTestId;
    }
}
