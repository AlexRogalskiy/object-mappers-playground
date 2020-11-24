package io.nullables.api.playground.objectmappers.smooks.converter;

import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringResult;
import org.milyn.validation.ValidationResult;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

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
