package com.example.java.page;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private WebDriverWait wait;

    private static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

    // Locators
    private By dashboardButton = By.xpath("//a[normalize-space()='Dashboard']");
    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[normalize-space()='Logout']");
    private By adminButton = By.xpath("//a[normalize-space()='Admin']");
    private By pimButton = By.xpath("//span[normalize-space()='PIM']");
    private By leaveButton = By.xpath("//span[normalize-space()='Leave']");
    private By timeButton = By.xpath("//span[normalize-space()='Time']");
    private By recruitmentButton = By.xpath("//span[normalize-space()='Recruitment']");
    private By performanceButton = By.xpath("//span[normalize-space()='Performance']");
    private By myInfoButton = By.xpath("//span[normalize-space()='My Info']");
    private By directoryButton = By.xpath("//span[normalize-space()='Directory']");
    private By maintenanceButton = By.xpath("//span[normalize-space()='Maintenance']");

    private By dashBoardPageHeader = By.xpath("(//div[@class='oxd-topbar-header-title'])[1]");
    private By adminPageHeader = By.xpath("//h6[normalize-space()='Admin']");
    private By pimPageHeader = By.xpath("//h6[normalize-space()='PIM']");
    private By leavePageHeader = By.xpath("//h6[normalize-space()='Leave']");
    private By timePageHeader = By.xpath("//h6[normalize-space()='Time']");
    private By recruitmentPageHeader = By.xpath("(//div[@class='oxd-topbar-header-title'])[1]");
    private By performancePageHeader = By.xpath("(//div[@class='oxd-topbar-header-title'])[1]");
    private By myInfoPageHeader = By.xpath("(//div[@class='oxd-topbar-header-title'])[1]");
    private By directoryPageHeader = By.xpath("//h6[normalize-space()='Directory']");
    private By maintenancePageHeader = By.xpath("//h6[normalize-space()='Maintenance']");

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Navigate to the dashboard page
    public DashboardPage navigateToDashboard() {
        driver.get(DASHBOARD_URL);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(dashBoardPageHeader));
        return this;
    }

    public DashboardPage clickDashboardButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardButton)).click();
        return this;
    }

    public DashboardPage clickAdminButton() {
        wait.until(ExpectedConditions.elementToBeClickable(adminButton)).click();
        return this;
    }

    public DashboardPage clickPIMButton() {
        wait.until(ExpectedConditions.elementToBeClickable(pimButton)).click();
        return this;
    }

    public DashboardPage clickLeaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveButton)).click();
        return this;
    }

    public DashboardPage clickTimeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(timeButton)).click();
        return this;
    }

    public DashboardPage clickRecruitmentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentButton)).click();
        return this;
    }

    public DashboardPage clickPerformanceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(performanceButton)).click();
        return this;
    }

    public DashboardPage clickMyInfoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoButton)).click();
        return this;
    }

    public DashboardPage clickDirectoryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(directoryButton)).click();
        return this;
    }

    public DashboardPage clickMaintenanceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(maintenanceButton)).click();
        return this;
    }

    public WebElement getDashboardHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoardPageHeader));
    }

    // Validation
    public boolean isAdminPageVisible() {
        try {
            WebElement header = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(adminPageHeader));
            System.out.println("Admin page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Admin page not visible.");
            return false;
        }
    }

    public boolean isPIMPageVisible() {
        try {
            WebElement header = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(pimPageHeader));
            System.out.println("PIM page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("PIM page not visible.");
            return false;
        }
    }

    public boolean isLeavePageVisible() {
        try {
            WebElement header = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(leavePageHeader));
            System.out.println("Leave page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Leave page not visible.");
            return false;
        }
    }

    public boolean isTimePageVisible() {
        try {
            WebElement header = wait
                    .until(ExpectedConditions.visibilityOfElementLocated(timePageHeader));
            System.out.println("Time page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Time page not visible.");
            return false;
        }
    }

    public boolean isRecruitmentPageVisible() {
        try {
            WebElement header = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(recruitmentPageHeader));
            System.out.println("Recruitment page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Recruitment page not visible.");
            return false;
        }
    }

    public boolean isPerformancePageVisible() {
        try {
            WebElement header = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(performancePageHeader));
            System.out.println("Performance page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Performance page not visible.");
            return false;
        }
    }

    public boolean isMyInfoPageVisible() {
        try {
            WebElement header = wait
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(myInfoPageHeader));
            System.out.println("My Info page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("My Info page not visible.");
            return false;
        }
    }

    public boolean isDirectoryPageVisible() {
        try {
            WebElement header = wait
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(directoryPageHeader));
            System.out.println("Directory page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Directory page not visible.");
            return false;
        }
    }

    public boolean isMaintenancePageVisible() {
        try {
            WebElement header = wait
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(maintenancePageHeader));
            System.out.println("Maintenance page header found: " + header.getText());
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Maintenance page not visible.");
            return false;
        }
    }

    // Verify if the dashboard header is visible after login
    public boolean isDashboardHeaderVisible() {
        try {
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(dashBoardPageHeader));
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Dashboard header not visible after login.");
            return false;
        }
    }

    // Logout method to click on the user dropdown and then click logout
    public void logout() {
        // Wait for user dropdown and click it
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();

        // Wait for logout button and click it
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public boolean isUserDropdownVisible() {
        try {
            WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(userDropdown));
            return dropdown.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("User dropdown not visible.");
            return false;
        }

    }
}
