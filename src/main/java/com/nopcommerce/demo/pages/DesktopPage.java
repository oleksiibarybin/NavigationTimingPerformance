package com.nopcommerce.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class DesktopPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='details']//a")
    WebElement firstDesktopItemLink;

    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstDesktopItem() throws IOException {
        waitForElementToBeClickable(firstDesktopItemLink);
        firstDesktopItemLink.click();
        waitForPageToLoad(driver);
        perfNavigationTiming.writeMetricsToJsonFile("DesktopItemPage");
    }
}
