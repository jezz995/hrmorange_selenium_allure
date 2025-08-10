package com.example.java.page;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class DashboardPage {
    private WebDriverWait wait;

    // Locators
    private By dashboardHeader = By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Dashboard']");
    private By pimMenu = By.xpath("//span[normalize-space()='PIM']");
    private By userDropdown = By.className("oxd-userdropdown-name");
    private By logoutButton = By.xpath("//a[normalize-space()='Logout']");


    public DashboardPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public boolean isDashboardHeaderVisible() {
        try {
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
            return header.isDisplayed();
        } catch (TimeoutException e) {
            System.out.println("Dashboard header not visible after login.");
            return false;
        }
    }

    public void clickPIMMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(pimMenu)).click();
    }

    public void logout() {
        // Wait for user dropdown and click it
        wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();

        // Wait for logout button and click it
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}
