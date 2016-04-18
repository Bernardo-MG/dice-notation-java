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

package com.wandrell.tabletop.dice.roller;

import java.util.Collection;

import com.wandrell.tabletop.dice.Dice;

/**
 * Generates a random result from a {@link Dice}.
 * <p>
 * The name makes reference to the act of rolling the dice, which is the way to
 * generate random values from them.
 * <p>
 * A {@code Roller} does not need to generate integer values, it can return any
 * kind of value, allowing the dice to be mapped to anything as needed.
 * 
 * @author Bernardo Martínez Garrido
 * @param <V>
 *            the type of value to return
 * @see Dice
 */
public interface Roller<V> {

	/**
	 * Generates a collection of random values from the received {@code Dice}.
	 * 
	 * @param dice
	 *            the dice to roll
	 * @return a collection of random values
	 */
	public Collection<V> roll(final Dice dice);

}
