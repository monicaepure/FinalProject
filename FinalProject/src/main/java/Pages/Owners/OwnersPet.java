package Pages.Owners;

import Utils.InitializeTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class OwnersPet {

    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);


    public OwnersPet(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By nameField = By.cssSelector("#name");
    private By birthDate = By.cssSelector(".form-horizontal>div>input[name=\"birthDate\"]");
    private By type = By.cssSelector("#type");
    private By saveButton = By.cssSelector("button[type=\"submit\"]");

    //________________________Methods________________________
    public void typeName(String petName) {
        driver.findElement(nameField).sendKeys(petName);
    }

    public void typeBirthDate(String date) {
        driver.findElement(birthDate).sendKeys(date);
    }

    public void typePetType(String petType) {
        List<WebElement> petTypes = new ArrayList<WebElement>(driver.findElements(By.cssSelector("#type option")));
        for (int i = 0; i < petTypes.size(); i++) {
            if (petTypes.get(i).getText().equalsIgnoreCase("petType")) {
                driver.findElement(By.cssSelector("#type option:nth-child(" + (i + 1) + ")")).click();
            }
        }
    }

    public void clickOnSubmit() {
        driver.findElement(saveButton).click();
    }
}
