package com.nopcommerce.demo.tests;

import com.nopcommerce.demo.driver.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public void testSetUp() {
        DriverManager.getDriver();
    }

    @AfterClass
    public void testTearDown() {
        DriverManager.quitDriver();
    }

}
