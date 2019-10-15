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
package ru.ilb.debtaccounting.events.loan.createloan;

import java.io.IOException;
import java.io.InputStream;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.ilb.debtaccounting.entities.Loan;
import ru.ilb.debtaccounting.entities.RepaymentPlan;
import ru.ilb.debtaccounting.testcase.ODSTestCase;

/**
 *
 * @author slavb
 */
public class CreateLoanEventHandlerTest {

    public CreateLoanEventHandlerTest() {
    }

    /**
     * Test of process method, of class CreateLoanEventHandler.
     * @throws java.io.IOException
     */
    @Test
    public void testProcess() throws IOException {
        System.out.println("process");

        InputStream testData = this.getClass().getClassLoader().getResourceAsStream("testcases/repaymentplan.ods");
        ODSTestCase testCase = new ODSTestCase(testData);

        Loan loan = new Loan();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        CreateLoanEventHandler hanler = new CreateLoanEventHandler(validator);
        CreateLoanEvent event = hanler.createEvent();
        CreateLoanRequest request = new CreateLoanRequest();
        RepaymentPlan repaymentPlan = new RepaymentPlan();
        request.setRepaymentPlan(repaymentPlan);
        event.setRequest(request);
        event.setDebt(loan);


        hanler.process(loan, event);
    }

}
