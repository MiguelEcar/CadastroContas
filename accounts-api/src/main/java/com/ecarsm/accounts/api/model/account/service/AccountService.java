package com.ecarsm.accounts.api.model.account.service;

import com.ecarsm.accounts.api.model.account.Account;
import com.ecarsm.accounts.api.model.account.repository.AccountRep;
import java.util.List;
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

    public Account save(Account obj) {
        return this.mainRep.save(obj);
    }
    
    public List<Account> all() {
        return this.mainRep.findAll();
    }

}
