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
        @Severity(SeverityLevel.CRITICAL)
        @Test(description = "Verify navigation to PIM page")
        public void testNavigateToPIM() {
                pimPage.navigateToPIM();
                Assert.assertTrue(pimPage.isPIMPageVisible(), "PIM page is not visible after navigation.");
        }

        @Story("Add New Employee")
        @Severity(SeverityLevel.CRITICAL)
        @Test(description = "Verify adding a new employee")
        public void testAddNewEmployee() {
                pimPage.addEmployee("Ronnie", "willis", "944800", "Ronnie444", "H@lo123!!!", "H@lo123!!!");
                pimPage.clickEmployeeDetailsJobButton();
                pimPage.selectJobTitle("Finance Manager");
                pimPage.clickEmployeedetailsSaveButton();

                Assert.assertTrue(pimPage.isSuccessMessageDisplayed(),
                                "Success message was not displayed after saving employee details.");
        }

        @Story("check employee on employee list")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Verify employee is displayed on employee list")
        public void testCheckEmployeeOnEmployeeList() {
                pimPage.searchEmployee("Ronnie", "944800", "", "", "");
                String firstName = "Ronnie";

                Assert.assertTrue(pimPage.isEmployeeDisplayedInList(firstName),
                                "Employee with first name '" + firstName + "' was not displayed on employee list.");

        }

        @Story("delete employee on employee list")
        @Severity(SeverityLevel.NORMAL)
        @Test(description = "Employee data can be deleted from the employee list")
        public void testDeleteEmployeeOnTheEmployeeList() {
                pimPage.searchEmployee("Ronnie", "944800", "", "", "");
                String firstName = "Ronnie";
                pimPage.clickCheckBox();
                pimPage.clickDeleteButton();
                pimPage.clickYesDeleteEmployeeButton();

                Assert.assertTrue(
                                pimPage.isSuccessMessageDisplayed(),
                                "Success message was not displayed after deleting the employee.");

                Assert.assertFalse(pimPage.isEmployeeDeleted(firstName), "Employee with first name '" + firstName
                                + "' still appears in the list after deletion.");

        }

}
