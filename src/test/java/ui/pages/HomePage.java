package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//*[@id=\"sp-cc-accept\"]")
    public WebElement cookies;

    @FindBy(xpath= "//*[@id=\"nav-link-accountList\"]/span")
    public WebElement signInButton;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchtxtbox;



    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement navUser;

    @FindBy(xpath= "\"//*[@id=\"nav-logo-sprites\"]\"")
    public WebElement amazonLogo;

    @FindBy(id = "searchDropdownBox")
    public WebElement searchDropdownBox;

    @FindBy(id = "nav-search-label-id")
    public WebElement searchNavLabel;



    @FindBy(partialLinkText = " Listesi")
    public WebElement ShoppingList;

    @FindBy(id = "nav-item-signout")
    public WebElement SignOut;

    @FindBy(id = "nav-logo-sprites")
    public WebElement homePageLogo;

    @FindBy(id = "WLHUC_continue")
    public WebElement ContinueShopping;



}
