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
package ru.ilb.debtaccounting.loan.events.createloan;

import javax.validation.Validator;
import ru.ilb.debtaccounting.entities.DebtStatusCode;
import ru.ilb.debtaccounting.events.EventHandler;
import ru.ilb.debtaccounting.entities.Loan;

/**
 * Событие "Создание долга"
 * @author slavb
 */
public class CreateLoanEventHandler extends EventHandler<CreateLoanEvent, Loan> {

    public CreateLoanEventHandler(Validator validator) {
        super(validator);
    }

    @Override
    public void process(Loan debt, CreateLoanEvent event) {
        super.process(debt, event);
        if (debt.getStatus() != null) {
            throw new AlreadyCreatedException();
        }
        debt.setRepaymentPlan(event.getRequest().getRepaymentPlan());
        debt.setStatus(DebtStatusCode.CREATED);
    }



}
