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

/**
 *
 * @author develop01
 */
public enum TransactionStatusCode implements EnumValue {

     /**
     * Создан
     */
    CREATED(1),
    /**
     * Выдан
     */
    EXECUTED(2);

    private TransactionStatusCode(int value){
        this.value = value;
    }

    public static TransactionStatusCode fromValue(int v) {
        for (TransactionStatusCode c : TransactionStatusCode.values()) {
            if (c.value == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(Integer.toString(v));
    }

    @Override
    public int value() {
        return value;
    }
    private final int value;

}
