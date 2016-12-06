/*
 * 
 */
package net.atf4j.core.timers;

import java.util.Enumeration;
import java.util.Stack;

/**
 * NestedTimers. @pattern[GOF] Singleton.
 * 
 */
public final class NestedTimers {

	/** Singleton INSTANCE of this Class. */
	private static final NestedTimers INSTANCE = new NestedTimers();

	/** A FIFO stack of running timers. */
	private final Stack<MilliTimer> runningTimers = new Stack<MilliTimer>();

	/** A FIFO stack of stopped timers. */
	private final Stack<MilliTimer> stoppedTimers = new Stack<MilliTimer>();

	/**
	 * Instantiates a new nested timers collection.
	 */
	private NestedTimers() {
	}

	/**
	 * getInstance.
	 * 
	 * @return NestedTimers
	 */
	public static NestedTimers getInstance() {
		return NestedTimers.INSTANCE;
	}

	/**
	 * getInstance.
	 * 
	 * @param timerName
	 *            the timer name
	 * @return NestedTimers
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
		timer.start();
		this.runningTimers.push(timer);
		return timer;
	}

	/**
	 * stop the top timer.
	 * 
	 * @return NestedTimers
	 */
	public static ITimer stop() {
		return getInstance().stopTimer();
	}

	/**
	 * stop the top Timer.
	 * 
	 * @return Timer.
	 */
	public ITimer stopTimer() {
		final MilliTimer timer = this.runningTimers.pop();
		timer.stop();
		this.stoppedTimers.push(timer);
		return timer;
	}

	/**
	 * stopAll.
	 * 
	 * @return NestedTimers
	 */
	public static NestedTimers stopAll() {
		return getInstance().stopAllTimers();
	}

	/**
	 * stopAll timers.
	 * 
	 * @return NestedTimers
	 */
	public NestedTimers stopAllTimers() {
		for (final MilliTimer timer : this.runningTimers) {
			this.stoppedTimers.push(timer.stop());
		}
		return this;
	}

	/**
	 * Running timers.
	 * 
	 * @return the enumeration
	 * @see java.util.Vector#elements()
	 */
	public Enumeration<MilliTimer> runningTimers() {
		return this.runningTimers.elements();
	}

	/**
	 * Stopped timers.
	 * 
	 * @return the enumeration
	 * @see java.util.Vector#elements()
	 */
	public Enumeration<MilliTimer> stoppedTimers() {
		return this.stoppedTimers.elements();
	}

	/**
	 * runningTimersAsString.
	 * 
	 * @return the string
	 */
	public String runningTimersAsString() {
		final StringBuffer stringBuffer = new StringBuffer();
		final Enumeration<MilliTimer> running = this.runningTimers.elements();
		while (running.hasMoreElements()) {
			stringBuffer.append(running.nextElement().toString() + "\n");
		}
		return stringBuffer.toString();
	}

	/**
	 * stoppedTimersAsString.
	 * 
	 * @return the string
	 */
	public String stoppedTimersAsString() {
		final StringBuffer stringBuffer = new StringBuffer();
		final Enumeration<MilliTimer> stopped = this.stoppedTimers.elements();
		while (stopped.hasMoreElements()) {
			stringBuffer.append(stopped.nextElement().toString() + "\n");
		}
		return stringBuffer.toString();
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
