package com.project.onlinebanking.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.project.onlinebanking.entity.PrimaryAccount;
import com.project.onlinebanking.entity.SavingsAccount;
import com.project.onlinebanking.repository.PrimaryAccountDao;
import com.project.onlinebanking.repository.SavingsAccountDao;
import com.project.onlinebanking.service.UserServiceImpl.AccountServiceImpl;

class AccountServiceImplTest {
	@InjectMocks
	AccountServiceImpl acc;
	@Mock
	PrimaryAccountDao pdao;
	@Mock
	SavingsAccountDao sdao;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	final void testCreatePrimaryAccount() {
		PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new BigDecimal(0.0));
        primaryAccount.setAccountNumber(123123);
        when(pdao.save(primaryAccount)).thenReturn(primaryAccount);

        when(pdao.findByAccountNumber(primaryAccount.getAccountNumber())).thenReturn(primaryAccount);
        assertNull(acc.createPrimaryAccount());
        
		


	}

	@Test
	final void testCreateSavingsAccount() {
		SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setAccountBalance(new BigDecimal(0.0));
        savingsAccount.setAccountNumber(121145);

        when(sdao.save(savingsAccount)).thenReturn(savingsAccount);

        when(sdao.findByAccountNumber(savingsAccount.getAccountNumber())).thenReturn(savingsAccount);
        assertNull(acc.createSavingsAccount());
	}

}
