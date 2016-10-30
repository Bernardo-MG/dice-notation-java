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
 * Dice notation model.
 * <p>
 * The classes in this package allow creating a tree representing a dice
 * notation expression, which can be used to generate values, or to get back the
 * dice notation expression it represents.
 * <p>
 * As these expressions are used to handle the generation of random numbers, in
 * some cases the generated value may be different each time it is acquired.
 * <p>
 * It is not recommended using the classes in this package manually. Instead a
 * parser from the {@link com.wandrell.tabletop.dice.parser parser} package
 * should be used.
 */

package com.wandrell.tabletop.dice.notation;
