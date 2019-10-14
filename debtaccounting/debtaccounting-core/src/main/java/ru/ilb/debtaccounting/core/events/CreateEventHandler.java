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
package ru.ilb.debtaccounting.core.events;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import ru.ilb.debtaccounting.entities.AlreadyCreatedException;
import ru.ilb.debtaccounting.entities.CreateEvent;
import ru.ilb.debtaccounting.entities.DebtStatusCode;
import ru.ilb.debtaccounting.entities.EventHandler;
import ru.ilb.debtaccounting.entities.Loan;
import javax.validation.Validator;

/**
 *
 * @author slavb
 */
public class CreateEventHandler extends EventHandler<CreateEvent, Loan> {

    public CreateEventHandler(Validator validator) {
        super(validator);
    }

    @Override
    public void process(Loan debt, CreateEvent event) {
        super.process(debt, event);
        if (debt.getStatus() != null) {
            throw new AlreadyCreatedException();
        }
        debt.setRepaymentPlan(event.getRepaymentPlan());
        debt.setStatus(DebtStatusCode.CREATED);
    }

}
