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
package net.atf4j.core.waits;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Fluent Wait.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class AbstractWait {

	protected static final Logger logger = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

	/** The Constant DEFAULT_SLEEP_INTERVAL. */
	protected static final long DEFAULT_SLEEP_INTERVAL = 1000;

	/** The Constant DEFAULT_TIMEOUT_INTERVAL. */
	protected static final long DEFAULT_TIMEOUT_INTERVAL = 10000;

	/** The sleep interval. */
	protected final Interval sleepInterval = new Interval(DEFAULT_SLEEP_INTERVAL);

	/** The timeout interval. */
	protected Interval timeoutInterval = new Interval(DEFAULT_TIMEOUT_INTERVAL);

	/**
	 * AbstractWait.
	 *
	 * @param useTimeout
	 *            as long.
	 */
	public AbstractWait(final long useTimeout) {
		interval(useTimeout);
	}

	/**
	 * AbstractWait.
	 *
	 * @param useInterval
	 *            as Interval.
	 */
	public AbstractWait(final Interval useInterval) {
		interval(useInterval);
	}

	/**
	 * interval.
	 *
	 * @return timeoutInterval as Interval object.
	 */
	public final AbstractWait interval() {
		timeoutInterval = new Interval(DEFAULT_TIMEOUT_INTERVAL);
		return this;
	}

	/**
	 * interval.
	 *
	 * @param useTimeout
	 *            as long.
	 * @return this timeoutInterval as Interval object.
	 */
	public final AbstractWait interval(final long useTimeout) {
		timeoutInterval = new Interval(useTimeout);
		return this;
	}

	/**
	 * interval.
	 *
	 * @param useInterval
	 *            as Interval.
	 * @return this timeoutInterval as Interval object.
	 */
	public final AbstractWait interval(final Interval useInterval) {
		timeoutInterval = useInterval;
		return this;
	}

	/**
	 * condition.
	 *
	 * @return this MUST be returned.
	 */
	public abstract boolean condition();

	/**
	 * condition.
	 *
	 * @param testCondition
	 *            the test condition
	 * @return this MUST be returned.
	 */
	// abstract public boolean condition(ICondition exitCondition);

	/**
	 * wait until the test condition is true or timeout.
	 *
	 * @param testCondition
	 *            as ICondition generalisation.
	 */
	// @Override
	protected final void untilTrue(final ICondition testCondition) {
		{
			final long timeout = System.currentTimeMillis() + timeoutInterval.asMilliSeconds();
			while (testCondition.isFalse()) {
				try {
					if (System.currentTimeMillis() < timeout) {
						Thread.sleep(sleepInterval.asLong());
					} else {
						return;
					}
				} catch (final Throwable exception) {
					System.err.print(exception.getLocalizedMessage());
				}
			}
		}
	}

	/**
	 * wait until the test condition is false or timeout.
	 *
	 * @param testCondition
	 *            the test condition
	 */
	// @Override
	protected final void untilFalse(final ICondition testCondition) {
		{
			final long timeout = System.currentTimeMillis() + timeoutInterval.asMilliSeconds();
			while (testCondition.isTrue()) {
				try {
					if (System.currentTimeMillis() < timeout) {
						Thread.sleep(sleepInterval.asLong());
					} else {
						return;
					}
				} catch (final Throwable exception) {
					System.err.print(exception.getLocalizedMessage());
				}
			}
		}
	}

	/**
	 * wait while the test condition is true or timeout.
	 *
	 * @param testCondition
	 *            the test condition
	 */
	// @Override
	protected final void whileTrue(final ICondition testCondition) {
		{
			final long timeout = System.currentTimeMillis() + timeoutInterval.asMilliSeconds();
			while (testCondition.isTrue()) {
				try {
					if (System.currentTimeMillis() < timeout) {
						Thread.sleep(sleepInterval.asLong());
					} else {
						return;
					}
				} catch (final Throwable exception) {
					System.err.print(exception.getLocalizedMessage());
				}
			}
		}
	}

	/**
	 * wait while the test condition is false or timeout.
	 *
	 * @param testCondition
	 *            the test condition
	 */
	// @Override
	protected final void whileFalse(final ICondition testCondition) {
		{
			final long timeout = System.currentTimeMillis() + timeoutInterval.asMilliSeconds();
			while (testCondition.isFalse()) {
				try {
					if (System.currentTimeMillis() < timeout) {
						Thread.sleep(sleepInterval.asLong());
					} else {
						return;
					}
				} catch (final Throwable exception) {
					System.err.print(exception.getLocalizedMessage());
				}
			}
		}
	}

	/**
	 * timeout.
	 */
	public final void timeout() {
		final long timeout = System.currentTimeMillis() + timeoutInterval.asMilliSeconds();
		while (condition()) {
			try {
				if (System.currentTimeMillis() < timeout) {
					Thread.sleep(sleepInterval.asLong());
				} else {
					return;
				}
			} catch (final Throwable exception) {
				System.err.print(exception.getLocalizedMessage());
			}
		}
	}
}
