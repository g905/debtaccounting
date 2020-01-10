/*
 * Copyright 2020 develop01.
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
package ru.ilb.debtaccounting.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author develop01
 */
public class TransactionTest {

    public TransactionTest() {
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

    /**
     * Test of getStatus method, of class Transaction.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Transaction trans = new Transaction();
        for(TransactionStatusCode c : TransactionStatusCode.values())
        {
            System.out.println(c);
            trans.setStatus(c);
            assertEquals(trans.getStatus(), c);
        }
        /*trans.setStatus(TransactionStatusCode.CREATED);
        TransactionStatusCode expected = TransactionStatusCode.CREATED;
        assertEquals(trans.getStatus(), expected);*/
    }
}
