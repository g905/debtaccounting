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
package ru.ilb.debtaccounting.model.converters;

import java.util.Currency;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author slavb
 */
@Converter(autoApply = true)
public class CurrencyAttributeConverter implements AttributeConverter<Currency, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Currency x) {
        return x.getNumericCode();
    }

    @Override
    public Currency convertToEntityAttribute(Integer y) {
        return Currency.getInstance(y.toString());
    }

}
