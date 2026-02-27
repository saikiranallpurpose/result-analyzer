package com.psv.resultanalyzer.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDto {
    private Long accountNumber;
    private String accountType;
    private String branchAddress;
}
