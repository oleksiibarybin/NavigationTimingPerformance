package com.nopcommerce.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;


public class ComputersPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='picture']")
    WebElement desktopCategoryLink;

    @FindBy(xpath = "//div[@class='master-wrapper-page']")
    WebElement categoryBlock;

    public ComputersPage(WebDriver driver) {
        super(driver);
    }


    public DesktopPage clickOnDesktopCategoryLink() throws InterruptedException, IOException {
        waitForElementVisibility(categoryBlock);
        waitForElementToBeClickable(desktopCategoryLink);
        Thread.sleep(1000);
        desktopCategoryLink.click();
        waitForPageToLoad(driver);

        perfNavigationTiming.writeMetricsToJsonFile("DesktopPage");
        return new DesktopPage(driver);
    }

}
