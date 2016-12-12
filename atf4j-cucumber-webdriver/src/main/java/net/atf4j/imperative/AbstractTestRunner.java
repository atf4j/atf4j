package net.atf4j.imperative;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import net.atf4j.core.LoggedTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        snippets = SnippetType.CAMELCASE,
        features = "classpath:features",
        tags = { "~@Ignore" })
public class AbstractTestRunner extends LoggedTest {

    @Before
    public void before() {
        log.info("before");
    }

    @After
    public void after() {
        log.info("after");
    }
}
