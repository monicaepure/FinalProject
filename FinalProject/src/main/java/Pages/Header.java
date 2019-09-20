package Pages;

import Utils.InitializeTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Header {
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);

    public WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By homeButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(1)");
    private By ownersButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(2)>a");
    private By allOwnersButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(2) ul li:nth-child(1)");
    private By addNewOwner = By.cssSelector("body .nav.navbar-nav>li:nth-child(2) ul li:nth-child(2)");
    private By veterinariansButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(3)");
    private By allVeterinariansButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(3) ul li:nth-child(1)");
    private By addNewVeterinariansButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(3) ul li:nth-child(2)");
    private By pettypesButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(4)");
    private By specialtiedButton = By.cssSelector("body .nav.navbar-nav>li:nth-child(5)");

    //________________________Methods_______________________
    public void clickOnHomeButton() {
        driver.findElement(homeButton).click();
    }

    public void clickOnOwnersButton() {
        LOGGER.info("Click on owners button");
        driver.findElement(ownersButton).click();
    }

    public void clickOnAllOwnersButton() {
        clickOnOwnersButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Click on all owners");
        driver.findElement(allOwnersButton).click();
    }

    public void clickOnAddNewOwner() {
        driver.findElement(ownersButton).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Click on add a new button");
        driver.findElement(addNewOwner).click();
    }

    public void clickOnVeterinariansButton() {
        LOGGER.info("Click on veterinarians button");
        driver.findElement(veterinariansButton).click();
    }

    public void clickOnAddAVet() {
        clickOnVeterinariansButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Click on add a veterinarian");
        driver.findElement(addNewVeterinariansButton).click();
    }

    public void clickOnAllVet() {
        clickOnVeterinariansButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Click on all veterinarians");
        driver.findElement(allVeterinariansButton).click();
    }

    public void clickOnPettypesButton() {
        driver.findElement(pettypesButton).click();
    }

    public void clickOnSpecialtiedButton() {
        driver.findElement(specialtiedButton).click();
    }
}
