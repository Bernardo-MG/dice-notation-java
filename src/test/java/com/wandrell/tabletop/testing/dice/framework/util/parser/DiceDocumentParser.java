
package com.wandrell.tabletop.testing.dice.framework.util.parser;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.testing.dice.framework.conf.TestXMLConf;

public final class DiceDocumentParser
        implements Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
            .getLogger(DiceDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public DiceDocumentParser() {
        super();
    }

    @Override
    public final Collection<Collection<Object>> parse(final Document doc) {
        final Collection<Collection<Object>> colData;

        colData = new LinkedHashSet<Collection<Object>>();
        for (final Element node : doc.getRootElement().getChildren()) {
            colData.add(readNode(node));
        }

        return colData;
    }

    private final Collection<Object> readNode(final Element node) {
        final Collection<Object> data;
        final Integer quantity;
        final Integer sides;

        data = new LinkedList<Object>();

        quantity = Integer
                .parseInt(node.getChild(TestXMLConf.NODE_QUANTITY).getText());
        sides = Integer
                .parseInt(node.getChild(TestXMLConf.NODE_SIDES).getText());

        data.add(quantity);
        data.add(sides);

        getLogger().debug(String.format("Read dice %dd%d", quantity, sides));

        return data;
    }

}
