package Pages.Owners;

import Utils.InitializeTests;
import Utils.NewUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOwnerPage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);
    NewUser newUser = new NewUser();

    public AddOwnerPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By firstNameField = By.cssSelector("#firstName");
    private By lastNameField = By.cssSelector("#lastName");
    private By addressField = By.cssSelector("#address");
    private By cityField = By.cssSelector("#city");
    private By telephoneField = By.cssSelector("#telephone");
    private By backButton = By.cssSelector(".container.xd-container button:nth-child(1)");
    private By submitButton = By.cssSelector(".container.xd-container button:nth-child(2)");

    public String firstName = newUser.getFirstName();
    public String lastName = newUser.getLastName();
    public String address = newUser.getAddress();
    public String city = newUser.getCity();
    public String telephone = newUser.getPhoneNo();

    //________________________Methods________________________

    public void typeFirstName() {
        LOGGER.info("Type first name");
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void typeLastName() {
        LOGGER.info("Type last name");
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void typeAddress() {
        LOGGER.info("Type address");
        driver.findElement(addressField).sendKeys(address);
    }

    public void typeCity() {
        LOGGER.info("Type city");
        driver.findElement(cityField).sendKeys(city);
    }

    public void typeTelephone() {
        LOGGER.info("Type telephone");
        driver.findElement(telephoneField).sendKeys(telephone);
    }

    public void clickOnSubmit() {
        LOGGER.info("Click on submit");

        driver.findElement(submitButton).click();
    }
    //________________________Methods with Params________________________

    public void typeFirstName(String firstNameP) {
        LOGGER.info("Type first name");
        driver.findElement(firstNameField).sendKeys(firstNameP);
    }

    public void typeLastName(String lastNameP) {
        LOGGER.info("Type last name");
        driver.findElement(lastNameField).sendKeys(lastNameP);
    }

    public void typeAddress(String addressP) {
        LOGGER.info("Type address");
        driver.findElement(addressField).sendKeys(addressP);
    }

    public void typeCity(String cityP) {
        LOGGER.info("Type city");
        driver.findElement(cityField).sendKeys(cityP);
    }

    public void typeTelephone(String telephoneP) {
        LOGGER.info("Type telephone");
        driver.findElement(telephoneField).sendKeys(telephoneP);
    }

    public void goToOwnerPage() {
        driver.findElement(backButton).click();
    }
}
