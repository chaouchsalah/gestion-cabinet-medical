package com.eheio.hello.repository;

import com.eheio.hello.model.UserInfo;
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
  public UserInfo findById(int userId);
  
  /**
   * . Looks for a user by username
   * @param username the username of the user to look for
   * @return user if found
   */
  public UserInfo findByUserName(String username);
  
  public UserInfo findMedecinData(String username);
  
  public UserInfo findPatientData(String username);
  
  /**
   * . Look for all users
   */
  public List<UserInfo> findAll();

  /**
   * . Add a user
   */
  public void addUser(UserInfo user);

  /**
   * . Update a user
   */
  public void updateUser(UserInfo user);

  /**
   * . Delete a user
   */
  public void deleteUser(int userId);
}
