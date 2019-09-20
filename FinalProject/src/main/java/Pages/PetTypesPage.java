package Pages;

import Utils.InitializeTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PetTypesPage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);

    public PetTypesPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By petTableHeader = By.cssSelector(".table thead tr:first-child");
    private By petTableTitle = By.cssSelector(".container.xd-container>h2:first-child");
    private By homeButton = By.cssSelector(".container.xd-container>div button:nth-child(1)");
    private By addATypeButton = By.cssSelector("body > app-root > app-pettype-list > div > div > div > button:nth-child(2)");
    private By nameField = By.cssSelector("#name");
    private By saveButton = By.cssSelector("#pettype button");

    //________________________Fields__________________________
    private List<String> animalBreeds = new ArrayList<String>(List.of("Lion", "Mouse", "Wildcat", "Goat", "Chameleon", "Turkey", "Cheetah", "Panther", "Elephant", "Badger"));
    private Random random = new Random();
    public String petType = animalBreeds.get(random.nextInt(animalBreeds.size()));

    //________________________Methods_______________________
    public boolean petTableHeaderContains(String str) {
        if (driver.findElement(petTableHeader).getText().contains(str)) {
            return true;
        }
        return false;
    }

    public String petVetTableTitle() {
        return driver.findElement(petTableTitle).getText();
    }

    public void clikcOnAddAPet() throws InterruptedException {
        LOGGER.info("Click on add a new pet type");
        driver.findElement(addATypeButton).click();
        Thread.sleep(1000);
    }

    public void typePetType() {
        LOGGER.info("Enter the name of the pet type ");
        driver.findElement(nameField).sendKeys(petType);
    }

    public void clickOnSubmit() {
        LOGGER.info("Save the new type");
        driver.findElement(saveButton).click();
        driver.navigate().refresh();
    }

    public boolean verifyPetTableContains(String type) {
        //driver.navigate().refresh();
        List<WebElement> pets = new ArrayList<>(driver.findElements(By.cssSelector("#pettypes tbody td:first-child input")));
        for (WebElement pet : pets) {
            if (pet.getAttribute("value").equals(type)) {
                LOGGER.info("Pet type " + type + " exist.");
                System.out.println("Pet type " + type + " exists.");
                return true;
            }
        }
        LOGGER.info("Pet type " + type + " doesn't exist.");

        return false;
    }

    public void deleteAPetType(String pettype) throws InterruptedException {
        driver.navigate().refresh();
        List<WebElement> pets = new ArrayList<>(driver.findElements(By.cssSelector("#pettypes tbody td:first-child input")));
        for (int i = 0; i < pets.size(); i++) {
            if (pets.get(i).getAttribute("value").equals(pettype)) {
                LOGGER.info("Pet type " + pettype + " is deleted.");
                driver.findElement(By.cssSelector("#pettypes tbody tr:nth-child(" + (i + 1) + ") td:last-child button:last-child")).click();
            }
        }
        driver.navigate().refresh();
        LOGGER.info("after refresh");

    }
}
