
package com.bernardomg.tabletop.dice.transformer;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bernardomg.tabletop.dice.notation.DiceNotationExpression;
import com.bernardomg.tabletop.dice.notation.operation.BinaryOperation;
import com.bernardomg.tabletop.dice.notation.operation.DefaultOperation;

/**
 * Breaks down the received expression into a postorder list.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class PostorderTransformer
        implements DiceInterpreter<Iterable<DiceNotationExpression>> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PostorderTransformer.class);

    /**
     * Default constructor.
     */
    public PostorderTransformer() {
        super();
    }

    @Override
    public final Iterable<DiceNotationExpression>
            transform(final DiceNotationExpression expression) {
        final Stack<DiceNotationExpression> exps;
        final Collection<DiceNotationExpression> result;
        DiceNotationExpression current;

        checkNotNull(expression, "Received a null pointer as expression");

        exps = new Stack<>();
        exps.push(expression);

        result = new ArrayList<>();
        while (!exps.isEmpty()) {
            current = exps.pop();
            LOGGER.debug("Transforming expression {}", current);
            if (current instanceof BinaryOperation) {
                // Binary operation
                // Prunes node and stores left and right nodes
                exps.push(new DefaultOperation(
                        ((BinaryOperation) current).getOperation()));
                exps.push(((BinaryOperation) current).getRight());
                exps.push(((BinaryOperation) current).getLeft());
            } else {
                // Leaf node
                result.add(current);
            }
        }

        return result;
    }

}
