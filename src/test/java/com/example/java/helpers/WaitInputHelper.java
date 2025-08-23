package com.example.java.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitInputHelper {
    private WebDriverWait wait;

    public WaitInputHelper(WebDriver driver, int timeoutSeconds) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitAndInput(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

        element.click(); // focus
        element.clear();

        if (text != null && !text.isEmpty()) {
            element.sendKeys(text);
            // Sometimes OrangeHRM requires blur/Tab to trigger validation
            element.sendKeys(Keys.TAB);
        }
    }
}
