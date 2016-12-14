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
package net.atf4j.core.webdriver.example.backoffice;
import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.xml.XmlPage;

import net.atf4j.core.annotations.TestName;

/**
 * XmlDriverTest.
 *
 */
public class XmlDriverTest {
	/** URL to a long life XML file */
	private static final String URL_TO_XML_FILE = "http://dublincore.org/schemas/xmls/simpledc20021212.xsd";

	/**
	 * XmlTest 1
	 */
	@Test
	@TestName("htmlunit - Load XML Test Page.")
	public final void XmlTest1() {
		try {
			Atf4j.startStep("XmlTest1");
			final WebClient webClient = new WebClient();
			Atf4j.assertThat("webClient is instantiated", webClient != null);
			final XmlPage xmlPage = webClient.getPage(XmlDriverTest.URL_TO_XML_FILE);
			Atf4j.assertThat("xmlPage is instantiated", xmlPage != null);
			final String pageAsXml = xmlPage.asXml();
			Atf4j.assertThat("pageAsXml is instantiated", pageAsXml != null);
			// log.info(pageAsXml);
			// System.out.flush();
			// webClient.closeAllWindows();
			// Atf4j.endStep();
		} catch (final FailingHttpStatusCodeException e) {
			Atf4j.info(e.getLocalizedMessage());
		} catch (final MalformedURLException e) {
			Atf4j.info(e.getLocalizedMessage());
		} catch (final IOException e) {
			Atf4j.info(e.getLocalizedMessage());
		} finally {
			Atf4j.endStep();
		}
	}

	/**
	 * XmlTest 2
	 */
	@Test()
	@TestName("htmlunit - Load XML Test Page.")
	public final void XmlTest2() {
		try {
			Atf4j.startStep("XmlTest2");
			final WebClient webClient = new WebClient();
			Atf4j.assertThat("webClient is instantiated", webClient != null);
			final XmlPage xmlPage = webClient.getPage(XmlDriverTest.URL_TO_XML_FILE);
			Atf4j.assertThat("xmlPage is instantiated", xmlPage != null);
			final String pageAsText = xmlPage.asText();
			Atf4j.assertThat("pageAsText is instantiated", pageAsText != null);
			// log.info(pageAsText);
			// System.out.flush();
			// webClient.closeAllWindows();
			// Atf4j.endStep();
		} catch (final FailingHttpStatusCodeException e) {
			e.printStackTrace(System.err);
		} catch (final MalformedURLException e) {
			e.printStackTrace(System.err);
		} catch (final IOException e) {
			e.printStackTrace(System.err);
		} finally {
			Atf4j.endStep();
		}
	}

}
