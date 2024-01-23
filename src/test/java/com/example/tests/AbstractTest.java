package com.example.tests;

import com.example.listener.TestListener;
import com.example.util.Config;
import com.example.util.Constants;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Listeners({TestListener.class})
public class AbstractTest {
    private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);

    protected WebDriver driver;

    @BeforeSuite
    public void setupConfig() {
        Config.initialize();
    }

    @BeforeTest
    public void setup(ITestContext context) throws MalformedURLException {
        driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
        context.setAttribute(Constants.DRIVER, this.driver);
    }

    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities = new ChromeOptions();
        switch (Config.get(Constants.BROWSER)) {
            case Constants.CHROME -> capabilities = new ChromeOptions();
            case Constants.FIREFOX -> capabilities = new FirefoxOptions();
        }
        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hubHost = Config.get(Constants.GRID_HUB_HOST);
        String url = String.format(urlFormat, hubHost);
        log.info("grid url: {}", url);
        return new RemoteWebDriver(new URL(url), capabilities);
    }

    private WebDriver getLocalDriver() {
        return new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }

    @AfterMethod
    public void sleep() {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
    }
}
