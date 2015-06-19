package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyParser;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by ffranca on 6/11/15.
 */
public class HomePage {
    private static final Logger logger = Logger.getLogger(HomePage.class.getName());
    private WebDriver driver;
    private WebDriverWait wait;
    private PropertyParser prop;

    private static final String pageURL = "/home";

    /** Home Page elements **/

    @FindBy(css = "home-page-content")
    WebElement employeesList;

    @FindBy(id= "fill-profile-modal")
    WebElement profileModal;


    public HomePage(WebDriver driver){

        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
        prop = new PropertyParser();
    }


    public void navigateToPage(){
        this.driver.navigate().to(prop.getPropertyValue("URL") + pageURL);
    }

    public boolean verifyPage(){
        return profileModal.isDisplayed() || employeesList.isDisplayed();
    }

    public boolean verifyIncompleteProfile() {
        return profileModal.isDisplayed();
    }
}
