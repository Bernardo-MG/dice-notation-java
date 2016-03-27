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

import com.wandrell.tabletop.dice.roller.Roller.RollerResult;

public final class DefaultRollerResult<V> implements RollerResult<V> {

    final Collection<Integer> bare;

    final Collection<V>       mapped;

    public DefaultRollerResult(final Collection<Integer> bare,
            final Collection<V> mapped) {
        super();

        this.bare = bare;
        this.mapped = mapped;
    }

    @Override
    public final Collection<Integer> getBareRollResults() {
        return bare;
    }

    @Override
    public final Collection<V> getMappedRollResults() {
        return mapped;
    }

}
