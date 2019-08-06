package com.sut.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "class_course")
public class classCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;
    @Column(name = "cId",nullable = false)
    private int cId;
    @Column(name = "classId",nullable = false)
    private int classId;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getSemester() {
        return semester;
    }

    @Override
    public String toString() {
        return "classCourse{" +
                "uuid=" + uuid +
                ", cId=" + cId +
                ", classId=" + classId +
                ", semester='" + semester + '\'' +
                '}';
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
    @Column(name = "semester",nullable = false)
    private String semester;
}
