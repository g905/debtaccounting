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

import ru.ilb.debtaccounting.entities.CreateEvent;
import ru.ilb.debtaccounting.entities.DebtStatusCode;
import ru.ilb.debtaccounting.entities.EventHandler;
import ru.ilb.debtaccounting.entities.Loan;

/**
 *
 * @author slavb
 */
public class CreateEventHandler extends EventHandler<CreateEvent,Loan>{

    @Override
    public void process(CreateEvent event) {
        debt.setRepaymentPlan(event.getRepaymentPlan());
        debt.setStatus(DebtStatusCode.CREATED);
    }

}
