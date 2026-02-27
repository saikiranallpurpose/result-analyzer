package com.psv.resultanalyzer.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAccountDto {
    private String name;
    private String email;
    private long accountNumber;
    private String accountType;
    private String mobileNumber;
}
