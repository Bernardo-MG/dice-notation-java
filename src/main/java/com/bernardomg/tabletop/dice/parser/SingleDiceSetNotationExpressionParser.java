/**
 * Copyright 2014-2017 the original author or authors
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

package com.bernardomg.tabletop.dice.parser;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operand.DiceOperand;
import com.bernardomg.tabletop.dice.parser.listener.DiceOperandExpressionBuilder;

/**
 * Dice notation parser which returns a dice expression.
 * <p>
 * It reuses the {@link DiceNotationExpressionParser} through composition, by
 * setting it up with {@link DiceOperandExpressionBuilder}.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class SingleDiceSetNotationExpressionParser
        implements DiceNotationExpressionParser<DiceOperand> {

    /**
     * A wrapped parser to reuse the common operations through composition.
     */
    private final DiceNotationExpressionParser<DiceNotationExpression> wrappedParser;

    /**
     * Default constructor.
     */
    public SingleDiceSetNotationExpressionParser() {
        super();

        wrappedParser = new DefaultDiceNotationExpressionParser(
                new DiceOperandExpressionBuilder());
    }

    @Override
    public final DiceOperand parse(final String expression) {
        final DiceNotationExpression parsed; // Parsed expression

        checkNotNull(expression, "Received a null pointer as string");

        parsed = wrappedParser.parse(expression);

        if (parsed == null) {
            // TODO: Try to extend the error listener
            throw new IllegalStateException(
                    "The expression doesn't match a dice set");
        }

        checkArgument(parsed instanceof DiceOperand,
                "Didn't parse a dice object");

        return (DiceOperand) parsed;
    }

}
