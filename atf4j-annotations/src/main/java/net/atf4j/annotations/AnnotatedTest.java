/**
 * This file is part of Automated Testing Framework for Java (atf4j).
 * Atf4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Atf4j is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with atf4j. If not, see http://www.gnu.org/licenses/.
 */

package net.atf4j.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Annotated Test class.
 */
@Atf4j.TestScript
public abstract class AnnotatedTest {
    protected static final Logger log = LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);

    /**
     * Test tag.
     *
     * @return the string
     * @throws Exception
     *             the exception
     */
    public String testTag() throws Exception {
        return AnnotationHelper.getTestTag();
    }

    /**
     * Retrieve the Test Id from the annotation.
     *
     * @return the test id as a String.
     * @throws Exception
     *             the exception
     */
    public String testId() throws Exception {
        return AnnotationHelper.getTestId();
    }

    /**
     * Retrieve the Test name from the annotation.
     *
     * @return the test name as a String.
     */
    public String testName() {
        return AnnotationHelper.getTestName();
    }

    /**
     * Retrieve the Test description from the annotation.
     *
     * @return the test description as a String.
     */
    public String testDescription() {
        return AnnotationHelper.getTestDescription();
    }

}
