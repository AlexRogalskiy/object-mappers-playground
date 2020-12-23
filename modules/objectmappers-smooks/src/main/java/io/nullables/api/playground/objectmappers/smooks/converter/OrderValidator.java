/**
 * Object Mappers GNU GPL License Agreement
 * <p>
 * Copyright (c) 2020 Nullables, Inc.
 * <p>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see https\\://www.gnu.org/licenses/.
 */
package io.nullables.api.playground.objectmappers.smooks.converter;

import java.io.IOException;

import javax.xml.transform.stream.StreamSource;

import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringResult;
import org.milyn.validation.ValidationResult;
import org.xml.sax.SAXException;

public class OrderValidator {

    public ValidationResult validate(final String path) throws IOException, SAXException {
        final Smooks smooks = new Smooks(OrderValidator.class.getResourceAsStream("mappings/smooks-validation.xml"));
        try {
            final StringResult xmlResult = new StringResult();
            final JavaResult javaResult = new JavaResult();
            final ValidationResult validationResult = new ValidationResult();
            smooks.filterSource(new StreamSource(OrderValidator.class.getResourceAsStream(path)), xmlResult, javaResult, validationResult);
            return validationResult;
        } finally {
            smooks.close();
        }
    }
}
