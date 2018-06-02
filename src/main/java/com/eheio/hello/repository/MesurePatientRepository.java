package com.eheio.hello.repository;

import com.eheio.hello.model.Consultation;
import com.eheio.hello.model.MesurePatient;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MesurePatientRepository implements IMesurePatientRepository {
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
    public List<MesurePatient> findAll() {
        Query<MesurePatient> query =
                this.getCurrentSession().createQuery("from mesure_patient");
        return query.getResultList();
    }

    @Override
    public MesurePatient findById(int id) {
        Query<MesurePatient> query =
                this.getCurrentSession().createQuery("from mesure_patient where id=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public List<MesurePatient> findByPatient(int id) {
        Query<MesurePatient> query =
                this.getCurrentSession().createQuery("from mesure_patient where patient_id=:id");
        query.setParameter("id",id);
        return query.getResultList();
    }

    @Override
    public void addMesure(MesurePatient mesurePatient) {
        this.getCurrentSession().save(mesurePatient);
    }
}
