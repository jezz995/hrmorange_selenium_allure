package com.example.java.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class PIMPage extends BasePage {

    private static final String PIM_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPimModule";

    // Navigation locators
    private final By addEmployeeButton = By.xpath("//a[normalize-space()='Add Employee']");
    private final By employeeListButton = By.xpath("//a[normalize-space()='Employee List']");

    // Employee search form
    private final By employeeNameField = By.cssSelector("input[placeholder='Type for hints...']");
    private final By employeeIdField = By.cssSelector("input[placeholder='Employee Id']");
    private final By jobTitleField = By.cssSelector("input[placeholder='Job Title']");
    private final By employmentStatus = By.cssSelector("input[placeholder='Employment Status']");
    private final By supervisorField = By.cssSelector("input[placeholder='Supervisor']");

    // locators for add employee form
    private final By addfirstNameField = By.cssSelector("input[placeholder='First Name']");
    private final By addlastNameField = By.cssSelector("input[placeholder='Last Name']");
    private final By addemployeeidField = By.xpath("//input[@class='oxd-input oxd-input--focus']");
    private final By addsaveButton = By.xpath("(//button[normalize-space()='Save'])[1]");
    private final By addcancelButton = By
            .cssSelector("button[class='oxd-button oxd-button--medium oxd-button--ghost']");

    // login details locators
    private final By addlogindetailslider = By
            .cssSelector(".oxd-switch-input.oxd-switch-input--active.--label-right");
    private final By addusernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private final By addpasswordField = By.xpath("(//input[@type='password'])[1]");
    private final By addconfirmPasswordField = By.xpath("(//input[@type='password'])[2]");

    // validation locators
    private final By personalDetailsHeader = By.cssSelector(".oxd-text.oxd-text--h6.--strong");

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    // navigate to PIM page and wait until employee list button is visible
    public void navigateToPIM() {
        getDriver().get(PIM_URL);
        getWait().until(ExpectedConditions.visibilityOfElementLocated(employeeListButton));
    }

    // employee search
    public void inputEmployeeName(String name) {
        inputHelper.waitAndInput(employeeNameField, name);
    }

    public void inputEmployeeId(String id) {
        inputHelper.waitAndInput(employeeIdField, id);
    }

    public void inputJobTitle(String title) {
        inputHelper.waitAndInput(jobTitleField, title);
    }

    public void inputEmploymentStatus(String status) {
        inputHelper.waitAndInput(employmentStatus, status);
    }

    public void inputSupervisor(String supervisor) {
        inputHelper.waitAndInput(supervisorField, supervisor);
    }

    // add employee methods
    public PIMPage clickAddEmployeeButton() {
        clickHelper.waitUntilVisibleAndClick(addEmployeeButton);
        return this; // Return this for method chaining
    }

    public PIMPage inputAddFirstName(String firstName) {
        inputHelper.waitAndInput(addfirstNameField, firstName);
        return this; // Return this for method chaining
    }

    public PIMPage inputAddLastName(String lastName) {
        inputHelper.waitAndInput(addlastNameField, lastName);
        return this; // Return this for method chaining
    }

    public PIMPage clickAddSaveButton() {
        clickHelper.waitUntilVisibleAndClick(addsaveButton);
        return this; // Return this for method chaining
    }

    public PIMPage clickAddLoginDetailSlider() {
        clickHelper.waitUntilVisibleAndClick(addlogindetailslider);
        return this; // Return this for method chaining
    }

    public PIMPage inputAddEmployeeId(String empId) {
        WebElement empField = getWait().until(ExpectedConditions.visibilityOfElementLocated(addemployeeidField));
        // hapus field terlebih dahulu
        empField.sendKeys(Keys.CONTROL + "a");
        empField.sendKeys(Keys.DELETE);
        // Input the employee ID
        empField.sendKeys(empId);
        return this;
    }

    // login details methods
    public PIMPage inputAddPassword(String password) {
        inputHelper.waitAndInput(addpasswordField, password);
        return this; // Return this for method chaining
    }

    public PIMPage inputAddUsername(String username) {
        WebElement userField = getWait().until(ExpectedConditions.visibilityOfElementLocated(addusernameField));
        // Clear the existing value (CTRL+A + DELETE)
        userField.sendKeys(Keys.CONTROL + "a");
        userField.sendKeys(Keys.DELETE);
        // Enter new username
        userField.sendKeys(username);
        return this;
    }

    public PIMPage inputAddConfirmPassword(String confirmPassword) {
        inputHelper.waitAndInput(addconfirmPasswordField, confirmPassword);
        return this; // Return this for method chaining
    }

    public PIMPage clickAddCancelButton() {
        clickHelper.waitUntilVisibleAndClick(addcancelButton);
        return this; // Return this for method chaining
    }

    // high methods to add employee
    public void addEmployee(String firstName, String lastName, String username, String password,
            String confirmPassword) {
        clickAddEmployeeButton();
        inputAddFirstName(firstName);
        inputAddLastName(lastName);
        inputAddEmployeeId(""); // Assuming employee ID is auto-generated or not required
        clickAddLoginDetailSlider();
        inputAddUsername(username);
        inputAddPassword(password);
        inputAddConfirmPassword(confirmPassword);
        clickAddSaveButton();
    }

    // visibility checks ( Assertions)
    public boolean isPIMPageVisible() {
        return isElementVisible(employeeListButton);
    }

    public boolean isAddEmployeeButtonVisible() {
        return isElementVisible(addEmployeeButton);
    }

    public boolean isEmployeeListButtonVisible() {
        return isElementVisible(employeeListButton);
    }

    public boolean isEmployeeNameFieldVisible() {
        return isElementVisible(employeeNameField);
    }

    public boolean isEmployeeIdFieldVisible() {
        return isElementVisible(employeeIdField);
    }

    public boolean isJobTitleFieldVisible() {
        return isElementVisible(jobTitleField);
    }

    public boolean isEmploymentStatusVisible() {
        return isElementVisible(employmentStatus);
    }

    public boolean isSupervisorFieldVisible() {
        return isElementVisible(supervisorField);
    }

    // add employee form visibility checks
    public boolean isAddFirstNameFieldVisible() {
        return isElementVisible(addfirstNameField);
    }

    public boolean isAddLastNameFieldVisible() {
        return isElementVisible(addlastNameField);
    }

    public boolean isAddSaveButtonVisible() {
        return isElementVisible(addsaveButton);
    }

    public boolean isAddLoginDetailSliderVisible() {
        return isElementVisible(addlogindetailslider);
    }

    public boolean isAddUsernameFieldVisible() {
        return isElementVisible(addusernameField);
    }

    public boolean isAddPasswordFieldVisible() {
        return isElementVisible(addpasswordField);
    }

    public boolean isAddConfirmPasswordFieldVisible() {
        return isElementVisible(addconfirmPasswordField);
    }

    public boolean isAddCancelButtonVisible() {
        return isElementVisible(addcancelButton);
    }

    // validation checks
    public boolean isEmployeeAdded() {
        try {
            WebElement header = getWait().until(
                    ExpectedConditions.visibilityOfElementLocated(personalDetailsHeader));
            return header.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
