package com.example.java.testcases;

import com.example.java.base.BaseTest;
import com.example.java.page.PIMPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.example.java.base.TestListener;

@Listeners({ TestListener.class }) // Enable listener for screenshots and Allure
@Epic("PIM Tests")
@Feature("PIM Functionality")

public class PIMTest extends BaseTest {

        private PIMPage pimPage;

        @BeforeMethod
        public void setUpPIMPage() {
                pimPage = new PIMPage(getDriver());
                pimPage.navigateToPIM();
        }

        @Story("Navigate to PIM Page")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify navigation to PIM page")
        public void testNavigateToPIM() {
                pimPage.navigateToPIM();
                Assert.assertTrue(pimPage.isPIMPageVisible(), "PIM page is not visible after navigation.");
        }

        @Story("Add New Employee")
        @Severity(SeverityLevel.CRITICAL)
        @Test(description = "Verify adding a new employee")
        public void testAddNewEmployee() {
                pimPage.addEmployee("Danny", "lockheed", "danny890", "H@lo123!!!", "90088", "H@lo123!!!");
                String firstName = "Jake";
                String lastName = "eagle";

                Assert.assertTrue(pimPage.isEmployeeProfileDisplayed(firstName, lastName),
                                "Employee " + firstName + " " + lastName + " was not displayed on profile panel.");
        }

        @Story("Add New Employee With Missing First name")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with missing first name")
        public void testAddNewEmployeeWithMissingFirstName() {
                pimPage.addEmployee("", "lisa", "7890", "lisa9090", "H@lo123!!!", "H@lo123!!!");

                Assert.assertTrue(pimPage.isFirstNameMissingErrorDisplayed(),
                                "Employee was added without a first name, which is not expected.");
        }

        @Story("Add New Employee With Missing Last Name")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with missing last name")
        public void testAddNewEmployeeWithMissingLastName() {
                pimPage.addEmployee("Rissa", "", "6799", "Rissa888", "H@lo123!!!", "H@lo123!!!");

                Assert.assertTrue(pimPage.isEmployeeProfileDisplayed("Rissa", ""),
                                "Employee was added without a last name, which is not expected.");
        }

        @Story("Add New Employee With Duplicate Employee ID")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with a duplicate employee ID")
        public void testAddNewEmployeeWithDuplicateEmployeeId() {
                String expectedMessage = "Employee ID already exists";
                pimPage.addEmployee("Diamond", "jack", "100000001", "jack9090", "H@lo123!!!", "H@lo123!!!");

                Assert.assertTrue(pimPage.isEmployeeIdWarningVisible(expectedMessage),
                                "Employee was added with a duplicate employee ID, which is not expected.");
        }

        @Story("Add New Employee with weak password")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with a weak password")
        public void testAddNewEmployeeWithWeakPassword() {
                String expectedStrength = "Weak";
                pimPage.addEmployee("Yunus", "mahmud", "896788", "Yunus18", "password1234", "password1234");

                Assert.assertTrue(pimPage.isPasswordStrength(expectedStrength),
                                "Password Strength was not '" + expectedStrength + "'");
        }

        @Story("check employee on employee list")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify employee is displayed on employee list")
        public void testCheckEmployeeOnEmployeeList() {
                pimPage.searchEmployee("Jake", "909088", "", "", "");
                String firstName = "Jake";
                String lastName = "eagle";

                Assert.assertTrue(pimPage.isEmployeeDisplayedInList(firstName, lastName),
                                "Employee " + firstName + " " + lastName + " was not displayed on employee list.");

        }

}
