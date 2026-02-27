package com.psv.resultanalyzer.repository;

import com.psv.resultanalyzer.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
    Optional<Accounts> findByCustomerId(long customerId);

    @Modifying
    @Transactional
    void deleteByCustomerId(long customerId);
}
