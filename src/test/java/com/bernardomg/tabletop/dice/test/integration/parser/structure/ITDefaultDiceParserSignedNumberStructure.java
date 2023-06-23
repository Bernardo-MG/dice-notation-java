/**
 * Copyright 2014-2023 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.parser.structure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.notation.operand.IntegerOperand;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DefaultDiceParser parses the expected structure for signed numbers")
public final class ITDefaultDiceParserSignedNumberStructure {

    /**
     * Default constructor.
     */
    public ITDefaultDiceParserSignedNumberStructure() {
        super();
    }

    @Test
    @DisplayName("A negative number returns the expected structure")
    public final void testParse_Negative() {
        final IntegerOperand operation; // Parsed expression

        operation = (IntegerOperand) new DefaultDiceParser().parse("-12");

        Assertions.assertThat(operation.getValue())
            .isEqualTo(-12);
    }

    @Test
    @DisplayName("A positive number returns the expected structure")
    public final void testParse_Positive() {
        final IntegerOperand operation; // Parsed expression

        operation = (IntegerOperand) new DefaultDiceParser().parse("+12");

        Assertions.assertThat(operation.getValue())
            .isEqualTo(12);
    }

}
