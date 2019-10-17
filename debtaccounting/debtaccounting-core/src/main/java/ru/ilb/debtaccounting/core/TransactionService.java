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
package ru.ilb.debtaccounting.core;

import javax.inject.Inject;
import javax.xml.validation.Validator;
import ru.ilb.debtaccounting.model.Transaction;
import ru.ilb.debtaccounting.utils.ParameterizedTypeHelper;

/**
 *
 * @author slavb
 * @param <T> type of transaction
 */
public class TransactionService<T extends Transaction> {

    final protected Class<T> transactionClass;
    protected final Validator validator;

    @Inject
    public TransactionService(Validator validator) {
        this.transactionClass = ParameterizedTypeHelper.getActualTypeArguments(getClass(), 0, (Class<T>) Transaction.class);
        this.validator = validator;
    }

    public void execute(T transction) {

    }

}
