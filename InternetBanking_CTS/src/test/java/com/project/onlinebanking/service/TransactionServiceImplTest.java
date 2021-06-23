package com.project.onlinebanking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.onlinebanking.entity.Recipient;
import com.project.onlinebanking.entity.User;
import com.project.onlinebanking.repository.RecipientDao;
import com.project.onlinebanking.service.UserServiceImpl.TransactionServiceImpl;

class TransactionServiceImplTest {
	@InjectMocks
	TransactionServiceImpl users;
	@Mock
	RecipientDao rdao;
	Recipient reci=new Recipient("Weilong");

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testFindRecipientByName() {
		when(rdao.findByName("Weilong")).thenReturn(reci);
		assertEquals(users.findRecipientByName("Weilong"),reci);
	}

	

}
