package steps;

import org.jbehave.core.annotations.*;
import org.junit.Assert;
import pages.Pages;
import pages.SignInPage;

/**
 * Created by ffranca on 6/11/15.
 */
public class BasicAuthenticationSteps {

    private Pages pages;

    public BasicAuthenticationSteps(Pages pages){
        this.pages = pages;
    }

    @Given("I am on $page")
    public void givenUserIsOnPage(String page){
        if("SignInPage".equals(page)){
            this.pages.signInPage().openPage();
        }
    }

    @When("I authenticate using $username and $password")
    public void authenticateUserWith(String username, String password){
        this.pages.signInPage().authenticateWith(username, password);
    }

    @Then("I should be on $page")
    public void checkPage(String page){
        if("SignInPage".equals(page)){
            Assert.assertTrue(this.pages.signInPage().verifyPage());
        }
        else if("HomePage".equals(page)) {
            Assert.assertTrue(this.pages.homePage().verifyPage());
        }
    }

   @Then("I should see CompleteProfileModal")
    public void verifyCompleteProfileModal(){
       Assert.assertTrue(this.pages.homePage().verifyIncompleteProfile());
   }

//    @AfterScenario
//    public void afterScenario(){
//        this.pages.close();
//    }
}
