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
 * The most basic classes for this are the
 * {@link com.wandrell.tabletop.dice.Dice} interface, and the default
 * implementation of this, the {@link com.wandrell.tabletop.dice.DefaultDice}.
 * <p>
 * With them it is possible representing the dice as these are use in dice
 * notation expression, but they offer no kind of logic for generating random
 * values from them.
 * <p>
 * For this the classes contained inside the
 * {@link com.wandrell.tabletop.dice.roller roller} and
 * {@link com.wandrell.tabletop.dice.roller.random random} packages should be
 * used.
 * <p>
 * To handle more complex dice expression structures the
 * {@link com.wandrell.tabletop.dice.parser parser} and
 * {@link com.wandrell.tabletop.dice.notation notation} packages contain the
 * parser and model needed to transform dice notation expression strings into a
 * tree which can generate random values.
 */

package com.wandrell.tabletop.dice;

