package com.ecarsm.accounts.api.start;

import com.ecarsm.accounts.api.model.account.Account;
import com.ecarsm.accounts.api.model.account.service.AccountService;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author Ecar. S. M.
 */
@Component
@Order(2)
public class AccountStart implements ApplicationRunner {

    @Autowired
    private AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        
        account.setName("First Account");
        account.setMainValue(BigDecimal.valueOf(100.0));
        account.setDueDate(LocalDate.now());
        
        this.accountService.save(account);

    }

}
