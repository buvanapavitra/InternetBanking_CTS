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
import com.project.onlinebanking.service.UserServiceImpl.UserSecurityServiceImpl;
import com.project.onlinebanking.service.UserServiceImpl.UserServiceImpl;

class UserSecurityServiceImplTest {
	
	@InjectMocks
	UserSecurityServiceImpl users;
	@Mock
	UserDao dao;
	User user=new User("Priya","priya@gmail.com");

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testLoadUserByUsername() {
		when(dao.findByUsername("Priya")).thenReturn(user);
		assertEquals(users.loadUserByUsername("Priya"),user);
	}

}
