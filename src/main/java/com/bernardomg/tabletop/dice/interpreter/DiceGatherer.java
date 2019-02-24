/**
 * Copyright 2014-2019 the original author or authors
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

package com.bernardomg.tabletop.dice.interpreter;

import com.bernardomg.tabletop.dice.Dice;
import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.visitor.DiceAccumulator;

/**
 * Dice notation expression which returns all the dice sets contained inside the
 * expression.
 * <p>
 * This will search for dice operands, and acquire the dice inside of them.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class DiceGatherer implements DiceInterpreter<Iterable<Dice>> {

    private final DiceInterpreter<Iterable<Dice>> wrapped;

    /**
     * Default constructor.
     */
    public DiceGatherer() {
        super();

        wrapped = new ConfigurableInterpreter<>(new InorderTraverser(),
                new DiceAccumulator());
    }

    @Override
    public final Iterable<Dice>
            transform(final DiceNotationExpression expression) {
        return wrapped.transform(expression);
    }

}
