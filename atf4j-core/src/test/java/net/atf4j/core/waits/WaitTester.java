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

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * TestWait.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
@Ignore
public class WaitTester extends AbstractWait {

    /** The Constant ACTUAL_TIMEOUT_INTERVAL. */
    private static final long ACTUAL_TIMEOUT_INTERVAL = 1000L;

    /** The Constant DELTA. */
    private static final long DELTA = 1000L;

    /** The test condition. */
    private final boolean testCondition = true;

    /**
     * WaitTester constructor.
     */
    public WaitTester() {
        super(ACTUAL_TIMEOUT_INTERVAL);
    }

    /**
     * WaitTester constructor.
     *
     * @param useTimeout
     *            as long for the interval.
     */
    protected WaitTester(final long useTimeout) {
        super(useTimeout);
    }

    /**
     * WaitTester constructor.
     *
     * @param useInterval
     *            for time out.
     */
    protected WaitTester(final Interval useInterval) {
        super(useInterval);
    }

    /**
     * newTestWait.
     *
     * @param useTimeout
     *            as long.
     * @return new TestWait INSTANCE.
     */
    private static WaitTester newTestWait(final long useTimeout) {
        final WaitTester instance = new WaitTester();
        instance.interval(useTimeout);
        return instance;
    }

    /**
     * newTestWait.
     *
     * @param useInterval
     *            as Interval object.
     * @return new TestWait INSTANCE.
     */
    private static WaitTester newTestWait(final Interval useInterval) {
        final WaitTester instance = new WaitTester();
        instance.interval(useInterval);
        return instance;
    }

    /**
     * AbstractCondition.
     *
     * @return true, if successful
     * @see AbstractWait#condition()
     */
    @Override
    public boolean condition() {
        return this.testCondition;
    }

    /**
     * Test Case - exit conditions with Zero AbstractWait, - wait while true
     * with false condition = zero wait: whileTrue( false ) - wait while false
     * with true condition = zero wait: whileFalse( true ) - wait until true
     * with true condition = zero wait: untilTrue( true ) - wait until false
     * with false condition = zero wait: untilFalse( false ).
     */
    @Test()
    public void testZeroWait() {
        long start = System.currentTimeMillis();
        newTestWait(ACTUAL_TIMEOUT_INTERVAL).whileTrue(new FalseTestCondition());
        this.log.info("Zero AbstractWait Test 1 Ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to zero.");
        Assert.assertEquals(start, System.currentTimeMillis(), DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inMilliSeconds(1000L)).whileFalse(new TrueTestCondition());
        this.log.info("Zero AbstractWait Test 2 Ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to zero.");
        Assert.assertEquals(start, System.currentTimeMillis(), DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inSeconds(10)).untilTrue(new TrueTestCondition());
        this.log.info("Zero AbstractWait Test 3 Ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to zero.");
        Assert.assertEquals(start, System.currentTimeMillis(), DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inSeconds(10)).untilFalse(new FalseTestCondition());
        this.log.info("Zero AbstractWait Test 4 Ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to zero.");
        Assert.assertEquals(start, System.currentTimeMillis(), DELTA);
    }

    /**
     * Test Case - exit conditions with Full AbstractWait - wait while true with
     * true condition = full wait & time out : whileTrue( true ) - wait while
     * false with false condition = full wait & time out : whileFalse( false ) -
     * wait until true with false condition = full wait & time out : untilTrue(
     * false ) - wait until false with true condition = full wait & time out :
     * untilFalse( true ).
     */
    @Test()
    public void testFullWait() {
        long start = System.currentTimeMillis();
        newTestWait(1000l).whileTrue(new TrueTestCondition());
        this.log.info("Full AbstractWait Test 1 Ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to 1s.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inMilliSeconds(1000l)).whileFalse(new FalseTestCondition());
        this.log.info("Full AbstractWait Test 2 ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to 1s.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inSeconds(10)).untilTrue(new FalseTestCondition());
        this.log.info("Full AbstractWait Test 3 ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to 10s.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 10, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inSeconds(10)).untilFalse(new TrueTestCondition());
        this.log.info("Full AbstractWait Test 4 ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to 10s.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 10, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inMinutes(1)).untilTrue(new FalseTestCondition());
        this.log.info("Full AbstractWait Test 5 ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to 1m.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 60, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        newTestWait(Interval.inMinutes(1)).untilFalse(new TrueTestCondition());
        this.log.info("Full AbstractWait Test 6 ended after :" + (System.currentTimeMillis() - start)
                + "ms. expect close to 1m.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 60, System.currentTimeMillis() - start, DELTA);

        // newTestWait( Interval.inHours(1) ).untilTrue(new
        // FalseTestCondition());
        // log.info("Full AbstractWait Test 3 ended after :"+
        // (System.currentTimeMillis() - start)+"ms. expect close to 1h.");
        // Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL*60*60,
        // System.currentTimeMillis()-start, DELTA);

        // newTestWait( Interval.inHours(1) ).untilFalse(new
        // TrueTestCondition());
        // log.info("Full AbstractWait Test 4 ended after :"+
        // (System.currentTimeMillis() - start)+"ms. expect close to 1h.");
        // Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL*60*60,
        // System.currentTimeMillis()-start, DELTA);
    }

    /**
     * testInitialisingConstructors.
     */
    @Test()
    public void testInitialisingConstructors() {
        long start = System.currentTimeMillis();
        final WaitTester testWait1a = new WaitTester();
        testWait1a.timeout();
        this.log.info("Test1a ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 1 second.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        final WaitTester testWait1b = new WaitTester(4000L);
        testWait1b.timeout();
        this.log.info("Test1b ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 4 seconds.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 4, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        final WaitTester testWait1c = new WaitTester(Interval.inMilliSeconds(4000));
        testWait1c.timeout();
        this.log.info("Test1c ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 4 seconds.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 4, System.currentTimeMillis() - start, DELTA);
    }

    /**
     * testFactories.
     */
    @Test()
    public void testFactories() {
        long start = System.currentTimeMillis();
        final WaitTester testWait2a = WaitTester.newTestWait(ACTUAL_TIMEOUT_INTERVAL);
        testWait2a.timeout();
        this.log.info("Test2a ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 1 second.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        final WaitTester testWait2b = WaitTester.newTestWait(4000L);
        testWait2b.timeout();
        this.log.info("Test2b ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 4 seconds.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 4, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        final WaitTester testWait2c = WaitTester.newTestWait(Interval.inMilliSeconds(4000));
        testWait2c.timeout();
        this.log.info("Test2c ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 4 seconds.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 4, System.currentTimeMillis() - start, DELTA);
    }

    /**
     * test interval settings.
     */
    @Test()
    public void testIntervalSetting() {
        long start = System.currentTimeMillis();
        final WaitTester testWait3a = new WaitTester();
        testWait3a.interval().timeout();
        this.log.info("Test3a ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to "
                + DEFAULT_TIMEOUT_INTERVAL);
        Assert.assertEquals(DEFAULT_TIMEOUT_INTERVAL, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        final WaitTester testWait3b = new WaitTester(1000L);
        testWait3b.interval(4000).timeout();
        this.log.info("Test3b ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 4 seconds.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 4, System.currentTimeMillis() - start, DELTA);

        start = System.currentTimeMillis();
        final WaitTester testWait3c = new WaitTester(Interval.inMilliSeconds(1000));
        testWait3c.interval(Interval.inMilliSeconds(4000)).timeout();
        this.log.info("Test3c ended after :" + (System.currentTimeMillis() - start) + "ms. expect close to 4 seconds.");
        Assert.assertEquals(ACTUAL_TIMEOUT_INTERVAL * 4, System.currentTimeMillis() - start, DELTA);
    }

    public void testFluentWait() {
        // new FluentWait(new Interval(1)).until(new TestCondition(true));
    }

    @Test
    public void test(final String[] args) {
        try {
            long start = System.currentTimeMillis();
            new AbstractWait(new Interval(10000)) {
                @Override
                public boolean condition() {
                    return true;
                }
            }.timeout();
            this.log.info("AbstractWait ended " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            new AbstractWait(10000L) {
                @Override
                public boolean condition() {
                    return false;
                }
            }.timeout();
            this.log.info("AbstractWait ended " + (System.currentTimeMillis() - start));

            start = System.currentTimeMillis();
            newTestWait(Interval.inMilliSeconds(1000L)).timeout();
            this.log.info(" AbstractWait Test 1 Ended after :" + (System.currentTimeMillis() - start)
                    + "ms. expect close to 1s");
            org.junit.Assume.assumeTrue(System.currentTimeMillis() - (start + 1000L) < DELTA);

            start = System.currentTimeMillis();
            newTestWait(Interval.inMilliSeconds(1000L)).timeout();
            this.log.info(" AbstractWait Test 2 Ended after :" + (System.currentTimeMillis() - start)
                    + "ms. expect close to 1s.");
            org.junit.Assume.assumeTrue(System.currentTimeMillis() - (start + 1000L) < DELTA);

            start = System.currentTimeMillis();
            newTestWait(Interval.inSeconds(10)).timeout();
            this.log.info(" AbstractWait Test 3 Ended after :" + (System.currentTimeMillis() - start)
                    + "ms. expect close to 10s.");
            org.junit.Assume.assumeTrue(System.currentTimeMillis() - (start + 10000L) < DELTA);

            start = System.currentTimeMillis();
            newTestWait(Interval.inSeconds(10)).timeout();
            this.log.info(" AbstractWait Test 4 Ended after :" + (System.currentTimeMillis() - start)
                    + "ms. expect close to 10s.");
            org.junit.Assume.assumeTrue(System.currentTimeMillis() - (start + 10000L) < DELTA);
            this.log.info(" AbstractWait Tests completed.");
        } catch (final Exception exception) {
            this.log.error(exception.toString());
        }
    }
}
