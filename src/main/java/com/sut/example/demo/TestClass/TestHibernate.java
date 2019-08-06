package com.sut.example.demo.TestClass;


import com.sut.example.demo.Model.Admin;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.List;


public class TestHibernate {
    private static SessionFactory factory;
    /*
    第一步:加载hibernate默认配置文件hibernate.cfg.xml，如果文件名不同则configure("xxx.xml");
    第二步::创建服务注册构建器对象，通过配置对象中加载所有的配置信息并注册服务
			Configuration config = new Configuration().configure();
						ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()	.applySettings(config.getProperties()).build();
	第三步:创建会话工厂
	         sessionFactory = config.buildSessionFactory(serviceRegistry);

     */
    public static void main(String[] args){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable e){
            e.printStackTrace();
        }
        TestHibernate test = new TestHibernate();
        Integer admin0 = test.addAdmin(6,"up6","upnew6","1234566");
        System.out.println("插入数据为"+admin0);
        test.listAdmins();
        //test.updateAdmin(3,"updatePassword");
       // test.deleteAdmin("110");
        System.out.println("完成");

    }

    /* Method to  ADD  admin */
    public Integer addAdmin(int uuid, String adminId, String adminName, String adminPwd){
        Session session = factory.openSession();
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

    /* Method to  READ all the admins */
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

//    /* Method to UPDATE password for an admin */
//    public void updateAdmin(Integer uuid, String password ){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            Admin admin = (Admin) session.get(Admin.class, uuid);
//            admin.setAdminPwd( password );
//            session.update(admin);
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
//    /* Method to DELETE an admin from the records */
//    public void deleteAdmin(String adminId){
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try{
//            tx = session.beginTransaction();
//            //String sql = "from Admin admin where admin.adminId = '"+adminId+"'";
//            //Admin admin = (Admin) session.get(Admin.class, adminId);
//            Criteria cr = session.createCriteria(Admin.class);
//            cr.add(Restrictions.eq("adminId", adminId));
//            List<Admin> admins = cr.list();
//            //List<Admin> admins = session.createQuery(sql).list();
//            if(admins != null){
//                for (Admin admin:admins){
//                    session.delete(admin);
//                }
//            }else {
//                System.out.println("*******************Delete fail,No such admin");
//            }
//            tx.commit();
//        }catch (HibernateException e) {
//            if (tx!=null) tx.rollback();
//            e.printStackTrace();
//        }finally {
//            session.close();
//        }
//    }
}
