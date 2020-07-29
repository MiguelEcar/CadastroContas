package com.ecarsm.accounts.api.model.account;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Ecar. S. M.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum Fee {

    UNTIL_3(2, 0.1),
    AFTER_3(3, 0.2),
    AFTER_5(5, 0.3);

    private final int fine;
    private final double interest;
}
