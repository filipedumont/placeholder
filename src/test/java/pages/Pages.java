package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ffranca on 6/11/15.
 */
public class Pages {

    private final WebDriver driver;

    private SignInPage signInPage;
    private HomePage homePage;

    public Pages(WebDriver driver) {
        this.driver = driver;
    }

    public SignInPage signInPage(){
        if(null == signInPage){
            signInPage = PageFactory.initElements(this.driver, SignInPage.class);
        }
        return signInPage;
    }

    public HomePage homePage() {
        if(null == homePage){
            homePage = PageFactory.initElements(this.driver, HomePage.class);
        }
        return homePage;
    }

    public void close(){
        this.driver.close();
    }
}
