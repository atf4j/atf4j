/*
 * 
 */
package net.atf4j.core.timers;

/**
 * Encapsulate an Interval of Time in a [GOF] Memento.
 * 
 */
public class Interval {

	/** The Constant SECOND. */
	public static final int SECOND = 1000;

	/** The Constant MINUTE. */
	public static final int MINUTE = 60 * SECOND;

	/** The Constant HOUR. */
	public static final int HOUR = 60 * MINUTE;

	/** The Constant DAY. */
	public static final int DAY = 24 * HOUR;

	/** The time period. */
	private final long timePeriod;

	/**
	 * Instantiates a new interval.
	 */
	public Interval() {
		this.timePeriod = 0L;
	}

	/**
	 * Interval.
	 * 
	 * @param useTimePeriod
	 *            the use time period
	 */
	public Interval(final long useTimePeriod) {
		this.timePeriod = useTimePeriod;
	}

	/**
	 * factory method helper inMilliSeconds.
	 * 
	 * @param timePeriod
	 *            the use time period
	 * @return new Interval object.
	 */
	public static Interval inMilliSeconds(final long timePeriod) {
		return new Interval(timePeriod);
	}

	/**
	 * inSeconds.
	 * 
	 * @param timePeriod
	 *            in Seconds.
	 * @return new Interval object.
	 */
	public static Interval inSeconds(final long timePeriod) {
		return new Interval(timePeriod * Interval.SECOND);
	}

	/**
	 * inMinutes.
	 * 
	 * @param timePeriod
	 *            in Minutes.
	 * @return new Interval object.
	 */
	public static Interval inMinutes(final long timePeriod) {
		return new Interval(timePeriod * Interval.MINUTE);
	}

	/**
	 * inHours.
	 * 
	 * @param timePeriod
	 *            in Hours.
	 * @return new Interval object.
	 */
	public static Interval inHours(final long timePeriod) {
		return new Interval(timePeriod * Interval.HOUR);
	}

	/**
	 * inDays.
	 * 
	 * @param timePeriod
	 *            in Days.
	 * @return new Interval object.
	 */
	public static Interval inDays(final long timePeriod) {
		return new Interval(timePeriod * Interval.DAY);
	}

	/**
	 * asMilliSeconds.
	 * 
	 * @return timePeriod of Interval in Milliseconds as long.
	 */
	public final long asMilliSeconds() {
		return this.timePeriod;
	}

	/**
	 * asSeconds.
	 * 
	 * @return timePeriod of Interval in seconds as long.
	 */
	public final long asSeconds() {
		return this.timePeriod / SECOND;
	}

	/**
	 * asMinutes.
	 * 
	 * @return timePeriod of Interval in seconds as long.
	 */
	public final long asMinutes() {
		return this.timePeriod / MINUTE;
	}

	/**
	 * asHours.
	 * 
	 * @return timePeriod of Interval in seconds as long.
	 */
	public final long asHours() {
		return this.timePeriod / HOUR;
	}

	/**
	 * asDays.
	 * 
	 * @return timePeriod of Interval in seconds as long.
	 */
	public final long asDays() {
		return this.timePeriod / DAY;
	}

	/**
	 * asLong.
	 * 
	 * @return timePeriod of Interval in Milliseconds as long.
	 */
	public final long asLong() {
		return this.timePeriod;
	}

}
