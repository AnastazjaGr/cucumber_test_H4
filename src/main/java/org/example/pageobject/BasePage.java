package org.example.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver webDriver;
    private static final long DEFAULT_WAITING_TIME = 10;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void waitVisibilityOfElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_WAITING_TIME));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageLoadComplete() {
        new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_WAITING_TIME)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
