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

import java.io.IOException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import ru.ilb.debtaccounting.entities.events.CreateEvent;
import ru.ilb.debtaccounting.entities.Loan;
import ru.ilb.debtaccounting.testcase.ODSTestCase;
import ru.ilb.debtaccounting.testcase.TestCase;

/**
 *
 * @author Bystrobank
 */
public class CreateEventHandlerTest {

    public CreateEventHandlerTest() {
    }

    /**
     * Test of process method, of class CreateLoanEventHandler.
     * @throws java.io.IOException
     */
    @Test
    public void testProcess() throws IOException {
        System.out.println("process");

        ODSTestCase testCase = new ODSTestCase(this.getClass().getClassLoader().getResourceAsStream("testcases/repaymentplan.ods"));

        Loan loan = new Loan();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        CreateEvent event = new CreateEvent();

        CreateLoanEventHandler instance = new CreateLoanEventHandler(validator);
        instance.process(loan, event);
    }

}
