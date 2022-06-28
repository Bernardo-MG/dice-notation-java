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
public final class ITDefaultDiceParserNotation {

    public ITDefaultDiceParserNotation() {
        super();
    }

    @Test
    @DisplayName("Addition returns the expression")
    public final void testParse_Add_Dice() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d20+2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("Addition with a number on the left returns the expression")
    public final void testParse_Add_LeftNumber() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "5+2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("Addition with a number on the right returns the expression")
    public final void testParse_Add_RightNumber() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "2d6+5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A dice expression returns the expression")
    public final void testParse_Dice() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A dice expression with a big d returns the expression")
    public final void testParse_Dice_BigD() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1D6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals("1d6", operation.getExpression());
    }

    @Test
    @DisplayName("A mixed expression returns the expression")
    public final void testParse_Mixed() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d20-5*1d8+2d6/3d12";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A dice expression with no quantity returns the expression")
    public final void testParse_NoQuantity() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals("1d6", operation.getExpression());
    }

    @Test
    @DisplayName("A subtraction returns the expression")
    public final void testParse_Sub_Dice() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "1d20-2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A subtraction with a number on the left returns the expression")
    public final void testParse_Sub_LeftNumber() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "5-2d6";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

    @Test
    @DisplayName("A subtraction with a number on the right returns the expression")
    public final void testParse_Sub_RightNumber() {
        final String                 notation;  // Input to parse
        final DiceNotationExpression operation; // Parsed operation

        notation = "2d6-5";

        operation = new DefaultDiceParser().parse(notation);

        Assertions.assertEquals(notation, operation.getExpression());
    }

}
