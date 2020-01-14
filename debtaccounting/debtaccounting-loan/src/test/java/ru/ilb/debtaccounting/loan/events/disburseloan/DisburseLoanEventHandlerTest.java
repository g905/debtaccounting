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
package ru.ilb.debtaccounting.loan.events.disburseloan;

import java.io.IOException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ilb.debtaccounting.loan.Loan;
import ru.ilb.debtaccounting.loan.events.createloan.CreateLoanEventHandlerTest;
import ru.ilb.debtaccounting.model.DebtStatusCode;
import ru.ilb.debtaccounting.model.Money;

/**
 *
 * @author slavb
 */
public class DisburseLoanEventHandlerTest {

    public DisburseLoanEventHandlerTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    public Loan process() throws IOException {
        Loan loan = CreateLoanEventHandlerTest.process();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        DisburseLoanEventHandler hanler = new DisburseLoanEventHandler(validator);
        DisburseLoanEvent event = hanler.createEvent();
        event.setDebt(loan);

        hanler.process(loan, event);
        return loan;
    }

    /**
     * Test of process method, of class DisburseLoanEventHandler.
     */
    @Test
    public void testProcess() throws IOException {
        Loan loan = process();
        assertEquals(DebtStatusCode.DISBURSED, loan.getStatus());
        assertNotNull(loan.getPrincipalAccount(), "Счет основного долга должен быть заведен");
        assertEquals(Money.locale(0), loan.getPrincipalAccount().getAmount());
        assertNotNull(loan.getDebtRights(), "Заведены права на долг");
        assertEquals(1,loan.getDebtRights().size(),"Заведено 1 право на долг");
        assertNotNull(loan.getDebtRights().get(0).getBusinessEntity(),"Заведен ХС в правена долг");
        assertEquals("ПАО \"Быстробанк\"",loan.getDebtRights().get(0).getBusinessEntity().getName(),"Право на долг - ПАО Быстробанк");
    }

}
