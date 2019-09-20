package Pages.Veterinarians;

import Utils.InitializeTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AllVeterinariansPage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);


    public AllVeterinariansPage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By vetTableHeader = By.cssSelector(".table thead tr:first-child");
    private By vetTableTitle = By.cssSelector(".container.xd-container>h2");

    //________________________Methods_______________________

    public boolean vetTableContains(String vetName) {
        List<WebElement> vets = new ArrayList<WebElement>(driver.findElements(By.cssSelector("tbody tr>td:nth-child(1)")));
        for (WebElement vet : vets) {
            if (vet.getText().equals(vetName)) {
                LOGGER.info("Veterinarian " + vetName + " exists.");
                return true;
            }
        }
        LOGGER.info("Veterinarian " + vetName + " doesn't exists.");
        return false;
    }

    public boolean vetTableHeaderContains(String str) {
        if (driver.findElement(vetTableHeader).getText().contains(str)) {
            return true;
        }
        return false;
    }

    public String getVetTableTitle() {
        return driver.findElement(vetTableTitle).getText();
    }

    public void deleteVet(String vetName) throws InterruptedException {
        List<WebElement> vets = new ArrayList<WebElement>(driver.findElements(By.cssSelector("#vets tr>td:nth-child(1)")));
        for (int i = 0; i < vets.size(); i++) {
            if (vets.get(i).getText().equals(vetName)) {
                Thread.sleep(1000);
                LOGGER.info("Deleting the veterinarian: " + vetName);
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("#vets tr:nth-child(" + (i + 1) + ")>td:nth-child(3) button:last-child")).click();
            }
        }
        driver.navigate().refresh();
    }

    public void editVet(String vetName) throws InterruptedException {
        List<WebElement> vets = new ArrayList<WebElement>(driver.findElements(By.cssSelector("#vets tr>td:nth-child(1)")));
        for (int i = 0; i < vets.size(); i++) {
            if (vets.get(i).getText().equals(vetName)) {
                Thread.sleep(1000);
                LOGGER.info("Editing the veterinarian: " + vetName);
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("#vets tr:nth-child(" + (i + 1) + ")>td:nth-child(3) button:first-child")).click();
            }
        }
    }


}
