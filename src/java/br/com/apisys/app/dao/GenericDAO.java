/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.apisys.app.dao;

import br.com.apisys.app.dao.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author VICTOR
 */
public class GenericDAO<T> {
    private Class<T> classe;

    public void save(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.save(t);
        tr.commit();
        session.close();
    }

    public T getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T t = (T)session.get(classe, id);
        session.close();
        return t;
    }

    public List<T> list() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        List<T> lista = session.createQuery("from Usuario").list();
        t.commit();
        session.close();
        return lista;
    }

    public void remove(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.delete(t);
        tr.commit();
        session.close();
    }

    public void update(T t) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = session.beginTransaction();
        session.update(t);
        tr.commit();
        session.close();
    }
}
