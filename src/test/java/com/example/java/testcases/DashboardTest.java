package com.example.java.testcases;

import com.example.java.page.DashboardPage;
import com.example.java.base.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.example.java.base.TestListener;

@Listeners({ TestListener.class }) // Enable listener for screenshots and Allure
@Epic("Dashboard Tests")
@Feature("Dashboard Functionality")

public class DashboardTest extends BaseTest {

    private DashboardPage dashboardPage;

    @BeforeMethod
    public void setUpDashboardPage() {
        dashboardPage = new DashboardPage(getDriver());
        dashboardPage.navigateToDashboard();
    }

    @Story("Navigate to Dashboard")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify navigation to Dashboard page")
    public void testNavigateToDashboard() {
        dashboardPage.navigateToDashboard();

        Assert.assertTrue(dashboardPage.isDashboardHeaderVisible(),
                "Dashboard header is not visible after navigation.");
    }

    @Story("Click Admin Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking Admin button")
    public void testClickAdminButton() {
        dashboardPage.clickAdminButton();

        Assert.assertTrue(dashboardPage.isAdminPageVisible(), "Admin page is not visible after clicking Admin button.");
    }

    @Story("Click PIM Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking PIM button")
    public void testClickPIMButton() {
        dashboardPage.clickPIMButton();

        Assert.assertTrue(dashboardPage.isPIMPageVisible(), "PIM page is not visible after clicking PIM button.");
    }

    @Story("Click Leave Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking Leave button")
    public void testClickLeaveButton() {
        dashboardPage.clickLeaveButton();

        Assert.assertTrue(dashboardPage.isLeavePageVisible(), "Leave page is not visible after clicking Leave button.");
    }

    @Story("Click Time Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking Time button")
    public void testClickTimeButton() {
        dashboardPage.clickTimeButton();

        Assert.assertTrue(dashboardPage.isTimePageVisible(), "Time page is not visible after clicking Time button.");
    }

    @Story("Click Recruitment Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking Recruitment button")
    public void testClickRecruitmentButton() {
        dashboardPage.clickRecruitmentButton();

        Assert.assertTrue(dashboardPage.isRecruitmentPageVisible(),
                "Recruitment page is not visible after clicking Recruitment button.");
    }

    @Story("Click Performance Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking Performance button")
    public void testClickPerformanceButton() {
        dashboardPage.clickPerformanceButton();

        Assert.assertTrue(dashboardPage.isPerformancePageVisible(),
                "Performance page is not visible after clicking Performance button.");
    }

    @Story("Click My Info Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking My Info button")
    public void testClickMyInfoButton() {
        dashboardPage.clickMyInfoButton();

        Assert.assertTrue(dashboardPage.isMyInfoPageVisible(),
                "My Info page is not visible after clicking My Info button.");
    }

    @Story("Click Directory Button")
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Verify clicking Directory button")
    public void testClickDirectoryButton() {
        dashboardPage.clickDirectoryButton();

        Assert.assertTrue(dashboardPage.isDirectoryPageVisible(),
                "Directory page is not visible after clicking Directory button.");
    }

}
