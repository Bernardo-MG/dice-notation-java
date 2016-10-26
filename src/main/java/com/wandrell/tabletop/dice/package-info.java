/**
 * Copyright 2015 the original author or authors
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
/**
 * Dice notation classes.
 * <p>
 * At the root of this package the {@link com.wandrell.tabletop.dice.Dice Dice}
 * interface, and the default implementation of this, the
 * {@link com.wandrell.tabletop.dice.DefaultDice DefaultDice}, offer a simple
 * model for dice groups as they are used in dice notation expressions.
 * <p>
 * To generate random values from these classes, as if these dice were rolled,
 * the classes contained inside the {@link com.wandrell.tabletop.dice.roller
 * roller} package can be used.
 * <p>
 * Notation more complex than a single group of dice is represented by the
 * classes in the {@link com.wandrell.tabletop.dice.notation notation} package,
 * which also can generate values from the expressions they represent.
 * <p>
 * The {@link com.wandrell.tabletop.dice.parser parser} package offers parsers
 * which can create and populare model classes from a text dice notation
 * expression.
 */

package com.wandrell.tabletop.dice;
