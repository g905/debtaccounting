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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import ru.ilb.debtaccounting.loan.Loan;
import ru.ilb.debtaccounting.model.Cashflow;
import ru.ilb.debtaccounting.model.DebtStatusCode;
import ru.ilb.debtaccounting.model.Money;
import ru.ilb.debtaccounting.model.Transaction;
import ru.ilb.debtaccounting.testcase.ODSTestCase;

/**
 *
 * @author slavb
 */
public class CreateLoanEventHandlerTest {

    private static final String FILE_SOURCE = "testcases/createloan/cashflow.ods";
    final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd");

    public CreateLoanEventHandlerTest() {
    }

    private static CreateLoanRequest createLoanRequest() throws IOException {
        InputStream testData = CreateLoanEventHandlerTest.class.getClassLoader().getResourceAsStream(FILE_SOURCE);
        ODSTestCase instance = new ODSTestCase(testData);
        Map <String, Object> result = instance.getInputData();
        CreateLoanRequest request = new CreateLoanRequest();
        request.setAmount(new BigDecimal(result.get("amount").toString()));
        request.setPeriod((Integer) result.get("period"));
        request.setRate(new BigDecimal(result.get("rate").toString()));
        Map <String, Object[]> calcTable = instance.getCalculationTable();
        List<Transaction> transactions = new ArrayList<Transaction>();
        for (int i = 0; i < calcTable.get("T").length; i++){
            if(Long.parseLong(calcTable.get("T")[i].toString())==0)
                continue;
            Transaction trPaymentDebt = new Transaction();
            trPaymentDebt.setAmount(new Money(new Double(calcTable.get("PAYMENTDEBT")[i].toString()), Currency.getInstance(Locale.getDefault())));
            /*
            Заполнение транзакции
            */
            transactions.add(trPaymentDebt);

            Transaction trPaymentInt = new Transaction();
            trPaymentDebt.setAmount(new Money(new Double(calcTable.get("PAYMENTINT")[i].toString()), Currency.getInstance(Locale.getDefault())));
            /*
            Заполнение транзакции
            */
            transactions.add(trPaymentInt);
            if(Float.parseFloat(calcTable.get("DEBTREMAINDER")[i].toString())==0)
                break;
        }
        Cashflow cashFlow = new Cashflow();
        cashFlow.setTransactions(transactions);
        request.setCashflow(cashFlow);
        return request;
    }

    public static Loan process() throws IOException {
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

    @Test
    public void testCreateLoanRequest() throws IOException {
        System.out.println("Create Loan Request");
        CreateLoanRequest request = createLoanRequest();
        BigDecimal num = new BigDecimal(968600);
        BigDecimal rate = new BigDecimal("0.1537");
        assertEquals(num, request.getAmount());
        assertEquals((Integer) 60, request.getPeriod());
        assertEquals(rate, request.getRate());
        assertEquals(120, request.getCashflow().getTransactions().size());
    }

}
