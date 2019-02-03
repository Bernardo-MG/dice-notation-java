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
 * Dice classes, including the model for dice.
 * <h3>Model</h3>
 * <p>
 * The {@link com.bernardomg.tabletop.dice.Dice Dice} interface, and the default
 * implementation of this, the {@link com.bernardomg.tabletop.dice.DefaultDice
 * DefaultDice}, offer a simple model for dice groups.
 * <h3>Sub-packages</h3>
 * <p>
 * The packages inside this one extend over the basic dice in various ways.
 * <p>
 * With the {@link com.bernardomg.tabletop.dice.random random} package it is
 * possible generating random values. Meant to customise the transformers.
 * <p>
 * These transformers are stored inside the
 * {@link com.bernardomg.tabletop.dice.interpreter transformer} package and can
 * be used to create an object from any parsed dice notation.
 * <p>
 * The actual dice notation, including operations, is inside the
 * {@link com.bernardomg.tabletop.dice.notation notation} package.
 * <p>
 * While the {@link com.bernardomg.tabletop.dice.parser parser} package hosts
 * parsers which can transform an expression into an object tree.
 */

package com.bernardomg.tabletop.dice;
