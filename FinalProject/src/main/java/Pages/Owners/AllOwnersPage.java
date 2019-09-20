package Pages.Owners;

import Utils.InitializeTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AllOwnersPage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);


    public AllOwnersPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By ownersTableHeader = By.cssSelector(".table thead tr:first-child");
    private By ownersTableTitle = By.cssSelector(".container.xd-container>h2");

    //________________________Methods_______________________

    public boolean ownersTableContains(String str) {
        List<WebElement> ownersName = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".ownerFullName a")));
        for (WebElement owner : ownersName) {
            if (owner.getText().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean ownersTableHeaderContains(String str) {
        if (driver.findElement(ownersTableHeader).getText().contains(str)) {
            return true;
        }
        return false;
    }

    public void clickOnOwner(String owner) {
        List<WebElement> ownersName = new ArrayList<WebElement>(driver.findElements(By.cssSelector(".ownerFullName a")));
        for (int i = 0; i < ownersName.size(); i++) {
            if (ownersName.get(i).getText().equalsIgnoreCase(owner)) {
                driver.findElement(By.cssSelector("tbody tr:nth-child(" + (i + 1) + ") td:first-child")).click();
            }
        }
    }


    public String getOwnersTableTitle() {
        return driver.findElement(ownersTableTitle).getText();
    }
}
