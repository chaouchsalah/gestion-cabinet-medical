package com.eheio.hello.repository;

import com.eheio.hello.model.Consultation;
import com.eheio.hello.model.Mesure;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MesureRepository implements IMesureRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        Session session;
        try
        {
            session = sessionFactory.getCurrentSession();
        }
        catch (HibernateException e)
        {
            session = sessionFactory.openSession();
        }
        return session;
    }

    @Override
    public List<Mesure> findAll() {
        Query<Mesure> query =
                this.getCurrentSession().createQuery("from mesure");
        return query.getResultList();
    }

    @Override
    public Mesure findById(int id) {
        Query<Mesure> query =
                this.getCurrentSession().createQuery("from mesure where mesure_id=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }
}
