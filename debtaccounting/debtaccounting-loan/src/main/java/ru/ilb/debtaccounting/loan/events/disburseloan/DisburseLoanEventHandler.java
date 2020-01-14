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
package ru.ilb.debtaccounting.loan.events.disburseloan;

import java.math.BigDecimal;
import javax.validation.Validator;
import ru.ilb.debtaccounting.model.DebtStatusCode;
import ru.ilb.debtaccounting.model.EventHandler;
import ru.ilb.debtaccounting.loan.Loan;
import ru.ilb.debtaccounting.model.Account;
import ru.ilb.debtaccounting.model.BusinessEntity;
import ru.ilb.debtaccounting.model.DebtRight;
import ru.ilb.debtaccounting.model.Transaction;
import ru.ilb.debtaccounting.model.TransactionStatusCode;

/**
 *
 * @author slavb
 */
public class DisburseLoanEventHandler extends EventHandler<DisburseLoanEvent, Loan> {

    public DisburseLoanEventHandler(Validator validator) {
        super(validator);
    }

    /**
     * Выдать кредит
     *
     * 1. Создать счет основного долга {@link Loan#principalAccount}
     * 2. Зачислить сумму кредита на счет основого долга {@link Account#deposit}
     * 3. Создать право на долг (@link DebtRight}, задать долю 1 (100%) {@link DebtRight#share}, владельца прав {@link DebtRight#businessEntity}
     * @param debt
     * @param event
     */
    @Override
    public void process(Loan debt, DisburseLoanEvent event) {
        if (debt.getStatus() != DebtStatusCode.CREATED) {
            throw new AlreadyDisbursedException();
        }
        for (Transaction t : debt.getCashflow().getTransactions()) {
            if (!(t.getStatus() == TransactionStatusCode.EXECUTED)) {
                t.execute();
            }
        }
        DebtRight debtRight = new DebtRight();
        debtRight.setShare(BigDecimal.ONE);
        BusinessEntity businessEntity = new BusinessEntity();
        businessEntity.addDebtRight(debtRight);
        businessEntity.setName("ПАО \"Быстробанк\"");
        debt.addDebtRight(debtRight);
        debt.setStatus(DebtStatusCode.DISBURSED);
    }
}
