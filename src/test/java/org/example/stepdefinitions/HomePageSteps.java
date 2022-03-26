package org.example.stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.webDriver;

public class HomePageSteps {
    @Then("User is successfully navigated to the {string}")
    public void userIsSuccessfullyNavigatedToTheHomePage(String expectedUrl) {
        Assert.assertEquals(expectedUrl, webDriver.getCurrentUrl());
    }
}
