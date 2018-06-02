package com.eheio.hello.repository;

import com.eheio.hello.model.Consultation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class ConsultationRepository implements IConsultationRepository {
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
    public List<Consultation> findAll() {
        Query<Consultation> query =
                this.getCurrentSession().createQuery("from consultation");
        return query.getResultList();
    }

    @Override
    public Consultation findById(int id) {
        Query<Consultation> query =
                this.getCurrentSession().createQuery("from consultation where consultationId=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public int addConsultation(Consultation consultation) {
        this.getCurrentSession().save(consultation);
        Query query =
                this.getCurrentSession().createQuery("select max(consultationId) from consultation");
        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public int findLastConsultation() {
        Query query =
                this.getCurrentSession().createQuery("select consultationId from consultation order by date_consultation desc").setMaxResults(1);
        return Integer.parseInt(query.getSingleResult().toString());
    }
}
