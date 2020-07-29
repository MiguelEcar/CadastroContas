package com.ecarsm.accounts.api.model.account.repository.filter;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Ecar. S. M.
 */
@Data
public class AccountFilter {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFrom;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTo;

}
