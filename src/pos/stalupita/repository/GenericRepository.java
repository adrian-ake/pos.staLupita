/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos.stalupita.repository;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author adrian.ake
 */
@Repository
public class GenericRepository implements GenericDAOI {

    @Resource
    private SessionFactory sessionFactory;

    @Autowired
    public GenericRepository(SessionFactory sessionfactoryr) {
        this.sessionFactory = sessionfactoryr;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        Session session = null;
        if (this.getSessionFactory().getCurrentSession() == null) {
            session = this.getSessionFactory().openSession();
        } else {
            session = this.getSessionFactory().getCurrentSession();
        }
        if (!session.getTransaction().isActive()) {
            session.beginTransaction();
        }
        return session;
    }

    @Override
    public void save(Object obj) {
        this.getSession().save(obj);
        this.getSession().getTransaction().commit();
    }

    @Override
    public void saveOrUpdate(Object obj) {
        this.getSession().flush();
        this.getSession().clear();

        this.getSession().saveOrUpdate(obj);
        this.getSession().getTransaction().commit();
    }

}
