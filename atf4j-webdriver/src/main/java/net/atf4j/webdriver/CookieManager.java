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
package net.atf4j.webdriver;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * CookieManager.
 *
 * @author Martin Spamer Martin.Spamer@atf4j.net
 * @version $Revision: 1.0 $
 */
public class CookieManager {

    /** The web driver. */
    private WebDriver webDriver = null;
	
	/** The cookies. */
	private Set<Cookie> cookies = null;

	/**
	 * CookieManager.
	 *
	 * @param webDriver
	 *            the web driver
	 */
	public CookieManager(final WebDriver webDriver) {
		this.webDriver = webDriver;
	}

    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return cookies.isEmpty();
    }

    /**
     * Contains.
     *
     * @param o the o
     * @return true, if successful
     */
    public boolean contains(Cookie o) {
        return cookies.contains(o);
    }

    /**
     * Adds the.
     *
     * @param e the e
     * @return true, if successful
     */
    public boolean add(Cookie e) {
        return cookies.add(e);
    }

    /**
     * Removes the.
     *
     * @param o the o
     * @return true, if successful
     */
    public boolean remove(Cookie o) {
        return cookies.remove(o);
    }
	
	/**
	 * Save.
	 */
	public void save() {
		this.cookies = this.webDriver.manage().getCookies();
	}

	/**
	 * Clear.
	 */
	public void clear() {
		this.webDriver.manage().deleteAllCookies();
	}

	/**
	 * Restore.
	 */
	public void restore() {
		if (this.cookies != null) {
			this.cookies = this.webDriver.manage().getCookies();
			for (final Cookie cookie : this.cookies) {
				this.webDriver.manage().addCookie(cookie);
			}
		}
	}
}
