package com.sut.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;

    public Student(String stuId, String stuPwd, String stuName, String stuMajor, String stuClass, String stuGrade, String stuFace) {
        this.stuId = stuId;
        this.stuPwd = stuPwd;
        this.stuName = stuName;
        this.stuMajor = stuMajor;
        this.stuClassId = stuClass;
        this.stuGrade = stuGrade;
        this.stuFace = stuFace;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uuid=" + uuid +
                ", stuId='" + stuId + '\'' +
                ", stuPwd='" + stuPwd + '\'' +
                ", stuName='" + stuName + '\'' +
                ", stuMajor='" + stuMajor + '\'' +
                ", stuClass='" + stuClassId + '\'' +
                ", stuGrade='" + stuGrade + '\'' +
                ", stuFace='" + stuFace + '\'' +
                '}';
    }

    @Column(name="stuId",nullable=false)
    private String stuId;
    @Column(name="stuPwd",nullable=false)
    private String stuPwd;
    @Column(name="stuName",nullable=false)
    private String stuName;
    @Column(name="stuMajor",nullable=false)
    private String stuMajor;
    @Column(name="stuClassId",nullable=false)
    private String stuClassId;
    @Column(name="stuGrade",nullable=false)
    private String stuGrade;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public void setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
    }

    public String getStuClassId() {
        return stuClassId;
    }

    public void setStuClassId(String stuClassId) {
        this.stuClassId = stuClassId;
    }

    public String getStuGrade() {
        return stuGrade;
    }

    public void setStuGrade(String stuGrade) {
        this.stuGrade = stuGrade;
    }

    public String getStuFace() {
        return stuFace;
    }

    public void setStuFace(String stuFace) {
        this.stuFace = stuFace;
    }

    @Column(name="stuFace",nullable=true)
    private String stuFace;

    public Student() {
    }
}
