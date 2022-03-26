package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public HomePage open() {
        webDriver.get("https://www.amazon.com/");
        return this;
    }
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;

    public SearchPage inputAndSubmitSearchField(String input) {
        searchField.sendKeys(input);
        searchField.sendKeys(Keys.RETURN);
        return new SearchPage(webDriver);
    }
}

