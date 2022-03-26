package ui.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import ui.pages.HomePage;
import ui.pages.SignInPage;
import utilities.ConfigReader;
import utilities.Driver;

public class MyStepdefs {

    HomePage homePage=new HomePage();
    SignInPage signInPage=new SignInPage();
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

        Assert.assertTrue(homePage.navUser.getText().contains("Hallo"));
        Assert.assertTrue(homePage.amazonLogo.isDisplayed());


    }
}
