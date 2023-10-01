package com.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.google.constants.Locators.FIRST_SEARCH_RESULT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GoogleSearchResultPage extends BasePage {
    private final By firstSearchResult = By.cssSelector(FIRST_SEARCH_RESULT);

    public WebElement getFirstSearchResult() {
        return driver.findElement(firstSearchResult);
    }

    public void clickFirstSearchResult(String searchTerm) {
        String searchResultText = getFirstSearchResult().getText();
        assertThat(searchResultText, equalTo(searchTerm));
        getFirstSearchResult().click();
    }

}
