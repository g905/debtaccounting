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
package ru.ilb.debtaccounting.events;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private final Class<E> eventClass;

    protected final Validator validator;

    public EventHandler(Validator validator) {
        if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
            //Если класс переопределяет T, возьмем из параметров
            this.eventClass = (Class<E>) ((ParameterizedType) getClass()
                    .getGenericSuperclass())
                    .getActualTypeArguments()[0];
        } else {
            //Иначе возьмем базовый класс Operation
            this.eventClass = (Class<E>) Event.class;
        }

        this.validator = validator;
    }

    public E createEvent() {
        E event = newEvent();
        initEvent(event);
        return event;

    }

    protected void initEvent(Event event) {
        event.setCreatedDate(LocalDateTime.now());
        event.setDate(LocalDate.now());
    }

    protected E newEvent() {
        E newInstance;
        try {
            newInstance = eventClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new RuntimeException(ex);
        }
        return newInstance;
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
