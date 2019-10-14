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
package ru.ilb.debtaccounting.entities;

/**
 * Обработчик события
 * @author slavb
 * @param <E> Тип события
 * @param <D> Тип долга
 */
public abstract class EventHandler<E extends Event, D extends Debt> {


    protected D debt;
    /**
     * Обработать событие
     * @param event
     */
    abstract public void process(E event);

}
