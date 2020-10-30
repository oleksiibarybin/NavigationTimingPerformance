package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.navigationtiming.PerfNavigationTiming;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected PerfNavigationTiming perfNavigationTiming = new PerfNavigationTiming();

    private final int TIMEOUT = 30;


    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForPageToLoad(WebDriver driver) {
        new WebDriverWait(driver, TIMEOUT)
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitForElementVisibility(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

}
