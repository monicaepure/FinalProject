package Pages.Veterinarians;

import Utils.InitializeTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditVeterinarianPage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);


    public EditVeterinarianPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By firstNameField = By.cssSelector("#firstName");
    private By lastNameField = By.cssSelector("#lastName");
    private By backButton = By.cssSelector("#vet_form [type=\"button\"]");
    private By submitButton = By.cssSelector("#vet_form [type=\"submit\"]");

    //________________________Methods________________________
    public void editFirstName(String firstName) {
        LOGGER.info("Edit first name");
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(submitButton).click();
    }

    public void editLastName(String lastName) {
        LOGGER.info("Edit last name");
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(submitButton).click();
    }


}
