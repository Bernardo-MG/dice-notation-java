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

package com.wandrell.tabletop.dice.parser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.TokenStream;

import com.wandrell.tabletop.dice.generated.DiceNotationLexer;
import com.wandrell.tabletop.dice.generated.DiceNotationParser;
import com.wandrell.tabletop.dice.notation.DiceExpression;
import com.wandrell.tabletop.dice.parser.listener.DiceFormulaBuilder;

public final class DiceExpressionParser {

	public DiceExpressionParser() {
		super();
	}

	public final DiceExpression parse(final String string) {
		final ANTLRInputStream input;
		final DiceNotationLexer lexer;
		final TokenStream tokens;
		final DiceNotationParser parser;
		final DiceFormulaBuilder diceNotationListener;

		input = new ANTLRInputStream(string);
		lexer = new DiceNotationLexer(input);
		tokens = new CommonTokenStream(lexer);

		parser = new DiceNotationParser(tokens);

		parser.addErrorListener(new BaseErrorListener() {

			@Override
			public void syntaxError(Recognizer<?, ?> recognizer,
					Object offendingSymbol, int line, int charPositionInLine,
					String msg, RecognitionException e) {
				final String message;

				message = String.format(
						"failed to parse at line %d on char %d due to %s",
						line, charPositionInLine + 1, msg);

				throw new IllegalStateException(message, e);
			}
		});

		diceNotationListener = new DiceFormulaBuilder();

		parser.addParseListener(diceNotationListener);

		parser.parse();

		return diceNotationListener.getDiceExpression();
	}

}
