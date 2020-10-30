package com.nopcommerce.demo.tests;

import com.nopcommerce.demo.utils.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationTimingTest extends BaseTest {

    private static final String ASSERTION_ERROR_MESSAGE = "Page title is NOT equal to expected";

    @Test(priority = 1)
    public void openHomePage() throws IOException {
        PageFactory
                .getHomePage()
                .openHomePage();

        Assert.assertEquals(
                PageFactory.getHomePage().getPageTitle(),
                "nopCommerce demo store",
                ASSERTION_ERROR_MESSAGE);
    }

    @Test(priority = 2)
    public void openComputerPage() throws IOException {
        PageFactory
                .getHomePage()
                .openComputersPage();

        Assert.assertEquals(
                PageFactory.getComputersPage().getPageTitle(),
                "nopCommerce demo store. Computers",
                ASSERTION_ERROR_MESSAGE);
    }

    @Test(priority = 3)
    public void openDesktopPage() throws InterruptedException, IOException {
        PageFactory
                .getComputersPage()
                .clickOnDesktopCategoryLink();

        Assert.assertEquals(
                PageFactory.getDesktopPage().getPageTitle(),
                "nopCommerce demo store. Desktops",
                ASSERTION_ERROR_MESSAGE);
    }

    @Test(priority = 4)
    public void openDesktopFirstItem() throws IOException {
        PageFactory
                .getDesktopPage()
                .clickOnFirstDesktopItem();

        Assert.assertEquals(
                PageFactory.getDesktopPage().getPageTitle(),
                "nopCommerce demo store. Build your own computer",
                ASSERTION_ERROR_MESSAGE);
    }
}
