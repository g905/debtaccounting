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

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.ilb.debtaccounting.entities.CreateEvent;
import ru.ilb.debtaccounting.entities.Loan;

/**
 *
 * @author Bystrobank
 */
public class CreateEventHandlerTest {

    public CreateEventHandlerTest() {
    }

    /**
     * Test of process method, of class CreateEventHandler.
     */
    @Test
    public void testProcess() {
        System.out.println("process");
        Loan loan = new Loan();
        CreateEvent event = new CreateEvent();
        CreateEventHandler instance = new CreateEventHandler(loan);
        instance.process(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
