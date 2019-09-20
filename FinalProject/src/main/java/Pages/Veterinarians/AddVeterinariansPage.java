package Pages.Veterinarians;

import Utils.InitializeTests;
import Utils.NewUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class AddVeterinariansPage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);

    NewUser newUser = new NewUser();

    public AddVeterinariansPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By firstNameField = By.cssSelector("#firstName");
    private By lastNameField = By.cssSelector("#lastName");
    private By typeField = By.cssSelector("#specialties");
    private By backButton = By.cssSelector("#vet [type =\"button\"]");
    private By submitButton = By.cssSelector("#vet [type =\"submit\"]");

    //________________________Fields_____________________
    public String firstName = newUser.getFirstName();
    public String lastName = newUser.getLastName();


    //________________________Methods________________________
    public void addVet() {
        Select dropdown = new Select(driver.findElement(typeField));
        List<WebElement> options = dropdown.getOptions();
        Random random = new Random();
        LOGGER.info("Adding a new veterinarian");
        LOGGER.info("Insert first name");
        driver.findElement(firstNameField).sendKeys(firstName);
        LOGGER.info("Insert last name");
        driver.findElement(lastNameField).sendKeys(lastName);
        LOGGER.info("Select speciality");
        dropdown.selectByIndex(random.nextInt(options.size()));
        LOGGER.info("Submit entries");
        driver.findElement(submitButton).click();
    }

    public void goToVetPage() {
        driver.findElement(backButton).click();
    }

}
