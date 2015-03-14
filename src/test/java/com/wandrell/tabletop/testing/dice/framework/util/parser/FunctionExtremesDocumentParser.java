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

public final class FunctionExtremesDocumentParser implements
        Parser<Document, Collection<Collection<Object>>> {

    private static final Logger logger = LoggerFactory
                                               .getLogger(FunctionExtremesDocumentParser.class);

    private static final Logger getLogger() {
        return logger;
    }

    public FunctionExtremesDocumentParser() {
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
        final Integer count;
        final Collection<Integer> rolls;
        final Collection<Integer> results;

        data = new LinkedList<Object>();

        count = Integer.parseInt(node.getChild(TestXMLConf.NODE_COUNT)
                .getText());

        rolls = new LinkedList<>();
        for (final Element roll : node.getChild(TestXMLConf.NODE_ROLLS)
                .getChildren()) {
            rolls.add(Integer.parseInt(roll.getText()));
        }

        results = new LinkedList<>();
        for (final Element roll : node.getChild(TestXMLConf.NODE_RESULTS)
                .getChildren()) {
            results.add(Integer.parseInt(roll.getText()));
        }

        data.add(count);
        data.add(rolls);
        data.add(results);

        getLogger().debug(
                String.format("Read count %d, rolls %s and results %s", count,
                        rolls.toString(), results.toString()));

        return data;
    }

}
