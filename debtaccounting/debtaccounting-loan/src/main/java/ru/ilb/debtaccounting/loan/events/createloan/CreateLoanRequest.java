/*
 * Copyright 2019 slavb.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.ilb.debtaccounting.loan.events.createloan;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import ru.ilb.debtaccounting.loan.events.LoanEventRequest;
import ru.ilb.debtaccounting.model.CashFlow;

/**
 *
 * @author slavb
 */
public class CreateLoanRequest extends LoanEventRequest {

    /**
     * Сумма кредита
     */
    @NotNull
    BigDecimal amount;
    /**
     * Срок кредита
     */
    @NotNull
    Integer period;
    /**
     * Ставка
     */
    @NotNull
    BigDecimal rate;

    /**
     * График погашения
     */
    @NotNull
    CashFlow CashFlow;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public CashFlow getCashFlow() {
        return CashFlow;
    }

    public void setCashFlow(CashFlow CashFlow) {
        this.CashFlow = CashFlow;
    }

}
