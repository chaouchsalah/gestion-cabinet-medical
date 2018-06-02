package com.eheio.hello.repository;

import com.eheio.hello.model.UserInfo;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository implements IUserRepository {
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
  public final UserInfo findById(int userId) {
    @SuppressWarnings("unchecked")
    Query query = this.getCurrentSession().createQuery("from user where user_id = :id");
    query.setParameter("id", userId);
    return (UserInfo) query.uniqueResult();
  }

  @Override
  public final List<UserInfo> findAll() {
    @SuppressWarnings("unchecked")
    Query<UserInfo> query = 
        this.getCurrentSession().createQuery("from user");
    return query.getResultList();
  }

  @Override
  public List<UserInfo> findAllPatients() {
    Query<UserInfo> query =
            this.getCurrentSession().createQuery("from user where role='ROLE_PATIENT'");
    return query.getResultList();
  }

  @Override
  public final void addUser(UserInfo user) {
    this.getCurrentSession().save(user);
  }

  @Override
  public final void updateUser(UserInfo user) {
    this.getCurrentSession().persist(user);
  }

  @Override
  public final void deleteUser(int userId) {
    UserInfo user = 
        this.getCurrentSession().load(UserInfo.class, Integer.valueOf(userId));
    if (user != null) {
      this.getCurrentSession().delete(user);
    }

  }

  @Override
  public int findIdByUsername(String username) {
    Query query =
            this.getCurrentSession().createQuery("select id from user where username = :username");
    query.setParameter("username", username);
    return Integer.parseInt(query.uniqueResult().toString());
  }

  @Override
  public final UserInfo findByUserName(String username) {
    Query query =
        this.getCurrentSession().createQuery("from user where username = :username");
    query.setParameter("username", username);
    return (UserInfo) query.uniqueResult();
  }

  @Override
  public final UserInfo findMedecinData(String username) {
      Query query =
            this.getCurrentSession().createQuery("from user where username = :username and role='ROLE_MEDECIN'");
    query.setParameter("username", username);
    return (UserInfo) query.uniqueResult();
  }

  @Override
  public UserInfo findPatientData(int id) {
    Query query =
            this.getCurrentSession().createQuery("from user where user_id = :id and role='ROLE_PATIENT'");
    query.setParameter("id", id);
    return (UserInfo) query.uniqueResult();
  }

}
