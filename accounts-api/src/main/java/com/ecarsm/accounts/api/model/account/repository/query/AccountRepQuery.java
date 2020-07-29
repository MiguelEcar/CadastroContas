package com.ecarsm.accounts.api.model.account.repository.query;

import com.ecarsm.accounts.api.model.account.Account;
import com.ecarsm.accounts.api.model.account.repository.filter.AccountFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Ecar. S. M.
 */
public interface AccountRepQuery {

    public Page<Account> page(AccountFilter filter, Pageable page);
}
