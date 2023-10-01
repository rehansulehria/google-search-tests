package com.google.tests;

import com.google.pages.BasePage;
import com.google.pages.GoogleHomePage;
import com.google.pages.GoogleSearchResultPage;
import com.google.utils.LoadProps;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchResultTest extends BasePage {

    GoogleHomePage searchHomePage = new GoogleHomePage();
    GoogleSearchResultPage searchResultPage = new GoogleSearchResultPage();
    LoadProps props = new LoadProps();

    @Test
    public void googleSearchTest() throws IOException {
        String searchTerm = props.getProperty("searchTerm");
        searchHomePage.enterSearchText(searchTerm);
        searchResultPage.clickFirstSearchResult(searchTerm);
    }
}