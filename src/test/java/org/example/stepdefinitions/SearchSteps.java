package org.example.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.pages.HomePage;
import org.example.pageobject.pages.SearchPage;
import org.testng.Assert;

import static org.example.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.stepdefinitions.BaseSteps.webDriver;

public class SearchSteps {

    @Given("User is on {string}")
    public void userIsOnHomePage(String pageName) {
        HomePage homePage = new HomePage(webDriver);
        PAGES_STORAGE.put(pageName, homePage.open());
    }

    @When("User enters searchWord  as {string} on {string}")
    public void userEntersSearchWord(String searchWord, String pageName) {
        PAGES_STORAGE.put("Search Page", ((HomePage) PAGES_STORAGE.get(pageName)).inputAndSubmitSearchField(searchWord));
    }

    @Then("User gets  message {string} on {string}")
    public void userGetsMessageOn(String searchText, String pageName) {
        Assert.assertTrue(((SearchPage) PAGES_STORAGE.get(pageName)).isElementWithTextVisible(searchText));
    }

    @Then("User gets  text {string} on {string}")
    public void userGetsTextOn(String searchText, String pageName) {
        Assert.assertTrue(((SearchPage) PAGES_STORAGE.get(pageName)).isElementWithTextVisible(searchText));
    }

    @Then("User gets products with {string} in the title on {string}")
    public void userGetsProductsWithInSearchTheTitleOn(String searchText, String pageName) {
        Assert.assertTrue(((SearchPage) PAGES_STORAGE.get(pageName)).isElementWithTextVisible(searchText, "//h2/a/span"));
    }
}