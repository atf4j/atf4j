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

/**
 * AbstractCondition used as a base for Fluent Waits.
 *
 * @author Martin Spamer <Martin.Spamer@atf4j.net>
 */
public abstract class AbstractCondition implements ICondition {
	/** The condition state. */
	private boolean conditionState = false;

	/**
	 * AbstractCondition.
	 *
	 * @param useValue
	 *            the use value
	 */
	public AbstractCondition(final boolean useValue) {
		this.conditionState = useValue;
	}

	/**
	 * setConditionState
	 *
	 * Note : Deliberately protected access.
	 *
	 * @param useConditionState
	 *            the new condition state
	 */
	protected final void setConditionState(final boolean useConditionState) {
		this.conditionState = useConditionState;
	}

	/**
	 * getConditionState
	 *
	 * Note : Deliberately protected access.
	 *
	 * @return the conditionState
	 */
	protected final boolean getConditionState() {
		return this.conditionState;
	}

	/**
	 * asBoolean.
	 *
	 * Note : Deliberate named; provided for BDD purposes.
	 *
	 * @return true, if successful
	 * @see ICondition#asBoolean()
	 */
	public final boolean asBoolean() {
		return this.conditionState;
	}

	/**
	 * Checks if condition is true. Note : Deliberate named; provided for BDD
	 * purposes.
	 *
	 * @return true, if this condition is true.
	 * @see ICondition#isTrue()
	 */
	public final boolean isTrue() {
		return (this.conditionState == true);
	}

	/**
	 * Checks if condition is false. Note : Deliberate named; provided for BDD
	 * purposes. Note : Deliberate default implementation but expected to be
	 * overridden.
	 *
	 * @return true, if this condition is false.
	 * @see ICondition#isFalse()
	 */
	public boolean isFalse() {
		return (this.conditionState == false);
	}

	/**
	 * toString.
	 *
	 * @return condition as meaningful String.
	 */
	@Override
	public final String toString() {
		return this.getClass().getSimpleName() + "=" + this.conditionState;
	}

}
