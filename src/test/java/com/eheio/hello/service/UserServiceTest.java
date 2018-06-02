package com.eheio.hello.service;

import com.eheio.hello.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceTest {
    @Autowired
    UserService userService;
    @Before
    public void setUp() {
        UserRepository userRepository = mock(UserRepository.class);
    }


    @org.junit.jupiter.api.Test
    public void testFindAll() {
    }
}
