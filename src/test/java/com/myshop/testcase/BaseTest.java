//Feature 1 branch code
package com.myshop.testcase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.myshop.utilities.PropertiesFileReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    protected WebDriver driver;
    PropertiesFileReader pf = new PropertiesFileReader();
    String url = pf.getValues("url");
    String browser = pf.getValues("browser");

    public static final Logger logger1 = LogManager.getLogger("myshop");

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void initializer() {
        logger1.info("Initializing WebDriver...");
        logger1.info("Selecting browser type");
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);
        logger1.info("URL Opened: " + url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger1.info("Browser closed");
        }
    }
}