package com.ecarsm.accounts.api.model.account.repository.impl;

import com.ecarsm.accounts.api.model.account.repository.query.AccountRepQuery;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AccountRepImpl implements AccountRepQuery {

    @PersistenceContext
    private EntityManager manager;

}
