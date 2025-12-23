package com.myshop.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ScreenshotUtil {

    private WebDriver driver;
    private ExtentTest test;

    public ScreenshotUtil(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    public String capture(String screenshotName) {
        String screenshotPath = "";
        try {
            String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotDir = "reports/screenshots/";
            Files.createDirectories(new File(screenshotDir).toPath());

            screenshotPath = screenshotDir + screenshotName + "_" + date + ".png";
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(screenshot.toPath(), new File(screenshotPath).toPath());

            test.info("📸 Screenshot captured: " + screenshotName);
        } catch (IOException e) {
            test.warning("⚠️ Failed to capture screenshot: " + e.getMessage());
        }
        return screenshotPath;
    }
}
    
