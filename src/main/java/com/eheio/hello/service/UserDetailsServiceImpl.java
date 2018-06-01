package com.eheio.hello.service;

import com.eheio.hello.model.UserInfo;
import com.eheio.hello.repository.IUserRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  private IUserRepository userRepository;
  
  @Override
  public final UserDetails loadUserByUsername(String username) {
    UserInfo user = userRepository.findByUserName(username);
    GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
    return new User(user.getUsername(),
        user.getPassword(), Arrays.asList(authority));
  }

}
