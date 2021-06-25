package com.project.onlinebanking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.onlinebanking.entity.User;
import com.project.onlinebanking.repository.UserDao;
import com.project.onlinebanking.service.UserServiceImpl.UserSecurityService;

class UserSecurityServiceTest {
	@InjectMocks
	UserSecurityService users;
	@Mock
	UserDao udao;
	User user=new User("xyxy","xyxy@gmail.com");

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testLoadUserByUsername() {
		when(udao.findByUsername("xyxy")).thenReturn(user);
		assertEquals(users.loadUserByUsername("xyxy"),user);
	}

}
