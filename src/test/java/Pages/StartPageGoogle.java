package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Nikolay on 04.08.2016.
 */
public class StartPageGoogle extends BasePage{

    @FindBy(id = "gs_lc0")
    private WebElement inputSearchField;

    @FindBy(name = "btnK")
    private WebElement searchButton;


    public StartPageGoogle() {
        driver.get("https://www.google.com.ua");
        PageFactory.initElements(driver, this);
        implicitWaitForElement(inputSearchField);
    }

    /**
     * Sends search request
     * @param request This string is search request
     */
    public SearchResults sendSearchRequest(String request){
        inputSearchField.sendKeys(request);
        inputSearchField.sendKeys(Keys.RETURN);


        return new SearchResults();
    }

}
