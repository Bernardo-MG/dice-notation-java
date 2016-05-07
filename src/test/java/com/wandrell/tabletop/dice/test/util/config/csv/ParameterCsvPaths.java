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

package com.wandrell.tabletop.dice.test.util.config.csv;

/**
 * Paths to the CSV files with the test parameters.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ParameterCsvPaths {

    /**
     * Dice and text.
     * <p>
     * It contains the text representation of a dice group, followed by its
     * quantity and sides.
     */
    public static final String DICE_AND_TEXT     = "parameter/dice-text.csv";

    /**
     * Dice text.
     * <p>
     * It contains strings which are not valid dice.
     */
    public static final String DICE_TEXT_INVALID = "parameter/dice-grammar-invalid.csv";

    /**
     * Dice text.
     * <p>
     * It contains strings which are valid dice.
     */
    public static final String DICE_TEXT_VALID   = "parameter/dice-grammar-valid.csv";

    /**
     * Private constructor to avoid initialization.
     */
    private ParameterCsvPaths() {
        super();
    }

}
