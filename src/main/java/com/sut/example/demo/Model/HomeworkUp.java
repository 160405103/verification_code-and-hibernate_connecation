package com.sut.example.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "homework_up")
public class HomeworkUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fileId;
    @Column(name = "stuId",nullable = false)
    private int stuId;
    @Column(name = "stuName",nullable = true)
    private String stuName;
    @Column(name = "courseId",nullable = false)
    private String courseId;
    @Column(name = "homeworkTimes",nullable = false)
    private int homeworkTimes;
    @Column(name = "fileUpName",nullable = false)
    private String fileUpName;
    @Column(name = "fileUpLoadTime",nullable = false)
    private Date fileUpLoadTime;
    @Column(name = "allowLook",nullable = false)
    private int allowLook;
    @Column(name = "downCount",nullable = false)
    private int downCount;
    @Column(name = "fileLink",nullable = true)
    private String fileLink;
    @Column(name = "looked",nullable = true)
    private String looked;

    public int getFileId() {
        return fileId;
    }

    public void setFileId(int fileId) {
        this.fileId = fileId;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getHomeworkTimes() {
        return homeworkTimes;
    }

    public void setHomeworkTimes(int homeworkTimes) {
        this.homeworkTimes = homeworkTimes;
    }

    public String getFileUpName() {
        return fileUpName;
    }

    public void setFileUpName(String fileUpName) {
        this.fileUpName = fileUpName;
    }

    public Date getFileUpLoadTime() {
        return fileUpLoadTime;
    }

    public void setFileUpLoadTime(Date fileUpLoadTime) {
        this.fileUpLoadTime = fileUpLoadTime;
    }

    public int getAllowLook() {
        return allowLook;
    }

    public void setAllowLook(int allowLook) {
        this.allowLook = allowLook;
    }

    public int getDownCount() {
        return downCount;
    }

    public void setDownCount(int downCount) {
        this.downCount = downCount;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    public String getLooked() {
        return looked;
    }

    public void setLooked(String looked) {
        this.looked = looked;
    }

    public HomeworkUp() {
    }

    public HomeworkUp(int stuId, String stuName, String courseId, int homeworkTimes, String fileUpName, Date fileUpLoadTime, int allowLook, int downCount, String fileLink, String looked) {
        //this.fileId = fileId;
        this.stuId = stuId;
        this.stuName = stuName;
        this.courseId = courseId;
        this.homeworkTimes = homeworkTimes;
        this.fileUpName = fileUpName;
        this.fileUpLoadTime = fileUpLoadTime;
        this.allowLook = allowLook;
        this.downCount = downCount;
        this.fileLink = fileLink;
        this.looked = looked;
    }

    @Override
    public String toString() {
        return "HomeworkUp{" +
                "fileId=" + fileId +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", courseId='" + courseId + '\'' +
                ", homeworkTimes=" + homeworkTimes +
                ", fileUpName='" + fileUpName + '\'' +
                ", fileUpLoadTime=" + fileUpLoadTime +
                ", allowLook=" + allowLook +
                ", downCount=" + downCount +
                ", fileLink='" + fileLink + '\'' +
                ", looked='" + looked + '\'' +
                '}';
    }
}
