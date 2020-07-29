package com.ecarsm.accounts.api.model.account.repository;

import com.ecarsm.accounts.api.model.account.Account;
import com.ecarsm.accounts.api.model.account.repository.query.AccountRepQuery;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRep extends JpaRepository<Account, Long>, AccountRepQuery {


}
