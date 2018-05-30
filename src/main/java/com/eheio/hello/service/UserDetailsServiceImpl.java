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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  IUserRepository userRepository;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserInfo user = userRepository.findByUserName(username);
    GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
    UserDetails userDetails = new User(user.getUsername(),
        user.getPassword(), Arrays.asList(authority));
    return userDetails;
  }

}
