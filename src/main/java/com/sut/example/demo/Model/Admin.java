package com.sut.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Admin {
    public Admin() {
    }

    public Admin(int uuid, String adminId, String adminName, String adminPwd) {
        this.uuid = uuid;
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "uuid=" + uuid +
                ", adminId='" + adminId + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                '}';
    }


    private int uuid;

    public int getUuid() {
        return uuid;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    private String adminId;
    private String adminName;
    private String adminPwd;
}
