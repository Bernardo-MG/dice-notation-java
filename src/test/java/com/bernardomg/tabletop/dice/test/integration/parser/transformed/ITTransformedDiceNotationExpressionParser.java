
package com.bernardomg.tabletop.dice.test.integration.parser.transformed;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.bernardomg.tabletop.dice.parser.TransformedDiceNotationExpressionParser;
import com.bernardomg.tabletop.dice.parser.transformer.RollerTransformer;

/**
 * Integration tests for {@link TransformedDiceNotationExpressionParser},
 * verifying that it transforms the parsed result.
 * 
 * @author Bernardo Mart&iacute;nez Garrido
 */
@RunWith(JUnitPlatform.class)
public final class ITTransformedDiceNotationExpressionParser {

    /**
     * Default constructor.
     */
    public ITTransformedDiceNotationExpressionParser() {
        super();
    }

    /**
     * Verifies that an addition is parsed and transformed.
     */
    @Test
    public final void testParse_Addition_Result() {
        final String notation; // Input to parse
        Integer parsed;

        notation = "1-2-3";

        parsed = new TransformedDiceNotationExpressionParser<>(
                new RollerTransformer()).parse(notation);

        Assertions.assertEquals(new Integer(-4), parsed);
    }

}
