package com.eheio.hello.repository;

import com.eheio.hello.model.Mesure;
import com.eheio.hello.model.MesureConsultation;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MesureConsultationRepository implements IMesureConsultationRepository {
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
    public void addMesureConsultation(MesureConsultation mesureConsultation) {
        this.getCurrentSession().save(mesureConsultation);
    }

    @Override
    public List<MesureConsultation> findAll() {
        Query<MesureConsultation> query =
                this.getCurrentSession().createQuery("from mesure_consultation");
        /*List<MesureConsultation> liste = query.getResultList();
        for(MesureConsultation elem:liste){
            System.out.println(elem.getConsultation());
        }*/
        return query.getResultList();
    }
}
