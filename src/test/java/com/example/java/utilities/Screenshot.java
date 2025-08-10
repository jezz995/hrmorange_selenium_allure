package com.example.java.utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {

    private static final String SCREENSHOT_DIR = System.getProperty("user.dir")
            + File.separator + "target" + File.separator + "screenshots";

    public void takeScreenshot(WebDriver driver, String testName) {
        try {
            Path screenshotPath = Paths.get(SCREENSHOT_DIR);
            if (Files.notExists(screenshotPath)) {
                Files.createDirectories(screenshotPath);
            }

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath.toFile(), testName + ".png");
            Files.copy(src.toPath(), dest.toPath());

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Unexpected error during screenshot: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png", fileExtension = ".png")
    public byte[] attachScreenshotPNG(String fileName) {
        try {
            Path filePath = Paths.get(SCREENSHOT_DIR, fileName + ".png");
            if (Files.exists(filePath)) {
                return Files.readAllBytes(filePath);
            } else {
                System.err.println("Screenshot file not found for Allure attachment.");
                return new byte[0];
            }
        } catch (IOException e) {
            System.err.println("Failed to read screenshot for Allure: " + e.getMessage());
            return new byte[0];
        }
    }
}
