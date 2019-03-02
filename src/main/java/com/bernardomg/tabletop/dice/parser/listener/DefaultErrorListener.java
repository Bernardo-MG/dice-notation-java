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

package com.bernardomg.tabletop.dice.parser.listener;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic error listener for an ANTLR4 parser.
 * <p>
 * It just throws an exception for any error the listener intercepts.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
public final class DefaultErrorListener extends BaseErrorListener {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DefaultErrorListener.class);

    /**
     * Default constructor.
     */
    public DefaultErrorListener() {
        super();
    }

    @Override
    public final void syntaxError(final Recognizer<?, ?> recognizer,
            final Object offendingSymbol, final int line,
            final int charPositionInLine, final String msg,
            final RecognitionException e) {
        final String message; // Final exception message

        message = String.format(
                "Failed to parse at line %1$d on char %2$d due to %3$s", line,
                charPositionInLine + 1, msg);

        LOGGER.error(message);

        throw new IllegalStateException(message, e);
    }

}
