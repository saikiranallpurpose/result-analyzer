package com.psv.resultanalyzer.mapper;

import com.psv.resultanalyzer.entity.Customer;
import com.psv.resultanalyzer.models.CustomerDto;

public class CustomerMapper {
    public static Customer mapDtoToEntity(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .mobileNumber(customerDto.getMobileNumber())
                .build();
    }

    public static CustomerDto mapEntityToDto(Customer customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .build();
    }
}
