package com.eazybytes.accounts.service;

import com.eazybytes.accounts.dto.CustomerDto;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public interface IAccountsService {
    void createAccount(CustomerDto customerDto);
}
