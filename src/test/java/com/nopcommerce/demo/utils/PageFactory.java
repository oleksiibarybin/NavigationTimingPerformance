package com.nopcommerce.demo.utils;

import com.nopcommerce.demo.driver.DriverManager;
import com.nopcommerce.demo.pages.ComputersPage;
import com.nopcommerce.demo.pages.DesktopPage;
import com.nopcommerce.demo.pages.HomePage;

public class PageFactory {

    public static HomePage getHomePage() {
        return new HomePage(DriverManager.getDriver());
    }

    public static ComputersPage getComputersPage() {
        return new ComputersPage(DriverManager.getDriver());
    }

    public static DesktopPage getDesktopPage() {
        return new DesktopPage(DriverManager.getDriver());
    }

}
