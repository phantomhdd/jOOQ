/**
 * Copyright (c) 2009-2014, Data Geekery GmbH (http://www.datageekery.com)
 * All rights reserved.
 *
 * This work is dual-licensed
 * - under the Apache Software License 2.0 (the "ASL")
 * - under the jOOQ License and Maintenance Agreement (the "jOOQ License")
 * =============================================================================
 * You may choose which license applies to you:
 *
 * - If you're using this work with Open Source databases, you may choose
 *   either ASL or jOOQ License.
 * - If you're using this work with at least one commercial database, you must
 *   choose jOOQ License
 *
 * For more information, please visit http://www.jooq.org/licenses
 *
 * Apache Software License 2.0:
 * -----------------------------------------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * jOOQ License and Maintenance Agreement:
 * -----------------------------------------------------------------------------
 * Data Geekery grants the Customer the non-exclusive, timely limited and
 * non-transferable license to install and use the Software under the terms of
 * the jOOQ License and Maintenance Agreement.
 *
 * This library is distributed with a LIMITED WARRANTY. See the jOOQ License
 * and Maintenance Agreement for more details: http://www.jooq.org/licensing
 */
package org.jooq.test._.listeners;

import static org.jooq.test._.listeners.Lifecycle.METHOD_COMPARATOR;
import static org.jooq.test._.listeners.Lifecycle.increment;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

import org.jooq.ExecuteContext;
import org.jooq.impl.DefaultExecuteListener;

/**
 * An <code>ExecuteListener</code> that collects data about the lifecycle of
 * execute listeners in all integration tests.
 *
 * @author Lukas Eder
 */
public class LifecycleWatcherListener extends DefaultExecuteListener {

    /**
     * Generated UID
     */
    private static final long                serialVersionUID     = -2283264126211556442L;

    public static final Map<Method, Integer> LISTENER_START_COUNT = new TreeMap<Method, Integer>(METHOD_COMPARATOR);
    public static final Map<Method, Integer> LISTENER_END_COUNT   = new TreeMap<Method, Integer>(METHOD_COMPARATOR);

    @Override
    public void start(ExecuteContext ctx) {
        super.start(ctx);
        increment(LISTENER_START_COUNT);
    }

    @Override
    public void end(ExecuteContext ctx) {
        super.end(ctx);
        increment(LISTENER_END_COUNT);
    }
}