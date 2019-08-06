package com.sut.example.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "resource")
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resId;
    @Column(name = "resName",nullable = false)
    private String resName;
    @Column(name = "upTeacher",nullable = false)
    private String upTeacher;
    @Column(name = "upTime",nullable = false)
    private Date upTime;
    @Column(name = "courseId",nullable = false)
    private int courseId;
    @Column(name = "downCount",nullable = false)
    private int downCount;
    @Column(name = "teacherId",nullable = false)
    private int teacherId;
    @Column(name = "resLink",nullable = false)
    private String resLink;

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getUpTeacher() {
        return upTeacher;
    }

    public void setUpTeacher(String upTeacher) {
        this.upTeacher = upTeacher;
    }

    public Date getUpTime() {
        return upTime;
    }

    public void setUpTime(Date upTime) {
        this.upTime = upTime;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getDownCount() {
        return downCount;
    }

    public void setDownCount(int downCount) {
        this.downCount = downCount;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getResLink() {
        return resLink;
    }

    public void setResLink(String resLink) {
        this.resLink = resLink;
    }

    public Resource() {
    }

    public Resource(String resName, String upTeacher, Date upTime, int courseId, int downCount, int teacherId, String resLink) {
        this.resName = resName;
        this.upTeacher = upTeacher;
        this.upTime = upTime;
        this.courseId = courseId;
        this.downCount = downCount;
        this.teacherId = teacherId;
        this.resLink = resLink;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "resId=" + resId +
                ", resName='" + resName + '\'' +
                ", upTeacher='" + upTeacher + '\'' +
                ", upTime=" + upTime +
                ", courseId=" + courseId +
                ", downCount=" + downCount +
                ", teacherId=" + teacherId +
                ", resLink='" + resLink + '\'' +
                '}';
    }
}
