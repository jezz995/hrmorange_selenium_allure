package com.example.java.page;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private WebDriverWait wait;

    private static final String DASHBOARD_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"; // Update
                                                                                                                           // with
                                                                                                                           // actual
                                                                                                                           // URL

    // Locators
    private By dashboardHeader = By
            .xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']");
    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[normalize-space()='Logout']");
    private By adminButton = By.xpath("//a[normalize-space()='Admin']");
    private By pimButton = By.xpath("//span[normalize-space()='PIM']");
    private By leaveButton = By.xpath("//button[normalize-space()='Leave']");
    private By timeButton = By.xpath("//span[normalize-space()='Time']");
    private By recruitmentButton = By.xpath("//span[normalize-space()='Recruitment']");
    private By performanceButton = By.xpath("//span[normalize-space()='Performance']");
    private By myInfoButton = By.xpath("//span[normalize-space()='My Info']");
    private By directoryButton = By.xpath("//span[normalize-space()='Directory']");
    private By maintenanceButton = By.xpath("//span[normalize-space()='Maintenance']");

    private By adminPageHeader = By.xpath("//h6[normalize-space()='Admin']");
    private By pimPageHeader = By.xpath("//h6[normalize-space()='PIM']");
    private By leavePageHeader = By.xpath("//h6[normalize-space()='Leave']");
    private By timePageHeader = By.xpath("//h6[normalize-space()='Time']");
    private By recruitmentPageHeader = By.xpath("//h6[normalize-space()='Recruitment']");
    private By performancePageHeader = By.xpath("//h6[normalize-space()='Performance']");
    private By myInfoPageHeader = By.xpath("//h6[normalize-space()='My Info']");
    private By directoryPageHeader = By.xpath("//h6[normalize-space()='Directory']");
    private By maintenancePageHeader = By.xpath("//h6[normalize-space()='Maintenance']");

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToDashboard() {
        driver.get(DASHBOARD_URL);
        getWait().until(ExpectedConditions.urlToBe(DASHBOARD_URL));
    }

    public void clickAdminButton() {
        wait.until(ExpectedConditions.elementToBeClickable(adminButton)).click();
    }

    public void clickPIMButton() {
        wait.until(ExpectedConditions.elementToBeClickable(pimButton)).click();
    }

    public void clickLeaveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(leaveButton)).click();
    }

    public void clickTimeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(timeButton)).click();
    }

    public void clickRecruitmentButton() {
        wait.until(ExpectedConditions.elementToBeClickable(recruitmentButton)).click();
    }

    public void clickPerformanceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(performanceButton)).click();
    }

    public void clickMyInfoButton() {
        wait.until(ExpectedConditions.elementToBeClickable(myInfoButton)).click();
    }

    public void clickDirectoryButton() {
        wait.until(ExpectedConditions.elementToBeClickable(directoryButton)).click();
    }

    public void clickMaintenanceButton() {
        wait.until(ExpectedConditions.elementToBeClickable(maintenanceButton)).click();
    }

    public WebElement getDashboardHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
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
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
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
