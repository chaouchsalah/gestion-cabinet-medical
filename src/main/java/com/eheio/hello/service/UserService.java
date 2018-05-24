package com.eheio.hello.service;

import com.eheio.hello.model.User;
import com.eheio.hello.repository.IUserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
  @Autowired
  IUserRepository userRepository;
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUserName(username);
    GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
    UserDetails userDetails = (UserDetails) new User(user.getLogin(),
        user.getPassword(), Arrays.asList(authority));
    return null;
  }

}
