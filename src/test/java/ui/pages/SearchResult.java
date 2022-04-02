package ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SearchResult {

    public SearchResult (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[contains(@class,'a-text-normal')]")
    public List<WebElement> allSearchItemList;



}
