package com.example.java.base;

import com.example.java.utilities.Screenshot;
import com.example.java.page.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchWindowException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.lang.reflect.Method;

import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    private void setDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    private WebDriver createDriver(String browser) {
        switch (browser) {
            case "firefox":
                return new FirefoxDriver(new FirefoxOptions().addArguments("--private"));
            case "edge":
                return new EdgeDriver(new EdgeOptions().addArguments("--inprivate"));
            case "chrome":
            default:
                return new ChromeDriver(new ChromeOptions().addArguments("--incognito"));
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(Method method) {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        System.out.println("Launching browser: " + browser);

        WebDriver driver = createDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ✅ Maximize safely
        try {
            if (!driver.getWindowHandles().isEmpty()) {
                driver.manage().window().maximize();
            }
        } catch (NoSuchWindowException e) {
            System.out.println("Window closed before maximize: " + e.getMessage());
        }

        setDriver(driver);

        // print debug info
        String className = method.getDeclaringClass().getSimpleName();
        String testName = method.getName();
        System.out.println(">>>Running test: " + className + "." + testName);

        // skip auto-login for LoginTest
        if (className.equals("LoginTest")) {
            System.out.println("Skipping auto-login for LoginTest");
        } else {
            System.out.println("Auto-login as admin for test: " + className + "." + testName);
            loginAsAdmin();
        }

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        WebDriver driver = getDriver();

        // Screenshot on failure
        if (driver != null && result.getStatus() == ITestResult.FAILURE) {
            try {
                new Screenshot().takeScreenshot(driver, result.getMethod().getMethodName() + "_failure");
            } catch (Exception e) {
                System.out.println("Failed to take screenshot: " + e.getMessage());
            }
        }

        // Quit and clean ThreadLocal
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                System.out.println("Error quitting driver: " + e.getMessage());
            } finally {
                driverThreadLocal.remove();
            }
        }

    }

    // Global login helper for admin
    // This can be used in test cases to log in as admin
    protected void loginAsAdmin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin();
        loginPage.loginAs("Admin", "admin123");

        // wait for dashboard to load
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(loginPage.getDashboardElement()));

        System.out.println("Logged in as Admin successfully.");
    }
}
