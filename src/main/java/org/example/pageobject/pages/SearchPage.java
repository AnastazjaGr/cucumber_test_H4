package org.example.pageobject.pages;

import org.example.pageobject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isElementWithTextVisible(String searchText, String elXpath) {
        WebElement productResult = webDriver.findElement(
                By.xpath(elXpath + "[contains(text(), \"" + searchText + "\")]")
        );
        waitVisibilityOfElement(productResult);
        return productResult.isDisplayed();
    }

    public boolean isElementWithTextVisible(String searchText) {
        return isElementWithTextVisible(searchText, "//span");
    }
}