/*
 * 
 */
package net.atf4j.core.timers;

import java.util.HashMap;
import java.util.Set;

/**
 * MappedTimers. @pattern[GOF] Singleton.
 * 
 */
public final class MappedTimers {

	/** Singleton INSTANCE of this Class. */
	private static final MappedTimers INSTANCE = new MappedTimers();

	/** The running timers. */
	private final HashMap<String, MilliTimer> runningTimers = new HashMap<String, MilliTimer>();

	/** The stopped timers. */
	private final HashMap<String, MilliTimer> stoppedTimers = new HashMap<String, MilliTimer>();

	/**
	 * Instantiates a new mapped timers.
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

	/**
	 * getInstance.
	 * 
	 * @param timerName
	 *            as String.
	 * @return TimerStack
	 */
	public static ITimer start(final String timerName) {
		return getInstance().startTimer(timerName);
	}

	/**
	 * start a new Timer.
	 * 
	 * @param timerName
	 *            as String.
	 * @return Timer.
	 */
	public ITimer startTimer(final String timerName) {
		final MilliTimer timer = new MilliTimer(timerName);
		this.runningTimers.put(timerName, timer);
		timer.start();
		return timer;
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

	/**
	 * To string.
	 * 
	 * @return the string
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s [runningTimers=%s,stoppedTimers=%s]", this.getClass().getSimpleName(),
				this.runningTimers, this.stoppedTimers);
	}
}
