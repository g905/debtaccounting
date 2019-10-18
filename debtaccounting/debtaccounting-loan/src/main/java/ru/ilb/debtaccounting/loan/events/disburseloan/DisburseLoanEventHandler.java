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

import javax.validation.Validator;
import ru.ilb.debtaccounting.model.DebtStatusCode;
import ru.ilb.debtaccounting.model.EventHandler;
import ru.ilb.debtaccounting.loan.Loan;
import ru.ilb.debtaccounting.model.Account;

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
     * @param debt
     * @param event
     */
    @Override
    public void process(Loan debt, DisburseLoanEvent event) {
        if (debt.getStatus() != DebtStatusCode.CREATED) {
            throw new AlreadyDisbursedException();
        }
        Account account = new Account();

        debt.setStatus(DebtStatusCode.DISBURSED);
    }

}
