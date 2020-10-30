package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.components.MainMenu;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.nopcommerce.demo.components.MainMenu.MenuCategories.COMPUTERS;

public class HomePage extends AbstractPage {

    protected static final String BASE_URL = "https://demo.nopcommerce.com/";


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openHomePage() throws IOException {
        driver.get(BASE_URL);
        waitForPageToLoad(driver);
        perfNavigationTiming.writeMetricsToJsonFile("HomePage");
        return this;
    }

    public ComputersPage openComputersPage() throws IOException {
        MainMenu menu = new MainMenu(driver);
        menu.clickOnCategory(COMPUTERS);
        waitForPageToLoad(driver);
        perfNavigationTiming.writeMetricsToJsonFile("ComputersPage");
        return new ComputersPage(driver);
    }
}
