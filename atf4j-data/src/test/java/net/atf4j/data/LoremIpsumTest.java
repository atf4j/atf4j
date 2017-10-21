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

package net.atf4j.data;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import net.atf4j.core.TestResultsReporting;

/**
 * A Unit test class for LoremIpsum objects.
 */
public final class LoremIpsumTest extends TestResultsReporting {

    /**
     * Unit Test for LoremIpsum text.
     */
    @Test
    public void testLoremIpsum() {
        final String text = LoremIpsum.text();
        assertNotNull("unexpected null", text);
        this.log.info("LoremIpsum.text() = {}", LoremIpsum.text());

        this.log.info("LoremIpsum.word() = {}", LoremIpsum.word());
        this.log.info("LoremIpsum.words(1) = {}", LoremIpsum.words(1));
        this.log.info("LoremIpsum.words(14) = {}", LoremIpsum.words(4));
        this.log.info("LoremIpsum.words(10) = {}", LoremIpsum.words(10));

        this.log.info("LoremIpsum.sentence() = {}", LoremIpsum.sentence());
        this.log.info("LoremIpsum.sentence(1) = {}", LoremIpsum.sentences(1));
        this.log.info("LoremIpsum.sentence(6) = {}", LoremIpsum.sentences(6));

        this.log.info("LoremIpsum.paragraph() = {} ", LoremIpsum.paragraph());
        this.log.info("LoremIpsum.paragraphs(1) = {} ", LoremIpsum.paragraphs(1));
        this.log.info("LoremIpsum.paragraphs(4) = {} ", LoremIpsum.paragraphs(4));
    }

}
