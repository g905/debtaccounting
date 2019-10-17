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
package ru.ilb.debtaccounting.utils;

import java.lang.reflect.ParameterizedType;

/**
 *
 * @author slavb
 */
public class ParameterizedTypeHelper {

    public static <T> Class<T> getActualTypeArguments(Class clazz, int arg, Class<T> defaultValue) {
        if (clazz.getGenericSuperclass() instanceof ParameterizedType) {
            //in case of parametrized class, return parameter type
            return (Class<T>) ((ParameterizedType) clazz
                    .getGenericSuperclass())
                    .getActualTypeArguments()[arg];
        } else {
            //else return default class
            return defaultValue;
        }
    }
}
