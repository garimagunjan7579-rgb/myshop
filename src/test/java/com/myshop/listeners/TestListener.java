package com.myshop.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.lang.reflect.Method;

import com.aventstack.extentreports.ExtentTest;
import com.myshop.testcase.BaseTest;

import com.myshop.utilities.ReportLogger;
import com.myshop.utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ReportLogger.setExtent(com.myshop.utilities.ExtentReportsManager.getExtentReports());
    }

    @Override
    public void onTestStart(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName();

        ExtentTest test = ReportLogger.getExtent().createTest(className + " : " + methodName);
        test.assignCategory(className); // optional, filter by class in report
        ReportLogger.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportLogger.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ReportLogger.getTest();

        // Log the failure reason
        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            test.fail("❌ Test Failed: " + throwable.getMessage());
        } else {
            test.fail("❌ Test Failed (no exception message)");
        }

        // Capture screenshot
        BaseTest base = (BaseTest) result.getInstance();
        ScreenshotUtil ssUtil = new ScreenshotUtil(base.getDriver(), test);
        String screenshotPath = ssUtil.capture(result.getName());

        // Attach the screenshot to Extent Report
        try {
            test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
        } catch (Exception e) {
            test.warning("⚠️ Could not attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportLogger.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        ReportLogger.getExtent().flush();
    }
}