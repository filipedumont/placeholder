package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyParser;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by ffranca on 6/11/15.
 */
public class SignInPage {

    private static final Logger logger = Logger.getLogger(SignInPage.class.getName());
    private WebDriver driver;
    private WebDriverWait wait;
    private PropertyParser prop;


    /** Sign In Page Elements **/
    @FindBy(xpath = "//button[text()= 'Sign in']")
    private WebElement signInButton;

    @FindBy(id = "Email")
    private WebElement googleUserEmail;
    @FindBy(id="next")
    private WebElement googleUserNextButton;
    @FindBy(id = "Passwd")
    private WebElement googleUserPasswd;
    @FindBy(id = "signIn")
    private WebElement googleSignInButton;



    public SignInPage(WebDriver driver){

        this.driver = driver;
        //wait = new WebDriverWait(this.driver, 30);
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        prop = new PropertyParser();
    }

    public void openPage() {
        this.driver.get(prop.getPropertyValue("URL"));
    }

    public void authenticateWith(String username, String password){
        try{
            signInButton.click();
            googleUserEmail.sendKeys(prop.getPropertyValue(username));
            googleUserNextButton.click();
            googleUserPasswd.sendKeys(prop.getPropertyValue(password));
            googleSignInButton.click();
        }catch (NotFoundException e){
            logger.log(Level.SEVERE, e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean verifyPage() {
        return signInButton.isDisplayed();
    }
}
