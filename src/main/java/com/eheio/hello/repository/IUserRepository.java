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
  UserInfo findById(int userId);
  
  /**
   * . Looks for a user by username
   * @param username the username of the user to look for
   * @return user if found
   */
  UserInfo findByUserName(String username);
  
  UserInfo findMedecinData(String username);
  
  UserInfo findPatientData(String username);
  
  /**
   * . Look for all users
   */
  List<UserInfo> findAll();

  List<UserInfo> findAllPatients();

  /**
   * . Add a user
   */
  void addUser(UserInfo user);

  /**
   * . Update a user
   */
  void updateUser(UserInfo user);

  /**
   * . Delete a user
   */
  void deleteUser(int userId);
}
