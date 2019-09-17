package Pages.Owners;

import Utils.NewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AllOwnersPage {
    public WebDriver driver;

    NewUser newUser = new NewUser();

    public AllOwnersPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By ownersTableHeader = By.cssSelector(".table thead tr:first-child");
    private By ownersTableTitle = By.cssSelector(".container.xd-container>h2");

    //________________________Methods_______________________

    public boolean ownersTableContains(String str){
        List<WebElement> ownersName = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".ownerFullName a")));
        for ( WebElement owner : ownersName) {
            if(owner.getText().equalsIgnoreCase(str)){
                return true;
            }
        }
        return false;
    }

    public boolean ownersTableHeaderContains(String str) {
        if(driver.findElement(ownersTableHeader).getText().contains(str)){
            return true;
        }
        return false;
    }

    public String getOwnersTableTitle(){
        return driver.findElement(ownersTableTitle).getText();
    }
}
