package com.psv.resultanalyzer.controller;

import com.psv.resultanalyzer.models.CustomerDto;
import com.psv.resultanalyzer.models.CustomerAccountDto;
import com.psv.resultanalyzer.models.ResponseDto;
import com.psv.resultanalyzer.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class AccountsController {

    IAccountService accountsService;

    @PostMapping(value = "/accounts/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return ResponseEntity.ok(ResponseDto.builder()
                .statusCode(HttpStatus.CREATED)
                .message("Account created successfully")
                .build());
    }

    @GetMapping(value = "/fetch")
    public ResponseEntity<CustomerAccountDto> getAccountByMobileNumber(@RequestParam String mobileNumber){
        CustomerAccountDto customerAccountDto = accountsService.getAccountByMobileNumber(mobileNumber);
        return ResponseEntity.ok(customerAccountDto);
    }
}
