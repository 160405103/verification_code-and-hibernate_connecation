package com.sut.example.demo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final HibernateUtil hibernateUtil=new HibernateUtil();
    private HibernateUtil(){
    }
    public static HibernateUtil getInstance(){
        return hibernateUtil;
    }
    static{
        Configuration cfg = new Configuration();
        cfg.configure();
        sessionFactory = cfg.buildSessionFactory();
    }
    /*
    * 获取Hibernate Session
    * */
    public  SessionFactory getSessionFactory(){
        return sessionFactory;
    }
   /* public  Session getSession(){
        return sessionFactory.openSession();
    }*/
}
