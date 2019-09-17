package Pages.Owners;

import Utils.NewUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddOwnerPage {
    public WebDriver driver;

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
    public void addOwner(){
        System.out.println("Adding a new owner");
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(telephoneField).sendKeys(telephone);
        driver.findElement(submitButton).click();
    }

    public void goToOwnerPage(){
        driver.findElement(backButton).click();
    }
}
