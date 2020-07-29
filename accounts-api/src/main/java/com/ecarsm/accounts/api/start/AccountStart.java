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
        
        Account account2 = new Account();
        account2.setName("Second Account");
        account2.setMainValue(BigDecimal.valueOf(1236.0));
        account2.setDueDate(LocalDate.of(2020, 5, 17));
        
        Account account3 = new Account();
        account3.setName("Third Account");
        account3.setMainValue(BigDecimal.valueOf(65443.0));
        account3.setDueDate(LocalDate.of(2020, 8, 26));
        
        Account account4 = new Account();
        account4.setName("Fourth Account");
        account4.setMainValue(BigDecimal.valueOf(34.0));
        account4.setDueDate(LocalDate.of(2020, 2, 12));
        
        this.accountService.save(account);
        this.accountService.save(account2);
        this.accountService.save(account3);
        this.accountService.save(account4);

    }

}
