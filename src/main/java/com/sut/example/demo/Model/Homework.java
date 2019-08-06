package com.sut.example.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homework")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int homeWorkId;
    @Column(name="courseId",nullable = false)
    private int courseId;
    @Column(name="homeWorkTimes",nullable = false)
    private int homeWorkTimes;
    @Column(name="homeWorkDeadline",nullable = false)
    private Date homeWorkDeadline;
    @Column(name="homeWorkTitle",nullable = false)
    private String homeWorkTitle;
    @Column(name="homeWorkContent",nullable = false)
    private String homeWorkContent;
    @Column(name="homeWorkFile",nullable = true)
    private String homeWorkFile;

    public int getHomeWorkId() {
        return homeWorkId;
    }

    public void setHomeWorkId(int homeWorkId) {
        this.homeWorkId = homeWorkId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getHomeWorkTimes() {
        return homeWorkTimes;
    }

    public void setHomeWorkTimes(int homeWorkTimes) {
        this.homeWorkTimes = homeWorkTimes;
    }

    public Date getHomeWorkDeadline() {
        return homeWorkDeadline;
    }

    public void setHomeWorkDeadline(Date homeWorkDeadline) {
        this.homeWorkDeadline = homeWorkDeadline;
    }

    public String getHomeWorkTitle() {
        return homeWorkTitle;
    }

    public void setHomeWorkTitle(String homeWorkTitle) {
        this.homeWorkTitle = homeWorkTitle;
    }

    public String getHomeWorkContent() {
        return homeWorkContent;
    }

    public void setHomeWorkContent(String homeWorkContent) {
        this.homeWorkContent = homeWorkContent;
    }

    public String getHomeWorkFile() {
        return homeWorkFile;
    }

    public void setHomeWorkFile(String homeWorkFile) {
        this.homeWorkFile = homeWorkFile;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Column(name="semester",nullable = true)
    private String semester;

    public Homework() {
    }

    public Homework(int courseId, int homeWorkTimes, Date homeWorkDeadline, String homeWorkTitle, String homeWorkContent, String homeWorkFile, String semester) {
        this.courseId = courseId;
        this.homeWorkTimes = homeWorkTimes;
        this.homeWorkDeadline = homeWorkDeadline;
        this.homeWorkTitle = homeWorkTitle;
        this.homeWorkContent = homeWorkContent;
        this.homeWorkFile = homeWorkFile;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "homeWorkId=" + homeWorkId +
                ", courseId=" + courseId +
                ", homeWorkTimes='" + homeWorkTimes + '\'' +
                ", homeWorkDeadline='" + homeWorkDeadline + '\'' +
                ", homeWorkTitle='" + homeWorkTitle + '\'' +
                ", homeWorkContent='" + homeWorkContent + '\'' +
                ", homeWorkFile='" + homeWorkFile + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
