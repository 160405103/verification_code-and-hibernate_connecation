package com.sut.example.demo.Model;

import javax.persistence.*;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;
    @Column(name = "classId",nullable = false)
    private int classId;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassStuNum() {
        return classStuNum;
    }

    public void setClassStuNum(int classStuNum) {
        this.classStuNum = classStuNum;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public String getClassMajor() {
        return classMajor;
    }

    public void setClassMajor(String classMajor) {
        this.classMajor = classMajor;
    }
    @Column(name = "className",nullable = false)
    private String className;
    @Column(name = "classStuNum",nullable = true)
    private int classStuNum;
    @Column(name = "classGrade",nullable = false)
    private String classGrade;
    @Column(name = "classMajor",nullable = true)
    private String classMajor;
}
