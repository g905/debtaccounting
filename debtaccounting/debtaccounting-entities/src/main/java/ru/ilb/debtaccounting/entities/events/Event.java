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

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import ru.ilb.debtaccounting.entities.Debt;

/**
 * Событие
 *
 * @author slavb
 * @param <ER> тип запроса
 */
public abstract class Event<ER extends EventRequest> {

    /**
     * Дата учета события
     */
    @NotNull
    LocalDate date;

    /**
     * Дата регистрации события
     */
    @NotNull
    LocalDateTime createdDate;

    /**
     * Долг, по которому произошло событие
     */
    @NotNull
    Debt debt;

    ER request;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public ER getRequest() {
        return request;
    }

    public void setRequest(ER request) {
        this.request = request;
    }
}
