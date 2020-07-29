package com.ecarsm.accounts.api.model.account.resources;

import com.ecarsm.accounts.api.model.account.service.AccountService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ecar. S. M.
 */
@RestController
@RequestMapping("account")
@Getter
public class AccountResource {

    @Autowired
    private AccountService service;

}
