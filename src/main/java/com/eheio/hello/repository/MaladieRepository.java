package com.eheio.hello.repository;

import com.eheio.hello.model.Maladie;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MaladieRepository implements IMaladieRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
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
    public int addMaladie(Maladie maladie) {
        this.getCurrentSession().save(maladie);
        Query query =
                this.getCurrentSession().createQuery("select max(maladieId) from maladie");
        return Integer.parseInt(query.getSingleResult().toString());
    }

    @Override
    public Maladie findById(int id) {
        Query<Maladie > query =
                this.getCurrentSession().createQuery("from maladie where maladie_id=:id");
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public int numberOfMaladies(String libelle) {
        Query query =
                this.getCurrentSession().createQuery("select count(1) from maladie where libelle=:libelle");
        query.setParameter("libelle",libelle);
        return Integer.parseInt(query.getSingleResult().toString());
    }
}
