package com.psv.resultanalyzer.service;

import com.psv.resultanalyzer.models.CustomerDto;

public interface IAccountService {

    // Method to create a new account for a customer
    public void createAccount(CustomerDto customerDto);
}
