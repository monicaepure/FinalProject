package Pages;

import Utils.InitializeTests;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    public WebDriver driver;
    public Logger LOGGER = LogManager.getLogger(InitializeTests.class);

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By title = By.cssSelector("body>app-root>app-welcome>h1");
    private By logo = By.cssSelector("body .row .col-md-12>img");


    //________________________Methods________________________
    public String getTitleName() {
        LOGGER.info("Getting the page title");
        return driver.findElement(title).getText();
    }

    public boolean isLogoDisplayed() {
        LOGGER.info("Verifiyng if the logo is displayed");
        return driver.findElement(logo).isDisplayed();
    }


}
