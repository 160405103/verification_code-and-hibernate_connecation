package com.sut.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cuuid;
    @Column(name = "cId",nullable = false)
    private int cId;
    @Column(name = "cName",nullable = false)
    private String cName;
    @Column(name = "cImageLink",nullable = false)
    private String cImageLink;

    @Override
    public String toString() {
        return "Course{" +
                "cuuid=" + cuuid +
                ", cId=" + cId +
                ", cName='" + cName + '\'' +
                ", cImageLink='" + cImageLink + '\'' +
                ", cMajor='" + cMajor + '\'' +
                ", cGrade='" + cGrade + '\'' +
                ", teacherId=" + teacherId +
                ", cSemester='" + cSemester + '\'' +
                '}';
    }

    public int getCuuid() {
        return cuuid;
    }

    public void setCuuid(int cuuid) {
        this.cuuid = cuuid;
    }

    public int getCId() {
        return cId;
    }

    public void setCId(int cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcImageLink() {
        return cImageLink;
    }

    public void setcImageLink(String cImageLink) {
        this.cImageLink = cImageLink;
    }

    public String getcMajor() {
        return cMajor;
    }

    public void setcMajor(String cMajor) {
        this.cMajor = cMajor;
    }

    public String getcGrade() {
        return cGrade;
    }

    public void setcGrade(String cGrade) {
        this.cGrade = cGrade;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getcSemester() {
        return cSemester;
    }

    public void setcSemester(String cSemester) {
        this.cSemester = cSemester;
    }

    @Column(name = "cMajor",nullable = true)
    private String cMajor;
    @Column(name = "cGrade",nullable = true)
    private String cGrade;
    @Column(name = "teacherId",nullable = false)
    private int teacherId;
    @Column(name = "cSemester",nullable = false)
    private String cSemester;
}
