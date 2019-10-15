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
package ru.ilb.debtaccounting.entities.events;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import ru.ilb.debtaccounting.entities.Debt;

/**
 * Обработчик события
 *
 * @author slavb
 * @param <E> Тип события
 * @param <D> Тип долга
 */
public abstract class EventHandler<E extends Event, D extends Debt> {

    protected final Validator validator;

    public EventHandler(Validator validator) {
        this.validator = validator;
    }

    /**
     * Обработать событие
     *
     * @param debt
     * @param event
     */
    public void process(D debt, E event) {
        validate(debt, event);
    }

    protected void validate(D debt, E event) {
        Set<ConstraintViolation<E>> violations = validator.validate(event);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }

    }

}
