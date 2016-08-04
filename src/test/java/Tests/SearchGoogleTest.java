package Tests;

import Pages.SearchResults;
import Pages.StartPageGoogle;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Nikolay on 04.08.2016.
 */
public class SearchGoogleTest {
    final static String searchTerm = "ITEA";

    @Test
    public void SearchInGoogleTest(){
        StartPageGoogle startPageGoogle = new StartPageGoogle();
        SearchResults searchResults = startPageGoogle.sendSearchRequest(searchTerm);

        Assert.assertEquals(searchResults.pageTitle(),"itea - Поиск в Google","titles does not match");
        Assert.assertEquals(searchResults.numberOfResults(), 8, "nuber of results expected to be 8 on first page");
        Assert.assertTrue(searchResults.isSearchTermContained(searchTerm), "not every result contains search term");

        SearchResults searchResults2 = searchResults.goToNextPage();
        
        //works with sleep
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Assert.assertEquals(searchResults2.numberOfResults(), 10, "nuber of results expected to be 10 on second page");
        Assert.assertTrue(searchResults2.isSearchTermContained(searchTerm), "not every result contains search term");

    }

}
