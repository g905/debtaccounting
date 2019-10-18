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
package ru.ilb.debtaccounting.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author slavb
 */
public class DebtStatusCodeTest {

    public DebtStatusCodeTest() {
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
     * Test of values method, of class DebtStatusCode.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        DebtStatusCode[] expResult = {DebtStatusCode.CREATED, DebtStatusCode.DISBURSED};
        DebtStatusCode[] result = DebtStatusCode.values();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of valueOf method, of class DebtStatusCode.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String arg0 = "CREATED";
        DebtStatusCode expResult = DebtStatusCode.CREATED;
        DebtStatusCode result = DebtStatusCode.valueOf(arg0);
        assertEquals(expResult, result);
    }

    /**
     * Test of value method, of class DebtStatusCode.
     */
    @Test
    public void testValue() {
        System.out.println("value");
        DebtStatusCode instance = DebtStatusCode.CREATED;
        int expResult = 1;
        int result = instance.value();
        assertEquals(expResult, result);
    }

    /**
     * Test of fromValue method, of class DebtStatusCode.
     */
    @Test
    public void testFromValue() {
        System.out.println("fromValue");
        int v = 2;
        DebtStatusCode expResult = DebtStatusCode.DISBURSED;
        DebtStatusCode result = DebtStatusCode.fromValue(v);
        assertEquals(expResult, result);
    }

}
