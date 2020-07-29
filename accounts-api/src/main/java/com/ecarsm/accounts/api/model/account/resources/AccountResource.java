package com.ecarsm.accounts.api.model.account.resources;

import com.ecarsm.accounts.api.baseline.exception.MyException;
import com.ecarsm.accounts.api.model.account.Account;
import com.ecarsm.accounts.api.model.account.service.AccountService;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * Adding new Account and returns new Account with ID
     *
     * @param obj
     * @return new Account with ID
     * @throws com.ecarsm.accounts.api.baseline.exception.MyException
     */
    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account obj) throws MyException {

        try {
            obj = this.service.save(obj);
            return ResponseEntity.status(HttpStatus.CREATED).body(obj);

        } catch (Exception ex) {
            throw new MyException("msg.account.create.error");
        }

    }

    /**
     * Returns the list of Accounts
     *
     * @return
     * @throws com.ecarsm.accounts.api.baseline.exception.MyException
     */
    @GetMapping("/all")
    public ResponseEntity<List<Account>> all() throws MyException {

        List<Account> resp = this.service.all();

        return resp != null ? ResponseEntity.ok(resp) : ResponseEntity.noContent().build();
    }

}
