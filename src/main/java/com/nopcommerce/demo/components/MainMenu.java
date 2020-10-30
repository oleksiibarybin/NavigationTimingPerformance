package com.nopcommerce.demo.components;

import com.nopcommerce.demo.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainMenu extends AbstractPage {

    public MainMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='/computers']")
    WebElement computersLink;

    public void clickOnCategory(MenuCategories category) {
        switch (category) {
            case COMPUTERS:
                computersLink.click();
                break;
            default:
                throw new EnumConstantNotPresentException(MenuCategories.class, category.name());
        }
    }

    public enum MenuCategories {
        COMPUTERS
    }
}
