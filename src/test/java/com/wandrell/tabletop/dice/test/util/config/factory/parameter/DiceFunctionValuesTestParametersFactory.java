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

package com.wandrell.tabletop.dice.test.util.config.factory.parameter;

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
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.wandrell.tabletop.dice.test.util.config.ParameterPaths;

public final class DiceFunctionValuesTestParametersFactory {

    private static final DiceFunctionValuesTestParametersFactory instance = new DiceFunctionValuesTestParametersFactory();

    public static final DiceFunctionValuesTestParametersFactory getInstance() {
        return instance;
    }

    private DiceFunctionValuesTestParametersFactory() {
        super();
        // TODO: Make these methods final
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

    public final Iterator<Object[]> getHighestKeep() {
        return getParameters(ParameterPaths.FUNCTION_EXTREMES_KEEP_HIGHEST);
    }

    public final Iterator<Object[]> getHighestRemove() {
        return getParameters(ParameterPaths.FUNCTION_EXTREMES_REMOVE_HIGHEST);
    }

    public final Iterator<Object[]> getLowestKeep() {
        return getParameters(ParameterPaths.FUNCTION_EXTREMES_KEEP_LOWEST);
    }

    public final Iterator<Object[]> getLowestRemove() {
        return getParameters(ParameterPaths.FUNCTION_EXTREMES_REMOVE_LOWEST);
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

    @SuppressWarnings("unchecked")
    private final Collection<Integer> getCollection(final Object obj) {
        final Collection<Integer> col;

        if ((obj != null) && (obj instanceof Collection)) {
            col = (Collection<Integer>) obj;
        } else {
            col = new LinkedList<Integer>();
        }

        return col;
    }

    @SuppressWarnings("unchecked")
    private final Iterator<Object[]> getParameters(final String path) {
        final Yaml yaml;
        final Collection<Map<String, Object>> data;
        final Collection<Object[]> result;
        Collection<Object> group;

        yaml = new Yaml();
        data = (Collection<Map<String, Object>>) yaml
                .load(getClassPathReader(path));
        result = new LinkedList<Object[]>();
        for (final Map<String, Object> map : data) {
            group = new LinkedList<Object>();
            group.add(map.get("count"));
            group.add(getCollection(map.get("rolls")));
            group.add(getCollection(map.get("results")));

            result.add(group.toArray());
        }

        return result.iterator();
    }

}
