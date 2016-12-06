/*
 * 
 */
package net.atf4j.core.timers;

/**
 * A split timer Timer.
 * 
 */
public class SplitTimer extends MilliTimer {

	/**
	 * Gets the split time.
	 *
	 * @return the split time
	 */
	public final long getSplitTime() {
		return System.currentTimeMillis() - getStartTime();
	}

}
