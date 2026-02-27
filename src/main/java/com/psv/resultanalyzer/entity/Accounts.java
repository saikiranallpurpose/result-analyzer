package com.psv.resultanalyzer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends MetaDataEntity {

    private Long customerId;
    @Id
    private Long accountId;
    private String accountType;
    private String branchAddress;
}
