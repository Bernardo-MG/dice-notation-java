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

package com.bernardomg.tabletop.dice.notation.operand;

import lombok.Data;
import lombok.NonNull;

/**
 * Operand for an integer constant value.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@Data
public final class IntegerOperand implements ConstantOperand {

    /**
     * Operand value.
     */
    @NonNull
    private final Integer value;

    @Override
    public final String getExpression() {
        return getValue().toString();
    }

}
