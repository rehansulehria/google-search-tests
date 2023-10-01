package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.google.constants.Locators.*;


public class GoogleHomePage extends BasePage {
    private final By searchInput = By.cssSelector(SEARCH_INPUT);
    private final By selectSearchTerm = By.xpath(SELECT_SEARCH_TERM);
    private final By submitSearch = By.cssSelector(SEARCH_SUBMIT);

    private WebElement getSearchInput() {
        return driver.findElement(searchInput);
    }

    private WebElement submitSearch() {
        return driver.findElement(submitSearch);
    }

    public void enterSearchText(String searchTerm) {
        getSearchInput().sendKeys(searchTerm);
        submitSearch().click();
    }
}
