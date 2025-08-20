package com.example.java.dataprovider;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "employeeData")
    public static Object[][] employeeData() {
        return new Object[][] {
                // firstName, lastName, empId, username, password, expectedResult
                { "Rachel", "Sasongko", "0399", "rachelsas", "H@lo123!!!", "H@lo123!!!", true }, // Valid
                { "", "Doe", "0400", "johndoe", "H@lo123!!!", "H@lo123!!!", false }, // Missing first name
                { "John", "", "0401", "johnny", "H@lo123!!!", "H@lo123!!!", false }, // Missing last name
                { "Jane", "Doe", "0399", "janedoe", "H@lo123!!!", "H@lo123!!!", false }, // Duplicate Employee ID
                { "Alice", "Smith", "0402", "alicesmith", "Password12345", "Password12345", false }, // Weak password
                { "Bob@", "Marley", "0403", "bobmarley", "H@lo123!!!", "H@lo123!!!", false } // Invalid character in
                                                                                             // first name
        };
    }
}
