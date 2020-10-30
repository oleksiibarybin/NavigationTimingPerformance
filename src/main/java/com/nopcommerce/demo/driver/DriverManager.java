package com.nopcommerce.demo.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {

    private static WebDriver driver;
    private static String driverType = "";

    private DriverManager() {
    }

    public static WebDriver getDriver(String driverName) {
        driverType = driverName.toLowerCase();

        if (null == driver) {
            switch (driverName) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                    driver = new ChromeDriver(chromeOptions);
                }
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver == null ? getDriver(driverType) : driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
