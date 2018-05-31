package com.eheio.hello.service;

import com.eheio.hello.model.UserInfo;
import com.eheio.hello.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
  @Autowired
  private IUserRepository userRepository;

  @Override
  public final UserInfo getMedecinData(String userName) {
    return userRepository.findMedecinData(userName);
  }

  @Override
  public final UserInfo getPatientData(String userName) {
    return userRepository.findPatientData(userName);
  }

  @Override
  public final UserInfo getDataByUserName(String userName) {
    return userRepository.findByUserName(userName);
  }

  @Override
  public final void register(UserInfo user) {
    userRepository.addUser(user);
  }

}
