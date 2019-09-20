package Pages.Owners;

import Utils.InitializeTests;
import Utils.NewUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OwnerInformationPage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);

    NewUser newUser = new NewUser();

    public OwnerInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By editOwnerButton = By.cssSelector("body > app-root > app-owner-detail > div > div > button:nth-child(4)");
    private By addNewPetButton = By.cssSelector("<button _ngcontent-c5=\"\" class=\"btn btn-default\">Add New Pet</button>");

    //________________________Methods________________________
    public void clickOnEditButton() {
        driver.findElement(editOwnerButton).click();
    }

    public void clickOnAddNewPetButton() {
        driver.findElement(addNewPetButton).click();
    }


}
