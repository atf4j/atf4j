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

package net.atf4j.bdd;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for a Hoare step. c.f. Hoare Logic
 */
public abstract class AbstractHoareStep implements HoareStepInterface {

    protected final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    protected String string;
    protected Properties properties;

    /**
     * Instantiates a new Hoare step.
     *
     * @param string the string
     */
    public AbstractHoareStep(final String string) {
        this.log.info("AbstractHoareStep({}", string);
        this.string = string;
    }

    /**
     * Execute.
     *
     * @return the properties
     */
    public Properties execute() {
        this.log.info("AbstractHoareStep({}", this.string);
        return this.properties;
    }

    /*
     * (non-Javadoc)
     *
     * @see net.atf4j.bdd.HoareStepInterface#execute(java.util.Properties)
     */
    @Override
    public Properties execute(final Properties properties) {
        this.log.info("AbstractHoareStep({}", this.string);
        this.properties = properties;
        return properties;
    }

}
