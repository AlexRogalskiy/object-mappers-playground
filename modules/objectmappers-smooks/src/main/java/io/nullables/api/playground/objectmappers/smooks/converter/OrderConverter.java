package io.nullables.api.playground.objectmappers.smooks.converter;

import io.nullables.api.playground.objectmappers.commons.model.entity.DeliveryEntity;
import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringResult;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;

public class OrderConverter {

    public DeliveryEntity convertOrderXMLToDeliveryEntity(final String path) throws IOException, SAXException {
        final Smooks smooks = new Smooks(OrderConverter.class.getResourceAsStream("mappings/smooks-mapping.xml"));

        try {
            JavaResult javaResult = new JavaResult();
            smooks.filterSource(new StreamSource(OrderConverter.class.getResourceAsStream(path)), javaResult);
            return (DeliveryEntity) javaResult.getBean("deliveryEntity");
        } finally {
            smooks.close();
        }
    }

    public String convertOrderXMLtoEDIFACT(final String path) throws IOException, SAXException {
        return this.convertDocumentWithTemplate(path, "mappings/smooks-transform-edi.xml");
    }

    public String convertOrderXMLtoEmailMessage(final String path) throws IOException, SAXException {
        return this.convertDocumentWithTemplate(path, "mappings/smooks-transform-email.xml");
    }

    private String convertDocumentWithTemplate(final String path, final String config) throws IOException, SAXException {
        final Smooks smooks = new Smooks(config);

        try {
            final StringResult stringResult = new StringResult();
            smooks.filterSource(new StreamSource(OrderConverter.class.getResourceAsStream(path)), stringResult);
            return stringResult.toString();
        } finally {
            smooks.close();
        }
    }
}
