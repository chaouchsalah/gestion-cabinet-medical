package com.eheio.hello.service;

import com.eheio.hello.model.UserInfo;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface IUserService {

  @Secured({"ROLE_MEDECIN"})
  UserInfo getMedecinData(String userName);
  
  @Secured ({"ROLE_PATIENT","ROLE_MEDECIN"})
  UserInfo getPatientData(String userName);
  @Secured ({"ROLE_PATIENT","ROLE_MEDECIN"})
  List<UserInfo> getAllPatients();
  
  @Secured ({"ROLE_PATIENT","ROLE_MEDECIN"})
  UserInfo getDataByUserName(String userName);

  void register(UserInfo user);
  UserInfo findById(int id);
  int findIdByUsername(String username);

}
