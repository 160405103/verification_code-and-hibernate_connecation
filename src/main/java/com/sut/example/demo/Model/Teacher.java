package com.sut.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;
    @Column(name="teacherId",nullable=false)
    private String teacherId;
    @Column(name="teacherName",nullable=false)
    private String teacherName;
    @Column(name="teacherPwd",nullable=false)
    private String teacherPwd;

    public Teacher(String teacherId, String teacherName, String teacherPwd) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherPwd = teacherPwd;
    }

    public Teacher() {
    }

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uuid=" + uuid +
                ", teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPwd='" + teacherPwd + '\'' +
                '}';
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }
}
