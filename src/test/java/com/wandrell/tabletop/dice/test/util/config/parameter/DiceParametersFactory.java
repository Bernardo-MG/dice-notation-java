/**
 * Copyright 2014-2016 the original author or authors
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.wandrell.tabletop.dice.test.util.config.parameter;

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
import java.util.List;

import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import com.wandrell.tabletop.dice.test.util.config.ParameterPaths;

public final class DiceParametersFactory {

    private static final DiceParametersFactory instance = new DiceParametersFactory();

    public static final DiceParametersFactory getInstance() {
        return instance;
    }

    private DiceParametersFactory() {
        super();
    }

    public final Iterator<Object[]> getDiceAndText() throws Exception {
        final CellProcessor[] processors;

        processors = new CellProcessor[] { new NotNull(), new ParseInt(),
                new ParseInt() };

        return getParameters(ParameterPaths.DICE_AND_TEXT, processors);
    }

    public final Iterator<Object[]> getDiceText() throws Exception {
        final CellProcessor[] processors;

        processors = new CellProcessor[] { new NotNull() };

        return getParameters(ParameterPaths.DICE_TEXT, processors);
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
        final URL url; // URL parsed from the path
        final InputStream stream; // Stream for the file

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

    /**
     * Creates an {@code URL} pointing to the file specified by the path, if it
     * exists.
     * 
     * @param path
     *            the path to transform
     * @return an URL pointing inside the class path
     */
    private final URL getClassPathURL(final String path) {
        checkNotNull(path, "Received a null pointer as path");

        return this.getClass().getClassLoader().getResource(path);
    }

    private final Iterator<Object[]> getParameters(final String path,
            final CellProcessor[] processors) throws IOException {
        final Collection<Object[]> values;
        final ICsvListReader reader;
        List<Object> nextLine;

        reader = new CsvListReader(getClassPathReader(path),
                CsvPreference.STANDARD_PREFERENCE);
        reader.getHeader(true);
        values = new LinkedList<Object[]>();
        while ((nextLine = reader.read(processors)) != null) {
            values.add(nextLine.toArray());
        }
        reader.close();

        return values.iterator();
    }

}
