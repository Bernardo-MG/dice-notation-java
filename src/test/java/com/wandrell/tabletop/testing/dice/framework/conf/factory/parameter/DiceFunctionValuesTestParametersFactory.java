package com.wandrell.tabletop.testing.dice.framework.conf.factory.parameter;

import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.jdom2.Document;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.pattern.parser.xml.XMLFileParser;
import com.wandrell.tabletop.testing.dice.framework.conf.DiceParametersConf;
import com.wandrell.tabletop.testing.dice.framework.util.parser.FunctionExtremesDocumentParser;
import com.wandrell.util.ResourceUtils;

public final class DiceFunctionValuesTestParametersFactory {

    private static final DiceFunctionValuesTestParametersFactory instance = new DiceFunctionValuesTestParametersFactory();

    public static final DiceFunctionValuesTestParametersFactory getInstance() {
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

    private DiceFunctionValuesTestParametersFactory() {
        super();
    }

    public final Iterator<Object[]> getHighestKeep() throws Exception {
        return getParameters(getHighestKeepValues());
    }

    public final Iterator<Object[]> getHighestRemove() throws Exception {
        return getParameters(getHighestRemoveValues());
    }

    public final Iterator<Object[]> getLowestKeep() throws Exception {
        return getParameters(getLowestKeepValues());
    }

    public final Iterator<Object[]> getLowestRemove() throws Exception {
        return getParameters(getLowestRemoveValues());
    }

    private final Collection<Collection<Object>> getHighestKeepValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile.parse(ResourceUtils
                        .getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_KEEP_HIGHEST)));
    }

    private final Collection<Collection<Object>> getHighestRemoveValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile.parse(ResourceUtils
                        .getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_REMOVE_HIGHEST)));
    }

    private final Collection<Collection<Object>> getLowestKeepValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile.parse(ResourceUtils
                        .getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_KEEP_LOWEST)));
    }

    private final Collection<Collection<Object>> getLowestRemoveValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile.parse(ResourceUtils
                        .getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_REMOVE_LOWEST)));
    }

}
