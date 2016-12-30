/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 *
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with atf4j.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.atf4j.core.timers;

import java.util.HashMap;
import java.util.Set;

/**
 * MappedTimers. [GOF] Singleton.
 *
 */
public final class MappedTimers {

    /** Single INSTANCE of this Class. */
    private static final MappedTimers INSTANCE = new MappedTimers();

    /** The running timers. */
    private final HashMap<String, MilliTimer> runningTimers = new HashMap<String, MilliTimer>();

    /** The stopped timers. */
    private final HashMap<String, MilliTimer> stoppedTimers = new HashMap<String, MilliTimer>();

    /**
     * Private constructor to prevent wild instantiation.
     */
    private MappedTimers() {
    }

    /**
     * getInstance.
     *
     * @return TimerStack
     */
    public static MappedTimers getInstance() {
        return MappedTimers.INSTANCE;
    }

    public static ITimer start(final String timerName) {
        return getInstance().startTimer(timerName);
    }

    public ITimer startTimer(final String timerName) {
        final MilliTimer timer = new MilliTimer(timerName);
        this.runningTimers.put(timerName, timer);
        timer.start();
        return timer;
    }

    public static ITimer stop(final String timerName) {
        return getInstance().stopTimer(timerName);
    }

    /**
     * stop the top Timer.
     *
     * @param timerName
     *            as String.
     * @return Timer.
     */
    public ITimer stopTimer(final String timerName) {
        final MilliTimer timer = this.runningTimers.get(timerName);
        timer.stop();
        this.stoppedTimers.put(timerName, timer);
        return timer;
    }

    /**
     * stopAll.
     */
    public static void stopAll() {
        getInstance().stopAllTimers();
    }

    /**
     * stopAllTimers.
     */
    public void stopAllTimers() {
        final Set<String> keys = this.runningTimers.keySet();
        for (final String key : keys) {
            stopTimer(key);
        }
    }

    public String debugString() {
        return String.format("%s [runningTimers=%s,stoppedTimers=%s]", this.getClass().getSimpleName(),
                this.runningTimers, this.stoppedTimers);
    }

    @Override
    public String toString() {
        return debugString();
    }
}
