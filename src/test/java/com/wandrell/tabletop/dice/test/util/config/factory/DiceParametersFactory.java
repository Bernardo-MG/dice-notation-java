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

package com.wandrell.tabletop.dice.test.util.config.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvListReader;
import org.supercsv.io.ICsvListReader;
import org.supercsv.prefs.CsvPreference;

import com.wandrell.tabletop.dice.test.util.config.csv.ParameterCsvPaths;

/**
 * Factory for acquiring the parameters used by dice tests.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class DiceParametersFactory {

    /**
     * Returns the parameters for tests requiring a dice string, along the
     * quantity and number of sides for that dice group.
     * <p>
     * This returns dice notation expressions representing only a single dice
     * group.
     * 
     * @return arrays with a dice string, the quantity of dice and the number of
     *         sides
     * @throws Exception
     *             if any error occurs while loading the parameters
     */
    public static final Iterator<Object[]> getDiceAndText() throws Exception {
        final CellProcessor[] processors; // Procesors for the CSV file

        // The CSV has the following columns:
        // Anything, integer, integer
        processors = new CellProcessor[] { new NotNull(), new ParseInt(),
                new ParseInt() };

        return getParameters(ParameterCsvPaths.DICE_AND_TEXT, processors);
    }

    /**
     * Returns the parameters for tests requiring an invalid dice notation
     * expression.
     * 
     * @return arrays with an invalid dice notation expression
     * @throws Exception
     *             if any error occurs while loading the parameters
     */
    public static final Iterator<Object[]> getDiceNotationInvalid()
            throws Exception {
        final CellProcessor[] processors; // Procesors for the CSV file

        // The CSV has the following columns:
        // Anything
        processors = new CellProcessor[] { new NotNull() };

        return getParameters(ParameterCsvPaths.DICE_TEXT_INVALID, processors);
    }

    /**
     * Returns the parameters for tests requiring a valid dice notation
     * expression.
     * 
     * @return arrays with a valid dice notation expression
     * @throws Exception
     *             if any error occurs while loading the parameters
     */
    public static final Iterator<Object[]> getDiceNotationValid()
            throws Exception {
        final CellProcessor[] processors; // Procesors for the CSV file

        // The CSV has the following columns:
        // Anything
        processors = new CellProcessor[] { new NotNull() };

        return getParameters(ParameterCsvPaths.DICE_TEXT_VALID, processors);
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
     * @throws IOException
     *             if any problem occurs while reading the file
     */
    private static final Reader getClassPathReader(final String path)
            throws IOException {
        return new BufferedReader(new InputStreamReader(new ClassPathResource(
                path).getInputStream()));
    }

    /**
     * Acquires the parameters from a CSV file.
     * 
     * @param path
     *            path to the CSV file
     * @param processors
     *            processors for the file columns
     * @return an {@code Iterator} for the parameter arrays
     * @throws IOException
     *             if any error occurs while processing the file
     */
    private static final Iterator<Object[]> getParameters(final String path,
            final CellProcessor[] processors) throws IOException {
        final Collection<Object[]> parameters; // Parameters read
        final ICsvListReader reader;           // CSV reader
        List<Object> nextLine;                 // CSV file line

        reader = new CsvListReader(getClassPathReader(path),
                CsvPreference.STANDARD_PREFERENCE);
        reader.getHeader(true);

        parameters = new LinkedList<Object[]>();
        while ((nextLine = reader.read(processors)) != null) {
            parameters.add(nextLine.toArray());
        }
        reader.close();

        return parameters.iterator();
    }

    /**
     * Default constructor.
     */
    private DiceParametersFactory() {
        super();
    }

}
