package com.wandrell.tabletop.dice.parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class DefaultErrorListener extends BaseErrorListener {

	public DefaultErrorListener() {
		super();
	}

	@Override
	public final void syntaxError(final Recognizer<?, ?> recognizer,
			final Object offendingSymbol, final int line,
			final int charPositionInLine, final String msg,
			final RecognitionException e) {
		final String message;

		message = String.format(
				"failed to parse at line %d on char %d due to %s", line,
				charPositionInLine + 1, msg);

		throw new IllegalStateException(message, e);
	}

}
