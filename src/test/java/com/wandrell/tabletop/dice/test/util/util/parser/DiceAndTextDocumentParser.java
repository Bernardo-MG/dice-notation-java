
package com.wandrell.tabletop.dice.test.util.util.parser;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;

import org.jdom2.Document;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.tabletop.dice.test.util.conf.TestXMLConf;

public final class DiceAndTextDocumentParser
        implements Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
            .getLogger(DiceAndTextDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public DiceAndTextDocumentParser() {
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
        final String text;

        data = new LinkedList<Object>();

        text = node.getChild(TestXMLConf.NODE_TEXT).getText();
        quantity = Integer
                .parseInt(node.getChild(TestXMLConf.NODE_QUANTITY).getText());
        sides = Integer
                .parseInt(node.getChild(TestXMLConf.NODE_SIDES).getText());

        data.add(text);
        data.add(quantity);
        data.add(sides);

        getLogger().debug(String.format("Read dice %dd%d", quantity, sides));

        return data;
    }

}