/*
 * 
 */
package net.atf4j.core.timers;

/**
 * The Interface ITimer.
 */
public interface ITimer {

	/**
	 * start timer.
	 * 
	 * @return the timer
	 */
	public abstract ITimer start();

	/**
	 * stop timer.
	 * 
	 * @return the timer
	 */
	public abstract ITimer stop();

	/**
	 * Gets the elapsed time.
	 * 
	 * @return time in milliseconds as long.
	 */
	public abstract long getElapsedTime();

	/**
	 * Gets the start time.
	 * 
	 * @return start time in milliseconds as long.
	 */
	public abstract long getStartTime();

}