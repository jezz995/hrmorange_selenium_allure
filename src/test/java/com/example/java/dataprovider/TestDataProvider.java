package com.example.java.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "employeeData")
    public static Object[][] employeeData() {
        return new Object[][] {
                // firstName, lastName, empId, username, password, expectedResult
                { "Rachel", "Sasongko", "0399", "rachelsas", "password123", true }, // Valid
                { "", "Doe", "0400", "johndoe", "password123", false }, // Missing first name
                { "John", "", "0401", "johnny", "password123", false }, // Missing last name
                { "Jane", "Doe", "0399", "janedoe", "password123", false }, // Duplicate Employee ID
                { "Alice", "Smith", "0402", "alicesmith", "12345", false }, // Weak password
                { "Bob@", "Marley", "0403", "bobmarley", "password123", false } // Invalid character in first name
        };
    }
}
