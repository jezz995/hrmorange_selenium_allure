package com.example.java.base;

import com.example.java.utilities.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private final Screenshot screenshot = new Screenshot();

    private boolean isDriverAvailable(WebDriver driver) {
        try {
            return driver != null && !driver.getWindowHandles().isEmpty();
        } catch (Exception e) {
            System.out.println("Driver not available or window already closed: " + e.getMessage());
            return false;
        }
    }

    private void captureScreenshot(ITestResult result, String status) {
        try {
            Object testInstance = result.getInstance();
            if (!(testInstance instanceof BaseTest))
                return;

            WebDriver driver = ((BaseTest) testInstance).getDriver();
            String ssName = result.getMethod().getMethodName() + (status.equals("failure") ? "_failure" : "");

            if (isDriverAvailable(driver)) {
                screenshot.takeScreenshot(driver, ssName);
                screenshot.attachScreenshotPNG(ssName);
            } else {
                System.out.println("Skipping screenshot: driver is unavailable or closed.");
            }

        } catch (Exception e) {
            System.err.println("Error capturing screenshot on test " + status + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("🟢 Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ Test passed: " + result.getName());
        captureScreenshot(result, "success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ Test failed: " + result.getName());
        captureScreenshot(result, "failure");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("⚠️ Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("☑️ Test failed but within success percentage: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("📘 Starting test suite: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("📕 Finishing test suite: " + context.getName());
    }
}
