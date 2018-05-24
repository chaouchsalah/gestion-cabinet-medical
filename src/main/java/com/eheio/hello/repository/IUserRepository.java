package com.eheio.hello.repository;

import com.eheio.hello.model.User;
import java.util.List;

/**
 * . @author Salah eddine
 */
public interface IUserRepository {
  /**
   * . Look for a user by id
   * @param userId is the id of user patient to look for
   * @return user if found
   */
  public User findById(int userId);
  
  /**
   * . Looks for a user by username
   * @param username the username of the user to look for
   * @return user if found
   */
  public User findByUserName(String username);
  
  /**
   * . Look for all users
   */
  public List<User> findAll();

  /**
   * . Add a user
   */
  public void addUser(User user);

  /**
   * . Update a user
   */
  public void updateUser(User user);

  /**
   * . Delete a user
   */
  public void deleteUser(int userId);
}
