/*
 * Copyright 2017 slavb.
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
package ru.ilb.debtaccounting.mappers;

import java.util.List;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import ru.ilb.debtaccounting.view.Debt;
import ru.ilb.debtaccounting.view.Debts;

/**
 *
 * @author slavb
 */
@Mapper(componentModel = "spring")
public abstract class DebtMapper implements GenericMapper<ru.ilb.debtaccounting.model.Debt, Debt> {

    @AfterMapping
    protected void afterMapping(@MappingTarget ru.ilb.debtaccounting.model.Debt entity, Debt dto) {
        //entity.getDocfiles().forEach(d -> d.setDebt(entity));
    }

    public Debts createWrapperFromEntities(List<ru.ilb.debtaccounting.model.Debt> entities) {
        Debts documents = new Debts();
        documents.setDebts(createFromEntities(entities));
        return documents;
    }

}
