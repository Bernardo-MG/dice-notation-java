/**
 * Copyright 2014-2017 the original author or authors
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
 * Listeners for the dice notation parsers.
 * <p>
 * The {@link com.wandrell.tabletop.dice.parser.listener.DiceExpressionBuilder
 * DiceExpressionBuilder} is used by the
 * {@link com.wandrell.tabletop.dice.parser.DefaultDiceNotationExpressionParser
 * DefaultDiceNotationExpressionParser} as a visitor. It will create the
 * returned dice notation model tree as it goes through the parsed grammar tree.
 * <p>
 * The {@link com.wandrell.tabletop.dice.parser.listener.DefaultErrorListener
 * DefaultErrorListener} is also used by the
 * {@code DefaultDiceNotationExpressionParser}, but to throw exceptions when
 * there is a parsing error.
 */

package com.wandrell.tabletop.dice.parser.listener;
