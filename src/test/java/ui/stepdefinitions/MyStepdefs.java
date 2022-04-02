package ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ui.pages.HomePage;
import ui.pages.SearchResult;
import ui.pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Locale;

public class MyStepdefs {

    HomePage homePage=new HomePage();
    SignInPage signInPage=new SignInPage();
    SearchResult searchResult=new SearchResult();

    @Given("user is on the home page")
    public void userIsOnTheHomePage() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));



    }

    @And("user clicks to login")
    public void userClicksToLogin() {
        homePage.signInButton.click();
    }

    @When("user enters correct credentials {string} {string}")
    public void userEntersCorrectCredentials(String arg0, String arg1) {

        signInPage.email.sendKeys(ConfigReader.getProperty("email"), Keys.ENTER);

        signInPage.password.sendKeys(ConfigReader.getProperty("password"),Keys.ENTER);



    }

    @Then("user should login successfully")
    public void userShouldLoginSuccessfully() {
        ReusableMethods.waitFor(2);
        System.out.println(homePage.navUser.getText());

       Assert.assertFalse(homePage.navUser.getText().contains("Anmelden"));

       Assert.assertTrue(homePage.amazonLogo.isDisplayed());


    }


    @And("user selects {string} from dropdown")
    public void userSelectsFromDropdown(String category) {
        ReusableMethods.waitFor(1);
        Select select=new Select(homePage.searchDropdownBox);
        select.selectByVisibleText(category);


    }

    @Then("user enters {string} on search button")
    public void userEntersOnSearchButton(String keyword) {
        homePage.searchtxtbox.sendKeys(keyword+Keys.ENTER);
    }

    @And("user checks that all results contain {string}")
    public void userChecksThatAllResultsContain(String keyword) {

        List<WebElement>  resultList= searchResult.allSearchItemList;
        int count=0;
        for(int i=1;i<resultList.size()-1;i++){
            if (!resultList.get(i).getText().toLowerCase().contains(keyword)){
                count++;

            }
            System.out.println("1"+resultList.get(i).getText());
            System.out.println(count);
        }
        Assert.assertTrue(count==0);

    }

    @Then("user closes browser")
    public void userClosesBrowser() {
        Driver.closeDriver();
    }
}
