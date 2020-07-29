package com.ecarsm.accounts.api.model.account.repository.impl;

import com.ecarsm.accounts.api.model.account.Account;
import com.ecarsm.accounts.api.model.account.repository.filter.AccountFilter;
import com.ecarsm.accounts.api.model.account.repository.query.AccountRepQuery;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

public class AccountRepImpl implements AccountRepQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Account> page(AccountFilter filter, Pageable page) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Account> criteria = builder.createQuery(Account.class);
        Root<Account> root = criteria.from(Account.class);

        Predicate[] predicates = predicates(filter, builder, root);
        criteria.where(predicates);

        TypedQuery<Account> query = manager.createQuery(criteria);

        query.setFirstResult(page.getPageNumber() * page.getPageSize());
        query.setMaxResults(page.getPageSize());

        return new PageImpl<>(query.getResultList(), page, total(filter));
    }

    public Predicate[] predicates(AccountFilter filter, CriteriaBuilder builder, Root<Account> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getName())) {
            predicates.add(builder.like(builder.lower(root.get(Account.Field.name)), "%" + filter.getName().toLowerCase() + "%"));
        }

        if (filter.getDateFrom() != null && filter.getDateTo() != null) {
            predicates.add(builder.between(root.<LocalDate>get(Account.Field.dueDate), filter.getDateFrom(), filter.getDateTo()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private Long total(AccountFilter filter) {
        CriteriaBuilder builder = this.manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Account> root = criteria.from(Account.class);

        Predicate[] predicates = predicates(filter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));
        return this.manager.createQuery(criteria).getSingleResult();
    }
}
