package com.netcracker.testsystem;

import javax.persistence.*;

@Entity
@Table(name = "question", schema = "testsystem", catalog = "")
public class QuestionEntity {
    private int id;
    private int testId;
    private String text;

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "testId", nullable = false)
    public int getTestId() {
        return testId;
    }

    public void setTestId(int id) {
        this.testId = testId;
    }

    public void setTestId(String testId) { this.testId = Integer.parseInt(testId);}

    @Basic
    @Column(name = "text", nullable = false, length = 500)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QuestionEntity that = (QuestionEntity) o;

        if (id != that.id) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
