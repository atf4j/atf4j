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
package net.atf4j.core.model;

import java.util.Collection;

import net.atf4j.core.Atf4jException;

/**
 * TestBase.
 */
public abstract class TestBase implements TestCommand {

    /** The logging. */
    protected TestResultLoggingInterface log;

    /** The test status. */
    private TestStatus testStatus = TestStatus.NOT_RUN;

    /** The unique identifier. */
    private TestIdentifier uniqueIdentifier;

    /** The test context. */
    private TestContext testContext;

    /** The tester. */
    private String tester; // Actor

    /** The name. */
    private String name;

    /** The taxonomy. */
    private String taxonomy;

    /** The description. */
    private String description;

    /** The timestamp. */
    private String timestamp; // ISO date.

    /** The pre-conditions. */
    private Collection<Condition> preConditions;

    /** The post-conditions. */
    private Collection<Condition> postConditions;

    /**
     * Register logging.
     *
     * @param logging
     *            the logging
     * @throws Atf4jException
     *             the atf4j exception
     */
    public void registerLogging(final TestResultLoggingInterface logging) throws Atf4jException {
        setLogging(logging);
    }

    /**
     * Execute.
     *
     * @param context
     *            the context
     * @return the test result
     * @throws Atf4jException
     *             the atf4j exception
     */
    @Override
    public AbstractTestResult execute(final TestContext context) throws Atf4jException {
        throw new Atf4jException("not yet implemented");
    }

    /**
     * Adds the pre condition.
     *
     * @param newPreCondition
     *            as Condition
     * @return success as boolean.
     * @see java.util.Collection#add(java.lang.Object)
     */
    public TestBase addPreCondition(final Condition newPreCondition) {
        this.preConditions.add(newPreCondition);
        return this;
    }

    /**
     * Adds the pre conditions.
     *
     * @param newPreConditions
     *            the new pre conditions
     * @return the test base
     */
    public TestBase addPreConditions(final Collection<? extends Condition> newPreConditions) {
        this.postConditions.addAll(newPreConditions);
        return this;
    }

    /**
     * Adds the post condition.
     *
     * @param newPostCondition
     *            as Condition.
     * @return success as boolean.
     * @see java.util.Collection#add(java.lang.Object)
     */
    public TestBase addPostCondition(final Condition newPostCondition) {
        this.postConditions.add(newPostCondition);
        return this;
    }

    /**
     * Adds the post conditions.
     *
     * @param newPostConditions
     *            the new post conditions
     * @return the test base
     */
    public TestBase addPostConditions(final Collection<? extends Condition> newPostConditions) {
        this.postConditions.addAll(newPostConditions);
        return this;
    }

    /**
     * Gets the test status.
     *
     * @return the testStatus
     */
    protected TestStatus getTestStatus() {
        return this.testStatus;
    }

    /**
     * Sets the test status.
     *
     * @param testStatus
     *            the testStatus to set
     * @return the test base
     */
    protected TestBase setTestStatus(final TestStatus testStatus) {
        this.testStatus = testStatus;
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
     * @param uniqueIdentifier
     *            the uniqueIdentifier to set
     * @return the test base
     */
    protected TestBase setUniqueIdentifier(final TestIdentifier uniqueIdentifier) {
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
     * @param testContext
     *            the testContext to set
     * @return the test base
     */
    protected TestBase setTestContext(final TestContext testContext) {
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
     * @param tester
     *            the tester to set
     * @return the test base
     */
    protected TestBase setTester(final String tester) {
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
     * @param name
     *            the name to set
     * @return the test base
     */
    protected TestBase setName(final String name) {
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
     * @param taxonomy
     *            the taxonomy to set
     * @return the test base
     */
    protected TestBase setTaxonomy(final String taxonomy) {
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
     * @param description
     *            the description to set
     * @return the test base
     */
    protected TestBase setDescription(final String description) {
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
     * @param timestamp
     *            the timestamp to set
     * @return the test base
     */
    protected TestBase setTimestamp(final String timestamp) {
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
     * Sets the pre conditions.
     *
     * @param preConditions
     *            the preConditions to set
     * @return the test base
     */
    protected TestBase setPreConditions(final Collection<Condition> preConditions) {
        this.preConditions = preConditions;
        return this;
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
     * Sets the post conditions.
     *
     * @param postConditions
     *            the postConditions to set
     * @return the test base
     */
    protected TestBase setPostConditions(final Collection<Condition> postConditions) {
        this.postConditions = postConditions;
        return this;
    }

    /**
     * Gets the logging.
     *
     * @return the logging
     */
    public TestResultLoggingInterface getLogging() {
        return this.log;
    }

    /**
     * Sets the logging.
     *
     * @param logging
     *            the new logging
     * @return the test base
     */
    public TestBase setLogging(final TestResultLoggingInterface logging) {
        this.log = logging;
        return this;
    }

}
