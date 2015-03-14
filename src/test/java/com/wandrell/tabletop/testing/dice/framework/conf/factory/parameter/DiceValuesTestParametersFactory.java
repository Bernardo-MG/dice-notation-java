package com.wandrell.tabletop.testing.dice.framework.conf.factory.parameter;

import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.jdom2.Document;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.pattern.parser.xml.XMLFileParser;
import com.wandrell.tabletop.testing.dice.framework.conf.DiceParametersConf;
import com.wandrell.tabletop.testing.dice.framework.util.parser.DiceAndTextDocumentParser;
import com.wandrell.tabletop.testing.dice.framework.util.parser.DiceDocumentParser;
import com.wandrell.tabletop.testing.dice.framework.util.parser.DiceTextDocumentParser;
import com.wandrell.util.ResourceUtils;

public final class DiceValuesTestParametersFactory {

    private static final DiceValuesTestParametersFactory instance = new DiceValuesTestParametersFactory();

    public static final DiceValuesTestParametersFactory getInstance() {
        return instance;
    }

    private static final Iterator<Object[]> getParameters(
            final Collection<Collection<Object>> valuesTable) {
        final Collection<Object[]> result;

        result = new LinkedList<Object[]>();
        for (final Collection<Object> values : valuesTable) {
            result.add(values.toArray());
        }

        return result.iterator();
    }

    private DiceValuesTestParametersFactory() {
        super();
    }

    public final Iterator<Object[]> getDice() throws Exception {
        return getParameters(getDiceValues());
    }

    public final Iterator<Object[]> getDiceAndText() throws Exception {
        return getParameters(getDiceAndTextValues());
    }

    public final Iterator<Object[]> getDiceText() throws Exception {
        return getParameters(getDiceTextValues());
    }

    private final Collection<Collection<Object>> getDiceAndTextValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new DiceAndTextDocumentParser();

        return parserParams.parse(parserFile.parse(ResourceUtils
                .getClassPathReader(DiceParametersConf.DICE_AND_TEXT)));
    }

    private final Collection<Collection<Object>> getDiceTextValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new DiceTextDocumentParser();

        return parserParams.parse(parserFile.parse(ResourceUtils
                .getClassPathReader(DiceParametersConf.DICE_TEXT)));
    }

    private final Collection<Collection<Object>> getDiceValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new DiceDocumentParser();

        return parserParams.parse(parserFile.parse(ResourceUtils
                .getClassPathReader(DiceParametersConf.DEFAULT)));
    }

}
