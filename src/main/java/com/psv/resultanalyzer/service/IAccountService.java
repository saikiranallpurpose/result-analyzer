package com.psv.resultanalyzer.service;

import com.psv.resultanalyzer.models.CustomerAccountDto;
import com.psv.resultanalyzer.models.CustomerDto;

public interface IAccountService {

    // Method to create a new account for a customer
    void createAccount(CustomerDto customerDto);

    CustomerAccountDto getAccountByMobileNumber(String mobileNumber);

    void updateCustomerAccount(CustomerAccountDto customerAccountDto);
}
