package com.eheio.hello.repository;

import com.eheio.hello.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository {
  @Autowired
  private SessionFactory sessionFactory;
  
  protected final Session getCurrentSession() { 
    return sessionFactory.getCurrentSession();
  }
  
  @Override
  public User findById(int userId) {
    @SuppressWarnings("unchecked")
    Query<User> query = 
        this.getCurrentSession().createQuery("from user where user_id = ?");
    query.setParameter("user_id", userId);
    return (User) query.uniqueResult();
  }

  @Override
  public List<User> findAll() {
    @SuppressWarnings("unchecked")
    Query<User> query = 
        this.getCurrentSession().createQuery("from user");
    return query.getResultList();
  }

  @Override
  public void addUser(User user) {
    this.getCurrentSession().persist(user);
  }

  @Override
  public void updateUser(User user) {
    this.getCurrentSession().persist(user);
  }

  @Override
  public void deleteUser(int userId) {
    User user = 
        (User) this.getCurrentSession().load(User.class, new Integer(userId));
    if (user != null) {
      this.getCurrentSession().delete(user);
    }

  }

  @Override
  public User findByUserName(String username) {
    @SuppressWarnings("unchecked")
    Query<User> query = 
        this.getCurrentSession().createQuery("from user where login = ?");
    query.setParameter("login", username);
    return (User) query.uniqueResult();
  }

}
