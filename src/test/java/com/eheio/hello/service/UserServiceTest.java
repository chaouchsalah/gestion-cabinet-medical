package com.eheio.hello.service;

import com.eheio.hello.model.UserInfo;
import com.eheio.hello.repository.IUserRepository;
import com.eheio.hello.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class UserServiceTest {
    @Mock
    IUserRepository userRepository;
    @Mock
    UserInfo user;

    @InjectMocks
    private UserService service;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAllPatients() {
        List<UserInfo> users = new ArrayList<>();
        user.setUserId(1);
        users.add(user);
        user.setUserId(2);
        users.add(user);
        when(service.getAllPatients()).thenReturn(users);
        assertEquals(users.size(), service.getAllPatients().size());
    }
}
