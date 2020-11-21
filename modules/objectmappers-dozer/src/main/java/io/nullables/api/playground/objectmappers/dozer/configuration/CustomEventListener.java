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
    public void onPreWritingDestinationValue(final Event event) {}

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
