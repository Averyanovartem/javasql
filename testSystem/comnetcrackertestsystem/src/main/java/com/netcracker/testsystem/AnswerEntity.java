package com.netcracker.testsystem;

import javax.persistence.*;

@Entity
@Table(name = "answer", schema = "testsystem", catalog = "")
public class AnswerEntity {
    private int id;
    private String text;
    private int right;
    private int point;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "text", nullable = false, length = 500)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "right", nullable = false)
    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    @Basic
    @Column(name = "point", nullable = false)
    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerEntity that = (AnswerEntity) o;

        if (id != that.id) return false;
        if (right != that.right) return false;
        if (point != that.point) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + right;
        result = 31 * result + point;
        return result;
    }
}
