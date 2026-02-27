package com.psv.resultanalyzer.service.impl;

import com.psv.resultanalyzer.entity.Accounts;
import com.psv.resultanalyzer.entity.Customer;
import com.psv.resultanalyzer.exception.ResultsError;
import com.psv.resultanalyzer.mapper.CustomerMapper;
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

    private Accounts createAccount(Customer savedCustomer) {
        return Accounts.builder()
                .accountId(generateAccountId())
                .customerId(savedCustomer.getCustomerId())
                .accountType("Savings")
                .branchAddress("123 Main St")
                .updatedAt(LocalDateTime.now())
                .updatedBy("User-Update")
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
