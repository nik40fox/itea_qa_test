package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Nikolay on 04.08.2016.
 */
public class SearchResults extends BasePage {

    @FindBy(className = "rc")
    private List<WebElement> searchResultList;

    @FindBy(id = "center_col")
    private WebElement centralColumn;

    @FindBy(xpath =".//*[@id='nav']/tbody/tr/td[3]/a" )
    private WebElement secondPage;

    @FindBy(xpath =".//*[@id='resultStats']" )
    private WebElement resultsStats;




    public SearchResults() {
        PageFactory.initElements(driver, this);
        implicitWaitForElement(centralColumn);
    }

    public String pageTitle (){
        implicitWaitForElement(centralColumn);
        return driver.getTitle();
    }

    public int numberOfResults(){
        return searchResultList.size();
    }


    private List<String> getSearchResultList() {
        List<String> titleTextList = new ArrayList<String>();
        Iterator<WebElement> i = searchResultList.iterator();
        while (i.hasNext()) {
            WebElement titleTextWebElement = i.next();
            String titleText = titleTextWebElement.getText();
            titleTextList.add(titleText);
        }
        return titleTextList;
    }

    public boolean isSearchTermContained(String searchTerm) {
        List<String> titleTextList = getSearchResultList();
        boolean isSearchTermContained = false;
        for (int i = 0; i < titleTextList.size(); i++) {
            if (titleTextList.get(i).contains(searchTerm)) {
                isSearchTermContained = true;
            }
        }
        return isSearchTermContained;
    }


    /**clicks link to the second page
     * @return
     */
    public SearchResults goToNextPage(){
        secondPage.click();
        return new SearchResults();
    }






}
