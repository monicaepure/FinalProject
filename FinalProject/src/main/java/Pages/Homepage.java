package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Homepage {
    public WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    //________________________Locators_______________________
    private By title = By.cssSelector("body>app-root>app-welcome>h1");
    private By logo = By.cssSelector("body .row .img-responsive");


    //________________________Methods________________________
    public String getTitleName(){
        System.out.println("Getting the page title");
        return driver.findElement(title).getText();
    }

    public boolean isLogoDisplayed(){
        System.out.println("Verifiyng if the logo is displayed");
        return driver.findElement(logo).isDisplayed();
    }


}
