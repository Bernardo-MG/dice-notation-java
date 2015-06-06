package com.wandrell.tabletop.testing.dice.framework.conf.factory.parameter;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.jdom2.Document;

import com.wandrell.pattern.parser.Parser;
import com.wandrell.pattern.parser.xml.XMLFileParser;
import com.wandrell.tabletop.testing.dice.framework.conf.DiceParametersConf;
import com.wandrell.tabletop.testing.dice.framework.util.parser.FunctionExtremesDocumentParser;

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

    /**
     * Creates an {@code URL} pointing to the file specified by the path, if it
     * exists.
     * 
     * @param path
     *            the path to transform
     * @return an URL pointing inside the class path
     */
    public final URL getClassPathURL(final String path) {
        checkNotNull(path, "Received a null pointer as path");

        return this.getClass().getClassLoader().getResource(path);
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

    /**
     * Creates an {@code InputStream} pointing to the file specified by the
     * path, if it exists.
     * <p>
     * If any problem occurs during this process a {@code RuntimeException} is
     * thrown, or an {@code IllegalArgumentException} if the file is not found.
     * 
     * @param path
     *            the path to transform
     * @return an {@code InputStream} pointing to the path
     */
    private final InputStream getClassPathInputStream(final String path) {
        final URL url;                  // URL parsed from the path
        final InputStream stream;       // Stream for the file

        url = getClassPathURL(path);

        checkArgument(url != null,
                String.format("The path %s is invalid", path));

        try {
            stream = new BufferedInputStream(url.openStream());
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

        return stream;
    }

    /**
     * Creates a {@code Reader} pointing to the file specified by the path, if
     * it exists.
     * <p>
     * If any problem occurs during this process a {@code RuntimeException} is
     * thrown, or an {@code IllegalArgumentException} if the file is not found.
     * 
     * @param path
     *            the path to transform
     * @return an {@code InputStream} pointing to the path
     */
    private final Reader getClassPathReader(final String path) {
        return new BufferedReader(new InputStreamReader(
                getClassPathInputStream(path)));
    }

    private final Collection<Collection<Object>> getHighestKeepValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile
                        .parse(getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_KEEP_HIGHEST)));
    }

    private final Collection<Collection<Object>> getHighestRemoveValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile
                        .parse(getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_REMOVE_HIGHEST)));
    }

    private final Collection<Collection<Object>> getLowestKeepValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile
                        .parse(getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_KEEP_LOWEST)));
    }

    private final Collection<Collection<Object>> getLowestRemoveValues()
            throws Exception {
        final Parser<Reader, Document> parserFile;
        final Parser<Document, Collection<Collection<Object>>> parserParams;

        parserFile = new XMLFileParser();
        parserParams = new FunctionExtremesDocumentParser();

        return parserParams
                .parse(parserFile
                        .parse(getClassPathReader(DiceParametersConf.FUNCTION_EXTREMES_REMOVE_LOWEST)));
    }

}
