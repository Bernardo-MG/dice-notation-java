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

/**
 * Dice notation parsers.
 * <p>
 * These will take a string with a dice notation expression and return a tree of
 * dice notation model objects.
 * <p>
 * The {@link com.wandrell.tabletop.dice.parser.DiceNotationParser
 * DiceNotationParser} allows creating custom parsers, but one is already
 * implemented, the
 * {@link com.wandrell.tabletop.dice.parser.DefaultDiceNotationParser
 * AntlrDiceNotationParser}, which makes use of the classes generated from an
 * ANTLR4 grammar to parse dice expressions.
 */

package com.wandrell.tabletop.dice.parser;

