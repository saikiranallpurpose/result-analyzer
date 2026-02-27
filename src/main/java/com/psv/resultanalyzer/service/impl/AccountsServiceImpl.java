package com.psv.resultanalyzer.service.impl;

import com.psv.resultanalyzer.entity.Accounts;
import com.psv.resultanalyzer.entity.Customer;
import com.psv.resultanalyzer.exception.ResultsError;
import com.psv.resultanalyzer.mapper.CustomerMapper;
import com.psv.resultanalyzer.models.CustomerAccountDto;
import com.psv.resultanalyzer.models.CustomerDto;
import com.psv.resultanalyzer.repository.AccountsRepository;
import com.psv.resultanalyzer.repository.CustomerRepository;
import com.psv.resultanalyzer.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountService {

    AccountsRepository accountsRepository;
    CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        validateCustomer(customerDto.getMobileNumber());

        Customer customer = CustomerMapper.mapDtoToEntity(customerDto);
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("System");

        Customer savedCustomer = customerRepository.save(customer);

        Accounts accounts = createAccount(savedCustomer);

        accountsRepository.save(accounts);
    }

    @Override
    public CustomerAccountDto getAccountByMobileNumber(String mobileNumber) {
        Optional<Customer> customerOpt = customerRepository.findByMobileNumber(mobileNumber);
        if (customerOpt.isEmpty()) {
            throw ResultsError.CUSTOMER_NOT_FOUND.toException("mobileNumber", mobileNumber);
        }

        Customer customer = customerOpt.get();
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> ResultsError.ACCOUNT_NOT_FOUND.toException("customerId", customer.getName()));

        return CustomerAccountDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .accountNumber(accounts.getAccountId())
                .accountType(accounts.getAccountType())
                .branchAddress(accounts.getBranchAddress())
                .build();
    }

    private Accounts createAccount(Customer savedCustomer) {
        return Accounts.builder()
                .accountId(generateAccountId())
                .customerId(savedCustomer.getCustomerId())
                .accountType("Savings")
                .branchAddress("123 Main St")
                .createdAt(LocalDateTime.now())
                .createdBy("System")
                .build();
    }

    private void validateCustomer(String mobileNumber) {
        customerRepository.findByMobileNumber(mobileNumber).ifPresent(c -> {
            throw ResultsError.CUSTOMER_ALREADY_EXISTS.toException("customerName", c.getName());
        });
    }

    private Long generateAccountId() {
        // generate 8 digit random number
        return (long) (Math.random() * 100000000L);
    }
}
