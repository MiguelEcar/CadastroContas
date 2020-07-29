package com.ecarsm.accounts.api.model.account.service;

import com.ecarsm.accounts.api.model.account.Account;
import com.ecarsm.accounts.api.model.account.repository.AccountRep;
import com.ecarsm.accounts.api.model.account.repository.filter.AccountFilter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Account> page(AccountFilter filter, Pageable page) {
        return this.mainRep.page(filter, page);
    }


}
