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
 * along with atf4j.  If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.core.model;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayDeque;
import java.util.Collection;

import net.atf4j.core.Atf4jException;
import net.atf4j.core.TestResultsReporting;
import net.atf4j.core.TestResult;

/**
 * Abstract Test Base Class.
 */
public abstract class AbstractTestBase extends TestResultsReporting {

    protected TestIdentifier uniqueIdentifier;
    protected TestContext testContext;
    protected TestResult testResult;
    protected TestReport testReport;

    private String tester; // Actor
    private String name; // short name of test
    private String taxonomy; // taxonomy of test
    private String description; // full description of test
    private String timestamp; // ISO date.
    private Collection<Condition> preConditions;
    private Collection<Condition> postConditions;

    /**
     * Instantiates a new test base.
     */
    public AbstractTestBase() {
        super();
        this.testResult = TestResult.initialise();
        this.uniqueIdentifier = new TestIdentifier();
    }

    /**
     * Instantiates a new test base.
     *
     * @param name the name
     */
    public AbstractTestBase(final String name) {
        super();
        this.name = name;
        this.testResult = TestResult.initialise();
        this.uniqueIdentifier = new TestIdentifier();
    }

    /**
     * Instantiates a new test base.
     *
     * @param testContext the test context
     */
    public AbstractTestBase(final TestContext testContext) {
        super();
        this.testContext = testContext;
    }

    /**
     * Register logging.
     *
     * @param logging the logging
     * @return the test base
     * @throws Atf4jException the atf4j exception
     */
    public AbstractTestBase registerLogging(final TestReport logging) throws Atf4jException {
        setLogging(logging);
        return this;
    }

    /**
     * Execute.
     *
     * @param context the context
     * @return the test result
     * @throws Atf4jException the atf4j exception
     */
    public AbstractTestBase execute(final TestContext context) throws Atf4jException {
        throw new Atf4jException("execute Must be overridden.");
    }

    /**
     * Adds the pre condition.
     *
     * @param newPreCondition as Condition
     * @return success as boolean.
     * @see java.util.Collection#add(java.lang.Object)
     */
    public AbstractTestBase addPreCondition(final Condition newPreCondition) {
        if (this.preConditions == null) {
            this.preConditions = new ArrayDeque<Condition>();
        }
        assumeTrue(this.preConditions.add(newPreCondition));
        return this;
    }

    /**
     * Assumed pre conditions.
     *
     * @return the abstract test base
     */
    public AbstractTestBase assumedPreConditions() {
        if (this.preConditions == null) {
            return this;
        } else {
            for (final Condition condition : this.postConditions) {
                assumeTrue(condition.isTrue());
            }
        }
        return this;
    }

    /**
     * Adds the post condition.
     *
     * @param newPostCondition as Condition.
     * @return success as boolean.
     * @see java.util.Collection#add(java.lang.Object)
     */
    public AbstractTestBase addPostCondition(final Condition newPostCondition) {
        if (this.postConditions == null) {
            this.postConditions = new ArrayDeque<Condition>();
        }
        assumeTrue(this.postConditions.add(newPostCondition));
        return this;
    }

    /**
     * Assert post conditions.
     *
     * @return the abstract test base
     */
    public AbstractTestBase assertPostConditions() {
        if (this.postConditions == null) {
            return this;
        } else {
            for (final Condition condition : this.postConditions) {
                assertTrue(condition.isTrue());
            }
        }
        return this;
    }

    /**
     * Gets the test status.
     *
     * @return the testStatus
     */
    protected TestResult getTestStatus() {
        return this.testResult;
    }

    /**
     * Sets the test status.
     *
     * @param testStatus the testStatus to set
     * @return the test base
     */
    protected AbstractTestBase setTestStatus(final TestResult testStatus) {
        this.testResult = testStatus;
        return this;
    }

    /**
     * Gets the unique identifier.
     *
     * @return the uniqueIdentifier
     */
    protected TestIdentifier getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }

    /**
     * Sets the unique identifier.
     *
     * @param uniqueIdentifier the uniqueIdentifier to set
     * @return the test base
     */
    protected AbstractTestBase setUniqueIdentifier(final TestIdentifier uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
        return this;
    }

    /**
     * Gets the test context.
     *
     * @return the testContext
     */
    protected TestContext getTestContext() {
        return this.testContext;
    }

    /**
     * Sets the test context.
     *
     * @param testContext the testContext to set
     * @return the test base
     */
    protected AbstractTestBase setTestContext(final TestContext testContext) {
        this.testContext = testContext;
        return this;
    }

    /**
     * Gets the tester.
     *
     * @return the tester
     */
    protected String getTester() {
        return this.tester;
    }

    /**
     * Sets the tester.
     *
     * @param tester the tester to set
     * @return the test base
     */
    protected AbstractTestBase setTester(final String tester) {
        this.tester = tester;
        return this;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    protected String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     *
     * @param name the name to set
     * @return the test base
     */
    protected AbstractTestBase setName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * Gets the taxonomy.
     *
     * @return the taxonomy
     */
    protected String getTaxonomy() {
        return this.taxonomy;
    }

    /**
     * Sets the taxonomy.
     *
     * @param taxonomy the taxonomy to set
     * @return the test base
     */
    protected AbstractTestBase setTaxonomy(final String taxonomy) {
        this.taxonomy = taxonomy;
        return this;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    protected String getDescription() {
        return this.description;
    }

    /**
     * Sets the description.
     *
     * @param description the description to set
     * @return the test base
     */
    protected AbstractTestBase setDescription(final String description) {
        this.description = description;
        return this;
    }

    /**
     * Gets the timestamp.
     *
     * @return the timestamp
     */
    protected String getTimestamp() {
        return this.timestamp;
    }

    /**
     * Sets the timestamp.
     *
     * @param timestamp the timestamp to set
     * @return the test base
     */
    protected AbstractTestBase setTimestamp(final String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Gets the pre conditions.
     *
     * @return the preConditions
     */
    protected Collection<Condition> getPreConditions() {
        return this.preConditions;
    }

    /**
     * Gets the post conditions.
     *
     * @return the postConditions
     */
    protected Collection<Condition> getPostConditions() {
        return this.postConditions;
    }

    /**
     * Gets the logging.
     *
     * @return the logging
     */
    public TestReport getLogging() {
        return this.testReport;
    }

    /**
     * Sets the logging.
     *
     * @param logging the new logging
     * @return the test base
     */
    public AbstractTestBase setLogging(final TestReport logging) {
        this.testReport = logging;
        return this;
    }

    /**
     * Result.
     *
     * @return the test result
     */
    public TestResult result() {
        return this.testResult;
    }

    /**
     * Debug string.
     *
     * @return the string
     */
    public String debugString() {
        return String.format(
                "%s [testStatus=%s, uniqueIdentifier=%s, testContext=%s, tester=%s, name=%s, taxonomy=%s, description=%s, timestamp=%s, preConditions=%s, postConditions=%s]",
                this.getClass().getSimpleName(),
                this.testResult,
                this.uniqueIdentifier,
                this.testContext,
                this.tester,
                this.name,
                this.taxonomy,
                this.description,
                this.timestamp,
                this.preConditions,
                this.postConditions);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return debugString();
    }

}
