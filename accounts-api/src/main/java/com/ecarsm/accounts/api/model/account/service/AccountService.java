package com.ecarsm.accounts.api.model.account.service;

import com.ecarsm.accounts.api.model.account.repository.AccountRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ecar. S. M.
 */
@Service
public class AccountService {

    @Autowired
    private AccountRep mainRep;

}
