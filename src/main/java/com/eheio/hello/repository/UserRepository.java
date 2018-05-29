package com.eheio.hello.repository;

import com.eheio.hello.model.UserInfo;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class UserRepository implements IUserRepository {
  @Autowired
  private SessionFactory sessionFactory;
  
  protected final Session getCurrentSession() { 
    return sessionFactory.getCurrentSession();
  }
  
  @Override
  public UserInfo findById(int userId) {
    @SuppressWarnings("unchecked")
    Query<UserInfo> query = 
        this.getCurrentSession().createQuery("from user where user_id = ?");
    query.setParameter("user_id", userId);
    return query.uniqueResult();
  }

  @Override
  public List<UserInfo> findAll() {
    @SuppressWarnings("unchecked")
    Query<UserInfo> query = 
        this.getCurrentSession().createQuery("from user");
    return query.getResultList();
  }

  @Override
  public void addUser(UserInfo user) {
    this.getCurrentSession().persist(user);
  }

  @Override
  public void updateUser(UserInfo user) {
    this.getCurrentSession().persist(user);
  }

  @Override
  public void deleteUser(int userId) {
    UserInfo user = 
        this.getCurrentSession().load(UserInfo.class, new Integer(userId));
    if (user != null) {
      this.getCurrentSession().delete(user);
    }

  }

  @Override
  public UserInfo findByUserName(String username) {
    org.springframework.security.crypto.password.PasswordEncoder encoder
            = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
    String passwd = encoder.encode("salah2");
    System.out.println(passwd);
    Query query =
        this.getCurrentSession().createQuery("from user where username = :username");
    query.setParameter("username", username);
    return (UserInfo) query.uniqueResult();
  }

  @Override
  public UserInfo findMedecinData(String username) {
      Query query =
            this.getCurrentSession().createQuery("from user where username = :username and role='ROLE_MEDECIN'");
    query.setParameter("username", username);
    return (UserInfo) query.uniqueResult();
  }

  @Override
  public UserInfo findPatientData(String username) {
    Query query =
            this.getCurrentSession().createQuery("from user where username = :username and role='ROLE_PATIENT'");
    query.setParameter("username", username);
    return (UserInfo) query.uniqueResult();
  }

}
