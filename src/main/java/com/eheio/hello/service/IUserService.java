package com.eheio.hello.service;

import com.eheio.hello.model.UserInfo;
import org.springframework.security.access.annotation.Secured;

public interface IUserService {

  @Secured({"ROLE_MEDECIN"})
  UserInfo getMedecinData(String userName);
  
  @Secured ({"ROLE_PATIENT","ROLE_MEDECIN"})
  UserInfo getPatientData(String userName);
  
  @Secured ({"ROLE_PATIENT","ROLE_MEDECIN"})
  UserInfo getDataByUserName(String userName);

  void register(UserInfo user);

}
