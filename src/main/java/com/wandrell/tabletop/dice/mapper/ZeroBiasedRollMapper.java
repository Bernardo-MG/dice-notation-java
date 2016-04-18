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

package com.wandrell.tabletop.dice.mapper;

/**
 * Maps the rolls to a zero-biased spread.
 * <p>
 * This means that the values will begin in 0, instead of 1. It has the
 * additional effect of reducing the maximum value on 1 too.
 * 
 * @author Bernardo Martínez Garrido
 */
public final class ZeroBiasedRollMapper implements RollMapper<Integer> {

	/**
	 * Default constructor.
	 */
	public ZeroBiasedRollMapper() {
		super();
	}

	/**
	 * Transforms the received value into the zero-biased equivalent of it.
	 * <p>
	 * This means that the value will be reduced in one digit.
	 * 
	 * @param roll
	 *            the roll value to transform
	 * @return the zero-biased equivalent of the roll
	 */
	@Override
	public final Integer getValueFor(final Integer roll) {
		return roll - 1;
	}

}
