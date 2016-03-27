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

public interface Roller {

    public interface RollerResult<V> {

        public Collection<Integer> getBareRollResults();

        public Collection<V> getMappedRollResults();

    }

    public interface RollMapper<V> {

        public V getValueFor(final Integer roll);

    }

    public RollerResult<Integer> roll(final Dice dice);

    public <V> RollerResult<V> roll(final Dice dice,
            final RollMapper<V> mapper);

}
