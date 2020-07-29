package com.ecarsm.accounts.api.model.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

/**
 *
 * @author Ecar. S. M.
 */
@Entity
@Table(name = "ACCOUNT")
@Data
@FieldNameConstants(innerTypeName = "Field")
@NoArgsConstructor
@AllArgsConstructor
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "THIS_NAME", length = 100)
    @NotNull
    @Size(max = 100)
    private String name;

    @Column(name = "MAIN_VALUE")
    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal mainValue;

    @Column(name = "DUE_DATE")
    @NotNull
    private LocalDate dueDate;

    @Column(name = "PAYMENT_DATE")
    private LocalDate paymentDate;

    @Transient
    private BigDecimal updatedValue;

    @Transient
    private BigDecimal fine;

    @Transient
    private BigDecimal interest;

    @PostLoad
    public void calculate() {

        long days = DAYS.between(this.dueDate, LocalDate.now());

        if (days > 5) {
            calcFees(Fee.AFTER_5, days);
        } else if (days > 3) {
            calcFees(Fee.AFTER_3, days);
        } else if (days <= 3) {
            calcFees(Fee.UNTIL_3, days);
        }

        this.updatedValue = this.mainValue.add(this.fine).add(this.interest);
    }

    private void calcFees(Fee fee, long days) {
        this.fine = this.mainValue.multiply(new BigDecimal(fee.getFine())).divide(new BigDecimal(100), BigDecimal.ROUND_HALF_EVEN);
        this.interest = this.mainValue.multiply(new BigDecimal(fee.getInterest())).divide(new BigDecimal(100), BigDecimal.ROUND_HALF_EVEN).multiply(new BigDecimal(days));
    }

}
