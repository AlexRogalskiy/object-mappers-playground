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
package io.nullables.api.playground.objectmappers.dozer.configuration;

import com.github.dozermapper.core.events.Event;
import com.github.dozermapper.core.events.EventListener;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomEventListener implements EventListener {

    @Override
    public void onMappingStarted(final Event event) {
        log.info(">>> Mapping started, event: {}", event);
    }

    @Override
    public void onPreWritingDestinationValue(final Event event) {
        log.info(">>> Preinitializing object mapping by ID: [{}]", event.getClassMap().getMapId());
    }

    @Override
    public void onPostWritingDestinationValue(final Event event) {
        log.info(">>> Copying to target object by event: [{}], source field: [{}], target field: [{}], value: [{}]",
            event.getType(), event.getFieldMap().getSrcFieldName(), event.getFieldMap().getDestFieldName(),
            event.getDestinationValue());
    }

    @Override
    public void onMappingFinished(final Event event) {
        log.info(">>> Mapping finished, event: {}", event);
    }
}
