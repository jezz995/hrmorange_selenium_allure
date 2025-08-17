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
                pimPage.clickAddEmployeeButton()
                                .inputAddFirstName("John")
                                .inputAddLastName("Doe")
                                .inputAddEmployeeId("0911") // Assuming employee ID is required
                                .clickAddLoginDetailSlider()
                                .inputAddUsername("JohnDoe113")
                                .inputAddPassword("password123")
                                .inputAddConfirmPassword("password123")
                                .clickAddSaveButton();

                Assert.assertTrue(pimPage.isEmployeeAdded(), "New employee was not added successfully.");
        }

        @Story("Add New Employee With Missing First name")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with missing first name")
        public void testAddNewEmployeeWithMissingFirstName() {
                pimPage.clickAddEmployeeButton()
                                .inputAddLastName("Doe")
                                .clickAddLoginDetailSlider()
                                .inputAddUsername("johndoe")
                                .inputAddPassword("password123")
                                .inputAddConfirmPassword("password123")
                                .clickAddSaveButton();

                Assert.assertTrue(pimPage.isEmployeeAdded(),
                                "Employee was added without a first name, which is not expected.");
        }

        @Story("Add New Employee With Missing Last Name")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with missing last name")
        public void testAddNewEmployeeWithMissingLastName() {
                pimPage.clickAddEmployeeButton()
                                .inputAddFirstName("John")
                                .clickAddLoginDetailSlider()
                                .inputAddUsername("johndoe")
                                .inputAddPassword("password123")
                                .inputAddConfirmPassword("password123")
                                .clickAddSaveButton();

                Assert.assertTrue(pimPage.isEmployeeAdded(),
                                "Employee was added without a last name, which is not expected.");
        }

        @Story("Add New Employee With Duplicate Employee ID")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with a duplicate employee ID")
        public void testAddNewEmployeeWithDuplicateEmployeeId() {
                pimPage.clickAddEmployeeButton()
                                .inputAddFirstName("Jane")
                                .inputAddLastName("Doe")
                                .inputAddEmployeeId("0999") // Using the same ID as in the previous test
                                .clickAddLoginDetailSlider()
                                .inputAddUsername("janedoe")
                                .inputAddPassword("password123")
                                .inputAddConfirmPassword("password123")
                                .clickAddSaveButton();

                Assert.assertTrue(pimPage.isEmployeeAdded(),
                                "Employee was added with a duplicate employee ID, which is not expected.");
        }

        @Story("Add New Employee with weak password")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with a weak password")
        public void testAddNewEmployeeWithWeakPassword() {
                pimPage.clickAddEmployeeButton()
                                .inputAddFirstName("Alice")
                                .inputAddLastName("Smith")
                                .inputAddEmployeeId("1001")
                                .clickAddLoginDetailSlider()
                                .inputAddUsername("alicesmith")
                                .inputAddPassword("12345") // Weak password
                                .clickAddSaveButton();

                Assert.assertTrue(pimPage.isEmployeeAdded(),
                                "Employee was added with a weak password, which is not expected.");
        }

        @Story("Add New Employee with invalid characters in first name")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify adding a new employee with invalid characters in first name")
        public void testAddNewEmployeeWithInvalidFirstName() {
                pimPage.clickAddEmployeeButton()
                                .inputAddFirstName("John@Doe") // Invalid characters in first name
                                .inputAddLastName("Smith")
                                .inputAddEmployeeId("1002")
                                .clickAddLoginDetailSlider()
                                .inputAddUsername("johnsmith")
                                .inputAddPassword("password123")
                                .inputAddConfirmPassword("password123")
                                .clickAddSaveButton();

                Assert.assertTrue(pimPage.isEmployeeAdded(),
                                "Employee was added with invalid characters in first name, which is not expected.");
        }

}
