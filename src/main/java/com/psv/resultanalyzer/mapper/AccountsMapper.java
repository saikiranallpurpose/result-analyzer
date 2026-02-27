package com.psv.resultanalyzer.mapper;

import com.psv.resultanalyzer.entity.Accounts;
import com.psv.resultanalyzer.models.AccountsDto;

public class AccountsMapper {

    public static Accounts mapDtoToEntity(AccountsDto accountsDto) {
        return Accounts.builder()
                .accountId(accountsDto.getAccountNumber())
                .accountType(accountsDto.getAccountType())
                .branchAddress(accountsDto.getBranchAddress())
                .build();

    }

    public static AccountsDto mapEntityToDto(Accounts accounts) {
        return AccountsDto.builder()
                .accountNumber(accounts.getAccountId())
                .accountType(accounts.getAccountType())
                .branchAddress(accounts.getBranchAddress())
                .build();
    }
}
