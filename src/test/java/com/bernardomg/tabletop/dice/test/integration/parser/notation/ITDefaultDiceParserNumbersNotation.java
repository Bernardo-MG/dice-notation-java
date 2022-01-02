/**
 * Copyright 2014-2022 the original author or authors
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

package com.bernardomg.tabletop.dice.test.integration.parser.notation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.parser.DefaultDiceParser;

@DisplayName("DefaultDiceParser returns back the parsed expression")
public final class ITDefaultDiceParserNumbersNotation {

    public ITDefaultDiceParserNumbersNotation() {
        super();
    }

    @Test
    @DisplayName("An addition using only numbers returns the expression")
    public final void testParse_Number_Add() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A long addition using only numbers returns the expression")
    public final void testParse_Number_Add_Long() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2+3";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A longer addition using only numbers returns the expression")
    public final void testParse_Number_Add_Longer() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2+3+4+5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("An addition and subtraction using only numbers returns the expression")
    public final void testParse_Number_AddAndSub() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1+2-3";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A subtraction using only numbers returns the expression")
    public final void testParse_Number_Sub() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1-2";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A long subtraction using only numbers returns the expression")
    public final void testParse_Number_Sub_Long() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1-2-3";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A longer subtraction using only numbers returns the expression")
    public final void testParse_Number_Sub_Longer() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1-2-3-4-5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A subtraction followed by an addition using only numbers returns the expression")
    public final void testParse_Number_SubAndAdd() {
        final String notation;                  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "3-1+2";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

}
