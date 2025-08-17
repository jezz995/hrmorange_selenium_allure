package com.example.java.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // Locators
    private final By username = By.cssSelector("input[placeholder='Username']");
    private final By password = By.cssSelector("input[placeholder='Password']");
    private final By btnLogin = By.cssSelector("button[type='submit']");
    private final By errorMsg = By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    private final By dashboardHeader = By.xpath("//h6[normalize-space()='Dashboard']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getDashboardElement() {
        return getDriver().findElement(dashboardHeader);
    }

    /** Navigate to login page and wait until username field is visible */
    public void navigateToLogin() {
        getDriver().get(LOGIN_URL);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(username));
    }

    public void inputUsername(String userName) {
        inputHelper.waitAndInput(username, userName);
    }

    public void inputPassword(String pw) {
        inputHelper.waitAndInput(password, pw);
    }

    public void clickButtonLogin() {
        clickHelper.waitUntilVisibleAndClick(btnLogin);
    }

    /** Combined login action */
    public void loginAs(String user, String pw) {
        inputUsername(user);
        inputPassword(pw);
        clickButtonLogin();
    }

    public boolean isLoginErrorVisible() {
        try {
            WebElement error = getWait().until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
            return error.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginButtonVisible() {
        try {
            return getWait().until(ExpectedConditions.visibilityOfElementLocated(btnLogin)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
