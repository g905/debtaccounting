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

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.ilb.debtaccounting.loan.Loan;
import ru.ilb.debtaccounting.model.Cashflow;
import ru.ilb.debtaccounting.model.DebtStatusCode;
import ru.ilb.debtaccounting.testcase.ODSTestCase;

/**
 *
 * @author slavb
 */
public class CreateLoanEventHandlerTest {

    public CreateLoanEventHandlerTest() {
    }

    private static CreateLoanRequest createLoanRequest() {
        CreateLoanRequest request = new CreateLoanRequest();
        request.setAmount(BigDecimal.valueOf(968600));
        request.setPeriod(60);
        request.setRate(BigDecimal.valueOf(0.1537));
        Cashflow CashFlow = new Cashflow();
        request.setCashflow(CashFlow);
        return request;
    }

    public static Loan process() {
        // InputStream testData = this.getClass().getClassLoader().getResourceAsStream("testcases/createloan/cashflow.ods");
        //  ODSTestCase testCase = new ODSTestCase(testData);

        Loan loan = new Loan();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        CreateLoanEventHandler hanler = new CreateLoanEventHandler(validator);
        CreateLoanEvent event = hanler.createEvent();
        event.setRequest(createLoanRequest());
        event.setDebt(loan);

        hanler.process(loan, event);
        return loan;
    }

    /**
     * Test of process method, of class CreateLoanEventHandler.
     *
     * @throws java.io.IOException
     */
    @Test
    public void testProcess() throws IOException {
        System.out.println("process");
        Loan loan = process();
        Assertions.assertEquals(DebtStatusCode.CREATED, loan.getStatus());
    }

}
