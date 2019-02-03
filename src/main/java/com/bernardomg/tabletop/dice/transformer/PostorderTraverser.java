
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
 * <p>
 * The tree {@code ((1 + 2) - 3)} becomes {@code 1 2 + 3 -} with this
 * transformer.
 *
 * @author Bernardo Mart&iacute;nez Garrido
 *
 */
public final class PostorderTraverser
        implements DiceInterpreter<Iterable<DiceNotationExpression>> {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PostorderTraverser.class);

    /**
     * Default constructor.
     */
    public PostorderTraverser() {
        super();
    }

    @Override
    public final Iterable<DiceNotationExpression>
            transform(final DiceNotationExpression expression) {
        final Stack<DiceNotationExpression> nodes;
        final Collection<DiceNotationExpression> exps;
        DiceNotationExpression current;

        checkNotNull(expression, "Received a null pointer as expression");

        nodes = new Stack<>();
        nodes.push(expression);

        exps = new ArrayList<>();
        while (!nodes.isEmpty()) {
            current = nodes.pop();
            LOGGER.debug("Transforming expression {}", current);
            if (current instanceof BinaryOperation) {
                // Binary operation
                // Prunes node and stores left and right nodes
                nodes.push(new DefaultOperation(
                        ((BinaryOperation) current).getOperation()));
                nodes.push(((BinaryOperation) current).getRight());
                nodes.push(((BinaryOperation) current).getLeft());
            } else {
                // Leaf node
                exps.add(current);
            }
        }

        return exps;
    }

}