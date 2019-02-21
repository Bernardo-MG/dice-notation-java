
package com.bernardomg.tabletop.dice.visitor;

public interface NotationAccumulator<V> extends NotationVisitor<V> {

    public V getValue();

}
