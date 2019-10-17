/*
 * Copyright 2019 Bystrobank.
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
package ru.ilb.debtaccounting.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

/**
 * Долг
 *
 * @author slavb
 */
public abstract class Debt {

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
     * Дата выдачи
     */
    @NotNull
    LocalDate disbursementDate;

    /**
     * Статус кредита
     */
    @NotNull
    DebtStatusCode status;

    /**
     * График погашения
     */
    @NotNull
    RepaymentPlan repaymentPlan;

    public LocalDate getDisbursementDate() {
        return disbursementDate;
    }

    public void setDisbursementDate(LocalDate disbursementDate) {
        this.disbursementDate = disbursementDate;
    }

    public RepaymentPlan getRepaymentPlan() {
        return repaymentPlan;
    }

    public void setRepaymentPlan(RepaymentPlan repaymentPlan) {
        this.repaymentPlan = repaymentPlan;
    }

    public DebtStatusCode getStatus() {
        return status;
    }

    public void setStatus(DebtStatusCode status) {
        this.status = status;
    }

}
