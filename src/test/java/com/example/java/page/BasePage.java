package com.example.java.page;

import com.example.java.helpers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitClickHelper clickHelper;
    protected WaitInputHelper inputHelper;
    protected ScrollHelper scrollHelper;
    protected GetTextHelper textHelper;
    protected SelectHelper selectHelper;
    protected WebDriverWait wait;

    // Default timeout for waits
    private static final int DEFAULT_TIMEOUT = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        // Initialize helpers
        this.clickHelper = new WaitClickHelper(driver, DEFAULT_TIMEOUT);
        this.inputHelper = new WaitInputHelper(driver, DEFAULT_TIMEOUT);
        this.scrollHelper = new ScrollHelper(driver, DEFAULT_TIMEOUT);
        this.textHelper = new GetTextHelper(driver, DEFAULT_TIMEOUT);
        this.selectHelper = new SelectHelper(driver, DEFAULT_TIMEOUT);

        // Centralized explicit wait
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    /** Getter for WebDriver */
    protected WebDriver getDriver() {
        return driver;
    }

    /** Getter for centralized WebDriverWait */
    protected WebDriverWait getWait() {
        return wait;
    }

    protected boolean isElementVisible(By locator) {
        try {
            return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // Generic wait for visibility
    protected WebElement waitForVisibility(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Generic wait for presence
    protected WebElement waitForPresence(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // If you want to override wait time
    protected WebElement waitForVisibility(By locator, int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Helper method to clear and type text into an input field
    public void clearAndType(WebElement element, String text) {
        try {
            element.clear(); // coba cara biasa
        } catch (Exception e) {
            // kalau gagal, pakai ctrl+a + delete
            element.sendKeys(Keys.CONTROL + "a");
            element.sendKeys(Keys.DELETE);
        }
        element.sendKeys(text);
    }
}
