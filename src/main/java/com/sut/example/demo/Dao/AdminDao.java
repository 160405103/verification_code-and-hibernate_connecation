package com.sut.example.demo.Dao;

import com.sut.example.demo.Model.Admin;
import com.sut.example.demo.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.security.auth.login.Configuration;
import java.util.Iterator;
import java.util.List;

public class AdminDao {

    private static HibernateUtil hi=HibernateUtil.getInstance();
    private static SessionFactory factory=hi.getSessionFactory();
    public Integer addAdmin(int uuid, String adminId, String adminName, String adminPwd){
        Session session=factory.openSession();
        Transaction tx = null;
        Integer id = null;
        try {
            tx = session.beginTransaction();
            Admin admin = new Admin(uuid,adminId,adminName,adminPwd);
            id = (Integer) session.save(admin);
            tx.commit();
        }catch (HibernateException e) {
            if(tx!=null){ tx.rollback(); }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return id;
    }

    public void listAdmins( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List admins = session.createQuery("FROM Admin ").list();
            for (Iterator iterator = admins.iterator(); iterator.hasNext();){
                Admin admin = (Admin) iterator.next();
                System.out.println("*******Admin uuid: " + admin.getUuid());
                System.out.println("*******Admin Id: " + admin.getAdminId());
                System.out.println("*******Admin Name: " + admin.getAdminName());
                System.out.println("*******Admin Pwd: " + admin.getAdminPwd());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }

    }

        public void updateAdmin(Integer uuid, String password ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Admin admin = (Admin) session.get(Admin.class, uuid);
            admin.setAdminPwd( password );
            session.update(admin);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
        public void deleteAdmin(String adminId){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            //String sql = "from Admin admin where admin.adminId = '"+adminId+"'";
            //Admin admin = (Admin) session.get(Admin.class, adminId);
            Criteria cr = session.createCriteria(Admin.class);
            cr.add(Restrictions.eq("adminId", adminId));
            List<Admin> admins = cr.list();
            //List<Admin> admins = session.createQuery(sql).list();
            if(admins != null){
                for (Admin admin:admins){
                    session.delete(admin);
                }
            }else {
                System.out.println("*******************Delete fail,No such admin");
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }



}
