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
import com.project.onlinebanking.service.UserServiceImpl.UserServiceImpl;

class UserServiceImplTest {
	@InjectMocks
	UserServiceImpl users;
	@Mock
	UserDao dao;
	User user=new User("Priya","priya@gmail.com");

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testFindByUsername() {
		when(dao.findByUsername("Priya")).thenReturn(user);
		assertEquals(users.findByUsername("Priya"),user);
	}

	@Test
	final void testFindByEmail() {
		when(dao.findByEmail("priya@gmail.com")).thenReturn(user);
		assertEquals(users.findByEmail("priya@gmail.com"),user);
	}

	@Test
	final void testCheckUserExists() {
		when(dao.findByUsername("Priya")).thenReturn(user);
		when(dao.findByEmail("priya@gmail.com")).thenReturn(user);
		assertTrue(users.checkUserExists("Priya", "priya@gmail.com"));
		
		
	}

	
	@Test
	final void testCheckUsernameExists() {
		when(dao.findByUsername("Priya")).thenReturn(user);
		assertTrue(users.checkUsernameExists("Priya"));
		
	}

	@Test
	final void testCheckEmailExists() {
		when(dao.findByEmail("priya@gmail.com")).thenReturn(user);
		assertTrue(users.checkEmailExists("priya@gmail.com"));
	}

}
